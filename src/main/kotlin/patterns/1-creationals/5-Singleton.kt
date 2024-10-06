package org.example.patterns.creationals

object SingletonJuan {
    var name = "Juan"
    var age = 120
    var gender = "male"

    fun walk() = println("walking...")
    fun eat() = println("eating...")
    override fun toString(): String {
        return "SingletonJuan(name='$name', age=$age, gender='$gender')"
    }
}


fun main() {
    SingletonJuan.walk()
    SingletonJuan.eat()
    println(SingletonJuan)
}