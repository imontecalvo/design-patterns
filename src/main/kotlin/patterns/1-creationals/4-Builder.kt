package org.example.patterns.creationals

enum class DoorTypes{
    THREE,
    FIVE,
    SEVEN
}

abstract class Engine
class ElectricalEngine : Engine()
class GasEngine : Engine()

class Car{
    var doors: DoorTypes? = null
    var engine: Engine? = null
    var wheels: Int? = null

    override fun toString(): String {
        return "Car(doors=$doors, engine=$engine, wheels=$wheels)"
    }
}

class CarBuilder{
    private val car:Car = Car()

    fun setWheels(wheels: Int):CarBuilder {
        car.wheels = wheels
        return this
    }

    fun setDoors(doors: DoorTypes):CarBuilder{
        car.doors = doors
        return this
    }

    fun setEngine(engine: Engine):CarBuilder{
        car.engine = engine
        return this
    }

    fun build():Car{
        return car
    }
}

fun main(){
    val car = CarBuilder()
        .setEngine(ElectricalEngine())
        .setDoors(DoorTypes.THREE)
        .setWheels(4)
        .build()

    println(car)
}