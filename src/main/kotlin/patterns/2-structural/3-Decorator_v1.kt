package org.example.patterns.`2-structural`

interface Sword{
    fun attack();
}

class BasicSword:Sword{
    override fun attack() = println("attacking...")
}

abstract class SwordDecorator(private val child: Sword): Sword{
    override fun attack(){
        child.attack()
    }
}

class DamageBoostDecorator(child:Sword):SwordDecorator(child){
    override fun attack(){
        println("Increasing damage...")
        super.attack()
    }
}

class FreezeEffectDecorator(child:Sword):SwordDecorator(child){
    override fun attack(){
        println("Adding freezing effect...")
        super.attack()
    }
}

fun main(){
    val sword = BasicSword()
    val damageDecorator = DamageBoostDecorator(sword)
    val freezingDecorator = FreezeEffectDecorator(damageDecorator)

    freezingDecorator.attack()
}