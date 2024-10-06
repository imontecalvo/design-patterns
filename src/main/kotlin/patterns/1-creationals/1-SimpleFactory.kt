package org.example.patterns.creationals

enum class MobType {
    SKELETON,
    ZOMBIE
}

abstract class Mob(var hp: Int, var damage: Int) {
    abstract fun hit();
    abstract fun makeSound();
}

class Skeleton : Mob(100, 200) {
    override fun hit() {
        println("Arrow damage: $damage")
    }

    override fun makeSound() {
        println("click click")
    }

}

class Zombie : Mob(200, 150) {
    override fun hit() {
        println("Bite damage: $damage ")
    }

    override fun makeSound() {
        println("berrr berrr")
    }
}

object MobFactory {
    fun create(mob: MobType): Mob {
        return when (mob) {
            MobType.SKELETON -> Skeleton()
            MobType.ZOMBIE -> Zombie()
        }
    }
}

fun main() {
    val skeleton = MobFactory.create(MobType.SKELETON);
    skeleton.makeSound()
    skeleton.hit()

    val zombie = MobFactory.create(MobType.ZOMBIE);
    zombie.makeSound()
    zombie.hit()
}