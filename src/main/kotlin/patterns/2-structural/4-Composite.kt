package org.example.patterns.`2-structural`

import java.util.*

interface FileSystemComponent {
    fun showProperties(prefix:String="")
}

class File(private val name: String) : FileSystemComponent {
    private val date = Date()
    override fun showProperties(prefix:String) = println("$prefix$name - [$date]")
}

class Directory(private val name: String) : FileSystemComponent {
    private val date = Date()
    private val children: MutableList<FileSystemComponent> = ArrayList()

    fun addChild(child: FileSystemComponent) = children.addLast(child)
    fun addChildren(vararg newChildren: FileSystemComponent) = newChildren.forEach { addChild(it) }
    fun removeChild(child: FileSystemComponent) = children.remove(child)

    override fun showProperties(prefix:String) {
        println("$prefix$name - [$date]")
        children.forEach { it.showProperties(prefix+"\t") }
    }
}

fun main() {
    val file1 = File("main.py")
    val file2 = File("main.java")
    val file3 = File("main.kt")
    val file4 = File("foto.png")
    val file5 = File("dto.java")

    val rootDir = Directory("root")
    val dir1 = Directory("python_project")
    val dir2 = Directory("java_project")
    val dir3 = Directory("kotlin_project")

    rootDir.addChildren(dir1, dir2, dir3, file4)
    dir1.addChild(file1)
    dir2.addChildren(file2, file5)
    dir3.addChild(file3)

    rootDir.showProperties()
}