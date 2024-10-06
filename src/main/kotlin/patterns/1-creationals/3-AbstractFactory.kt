package org.example.patterns.creationals

abstract class Shirt
abstract class Trousers
abstract class Shoes

class SportShirt : Shirt()
class TShirt : Shirt()
class SmokingShirt : Shirt()

class FootballShorts : Trousers()
class Jeans : Trousers()
class SmokingTrousers : Trousers()

class SportShoes : Shoes()
class CasualShoes : Shoes()
class SmokingShoes : Shoes()

interface ClothesFactory{
    fun createShirt():Shirt
    fun createShoes():Shoes
    fun createTrousers():Trousers
}

class SportClothesFactory: ClothesFactory{
    override fun createShirt(): Shirt = SportShirt()
    override fun createTrousers(): Trousers = FootballShorts()
    override fun createShoes(): Shoes = SportShoes()
}

class CasualClothesFactory: ClothesFactory{
    override fun createShirt(): Shirt = TShirt()
    override fun createTrousers(): Trousers = Jeans()
    override fun createShoes(): Shoes = CasualShoes()
}

class SmokingClothesFactory: ClothesFactory{
    override fun createShirt(): Shirt = SmokingShirt()
    override fun createTrousers(): Trousers = SmokingTrousers()
    override fun createShoes(): Shoes = SmokingShoes()
}

fun main(){
    val input = "casual"
    val factories = mapOf(
        "sport" to SportClothesFactory(),
        "casual" to CasualClothesFactory(),
        "smoking" to SmokingClothesFactory()
    )
    dress(factories[input]!!)
}

fun dress(factory: ClothesFactory){
    val shirt = factory.createShirt()
    val trousers = factory.createTrousers()
    val shoes = factory.createShoes()
    println("Shirt: $shirt, Trousers: $trousers, Shoes: $shoes")
}