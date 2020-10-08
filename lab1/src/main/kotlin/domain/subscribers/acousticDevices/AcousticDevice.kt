package domain.subscribers.acousticDevices

import domain.pubishers.Soundable
import domain.subscribers.Hearable
import domain.model.Contamination

data class Tin(
    private var contamination: Contamination,
    private var isAcousticDevice: Boolean = false
) : TurnableToAcoustic, Hearable {

    override fun turnToAcoustic() {
        isAcousticDevice = true
        println("$this turn to acoustic device")
    }

    override fun hear(soundable: Soundable) {
        println("$this hear $soundable")
        turnToAcoustic()
    }
}

data class Bin(
    private var isAcousticDevice: Boolean = false
) : TurnableToAcoustic, Hearable {

    override fun turnToAcoustic() {
        isAcousticDevice = true
        println("$this turn to acoustic device")
    }

    override fun hear(soundable: Soundable) {
        println("$this hear $soundable")
        turnToAcoustic()
    }
}

data class Window(
    private var isAcousticDevice: Boolean = false
) : TurnableToAcoustic, Hearable {

    override fun turnToAcoustic() {
        isAcousticDevice = true
        println("$this turn to acoustic device")
    }

    override fun hear(soundable: Soundable) {
        println("$this hear $soundable")
        turnToAcoustic()
    }
}

data class Car (
    private var isAcousticDevice: Boolean = false
) : TurnableToAcoustic, Hearable {

    override fun turnToAcoustic() {
        isAcousticDevice = true
        println("$this turn to acoustic device")
    }

    override fun hear(soundable: Soundable) {
        println("$this hear $soundable")
        turnToAcoustic()
    }
}

data class Glass(
    private var isAcousticDevice: Boolean = false
) : TurnableToAcoustic, Hearable {

    override fun turnToAcoustic() {
        isAcousticDevice = true
        println("$this turn to acoustic device")
    }

    override fun hear(soundable: Soundable) {
        println("$this hear $soundable")
        turnToAcoustic()
    }
}
