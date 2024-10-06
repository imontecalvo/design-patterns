package org.example.patterns.`2-structural`

interface Engine{
    fun start()
    fun stop()
}

class ElectricEngine{
    fun chargeEngine() = println("charging electric engine")
    fun startEngine() = println("starting electric engine")
    fun turnOffEngine() = println("stopping electric engine")
}

class ElectricEngineAdapter(private val engine: ElectricEngine) : Engine{
    override fun start() {
        engine.chargeEngine()
        engine.startEngine()
    }

    override fun stop() {
        engine.turnOffEngine()
    }
}

class GasEngine : Engine{
    override fun start() = println("starting gas engine")
    override fun stop() = println("stopping gas engine")
}

class DieselEngine : Engine{
    override fun start() = println("starting diesel engine")
    override fun stop() = println("stopping diesel engine")
}

class Car(private var engine: Engine){
    fun start(){
        engine.start()
        println("starting the car")
    }
}

fun main(){
    val gasEngine = GasEngine()
    val dieselEngine = DieselEngine()
    val electricEngine = ElectricEngine()
    val electricEngineAdapter = ElectricEngineAdapter(electricEngine)

    Car(gasEngine).start()
    Car(dieselEngine).start()
    Car(electricEngineAdapter).start()
}