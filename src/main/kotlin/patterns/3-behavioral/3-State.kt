package org.example.patterns.`3-behavioral`

class MediaPlayer {
    var state: MediaPlayerState = StoppedState()
    fun play() = state.play(this)
    fun stop() = state.stop(this)
    fun pause() = state.pause(this)
}

interface MediaPlayerState {
    fun play(mediaPlayer: MediaPlayer)
    fun stop(mediaPlayer: MediaPlayer)
    fun pause(mediaPlayer: MediaPlayer)
}

class PlayingState : MediaPlayerState {
    override fun play(mediaPlayer: MediaPlayer): Unit {}
    override fun stop(mediaPlayer: MediaPlayer) {
        println("[INFO] stopping the media")
        mediaPlayer.state = StoppedState()
    }

    override fun pause(mediaPlayer: MediaPlayer) {
        println("[INFO] pausing the media")
        mediaPlayer.state = PausedState()
    }
}

class StoppedState : MediaPlayerState {
    override fun play(mediaPlayer: MediaPlayer) {
        println("[INFO] playing media...")
        mediaPlayer.state = PlayingState()
    }

    override fun stop(mediaPlayer: MediaPlayer) {}
    override fun pause(mediaPlayer: MediaPlayer) = println("[INFO] Cannot pause stopped media")

}

class PausedState : MediaPlayerState {
    override fun play(mediaPlayer: MediaPlayer) {
        println("[INFO] resuming...")
        mediaPlayer.state = PlayingState()
    }

    override fun stop(mediaPlayer: MediaPlayer) {
        println("[INFO] stopping the media")
        mediaPlayer.state = StoppedState()
    }

    override fun pause(mediaPlayer: MediaPlayer) {}
}

fun main(){
    val mediaPlayer = MediaPlayer()

    mediaPlayer.play()
    mediaPlayer.pause()
    mediaPlayer.play()
    mediaPlayer.pause()
    mediaPlayer.stop()
    mediaPlayer.pause()
}