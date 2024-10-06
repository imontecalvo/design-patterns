package org.example.patterns.`2-structural`

import java.math.BigDecimal

interface DataSource{
    fun write(data: String)
    fun read(data: String):String
}

class FileDataSource:DataSource{
    override fun write(data:String) = println("writing: $data")
    override fun read(data:String):String = data
}

abstract class DataSourceDecorator(private val child: DataSource):DataSource{
    override fun write(data:String) = child.write(data)
    override fun read(data:String):String = child.read(data)
}

class EncryptionDecorator(child: DataSource):DataSourceDecorator(child){
    override fun write(data: String){
        val encodedData = data.map{it.code}.joinToString("-")
        super.write(encodedData)
    }

    override fun read(data: String):String{
        val dataRcv = super.read(data)
        return dataRcv.split("-").map { Char(it.toInt()) }.joinToString("")
    }
}

class CompressionDecorator(child: DataSource):DataSourceDecorator(child){
    override fun write(data: String){
        val compressedData = "AAA-$data-AAA"
        super.write(compressedData)
    }

    override fun read(data: String):String{
        val dataRcv = super.read(data)
        return dataRcv.substring(4,dataRcv.length-4)
    }
}

fun main(){
    val file = FileDataSource()
    val compressionDecorator = CompressionDecorator(file)
    val encryptionDecorator = EncryptionDecorator(compressionDecorator)

    encryptionDecorator.write("Text for test :)")
    val decoded = encryptionDecorator.read("AAA-84-101-120-116-32-102-111-114-32-116-101-115-116-32-58-41-AAA")
    println("reading: $decoded")
}