package org.example.patterns.`3-behavioral`

interface Observer {
    fun update(msg: String)
}

abstract class Observable {
    private val subscribers: MutableList<Observer> = ArrayList()
    fun subscribe(subscriber: Observer) = subscribers.addLast(subscriber)
    fun unsubscribe(subscriber: Observer) = subscribers.remove(subscriber)
    fun notify(msg: String) {
        subscribers.forEach { it.update(msg) }
    }
}

class YouTubeAccount(private val username: String) : Observer, Observable() {
    override fun update(msg: String) = println("Hi $username\n$msg\n")
    fun uploadVideo(title: String) = notify("[INFO] $username has uploaded a new video: '$title' !")
}

fun main(){
    val channel1 = YouTubeAccount("elrubius")
    val channel2 = YouTubeAccount("willyrex")

    channel1.subscribe(channel2)
    channel1.uploadVideo("skyrim gameplay 1/2")
    channel1.unsubscribe(channel2)
    channel1.uploadVideo("skyrim gameplay 2/2")
}