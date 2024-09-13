package org.example._4classesandinterface

/**
 * @author Piyush Kumar.
 * @since 13/09/24.
 */


interface Downloader {

    fun download()
}

interface Player {
    fun play()
}

class DownloaderImpl(private val name: String) : Downloader {
    override fun download() {
        println("Downloaded.")
    }

}

class PlayerImpl(private val name: String) : Player {
    override fun play() {
        println("Player.")
    }

}

class MediaPlayer(private val d: Downloader, private val p: Player) : Downloader, Player { // Conventional way of composing/delegating calls.

    override fun download() {
        d.download()
    }

    override fun play() {
        p.play()
    }
}

// Kotlin way of composing/delegating calls. Removes boilerplate code
class MediaPlayer2(private val d: Downloader, private val p: Player) : Downloader by d, Player by p

// We can also override the delegating methods too.
class MediaPlayer3(private val d: Downloader, private val p: Player) : Downloader by d, Player by p{

    override fun play() {
        println("Overriding delegating method")
        p.play()
    }
}
fun main(){

    val downloader = DownloaderImpl("MyDownloader")
    val player = PlayerImpl("MyPlayer")

    val mediaPlayer = MediaPlayer(downloader, player)

    mediaPlayer.download()
    mediaPlayer.play()

    val mediaPlayer2 = MediaPlayer2(downloader, player)
    mediaPlayer2.download()
    mediaPlayer2.play()

    val mediaPlayer3 = MediaPlayer3(downloader, player)
    mediaPlayer3.download()
    mediaPlayer3.play()
}