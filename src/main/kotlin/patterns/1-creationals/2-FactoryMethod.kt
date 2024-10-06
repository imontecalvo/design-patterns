package org.example.patterns.creationals

abstract class Pizza{
    fun cook(){
        println("cooking pizza...")
    }
}
class PizzaMozzarella : Pizza()
class PizzaFugazzeta : Pizza()

abstract class PizzaFactory{
    abstract fun create(): Pizza;
    fun preparePizza():Pizza{
        val pizza: Pizza = create()
        pizza.cook()
        return pizza
    }
}

class PizzaMozzarellaFactory : PizzaFactory(){
    override fun create():Pizza{
        return PizzaMozzarella()
    }
}

class PizzaFugazzetaFactory : PizzaFactory(){
    override fun create():Pizza{
        return PizzaFugazzeta()
    }
}

