package domain.subscribers.stereoSystems

import domain.pubishers.Soundable
import domain.model.Noisiness
import domain.subscribers.Hearable

const val COMMON_FREQUENCY = 424.3

data class StereoSystem(
    private var frequency: Double = 100.0
) : Frequenceable, Hearable {

    override fun tuneToFrequency(frequency: Double, noisiness: Noisiness) {
        this.frequency = frequency
        println("$this $noisiness turn to frequency ${this.frequency}")
    }

    override fun hear(soundable: Soundable) {
        println("$this hear $soundable")
        tuneToFrequency(COMMON_FREQUENCY, Noisiness.QUITE)
    }
}

data class Radio(
    private var frequency: Double = 100.0
) : Frequenceable, Hearable {

    override fun tuneToFrequency(frequency: Double, noisiness: Noisiness) {
        this.frequency = frequency
        println("$this $noisiness turn to frequency ${this.frequency}")
    }

    override fun hear(soundable: Soundable) {
        println("$this hear $soundable")
        tuneToFrequency(COMMON_FREQUENCY, Noisiness.QUITE)
    }
}

data class TV(
    private var frequency: Double = 100.0
) : Frequenceable, Hearable {

    override fun tuneToFrequency(frequency: Double, noisiness: Noisiness) {
        this.frequency = frequency
        println("$this $noisiness turn to frequency ${this.frequency}")
    }

    override fun hear(soundable: Soundable) {
        println("$this hear $soundable")
        tuneToFrequency(COMMON_FREQUENCY, Noisiness.QUITE)
    }
}

data class RecordPlayer(
    private var frequency: Double = 100.0
) : Frequenceable, Hearable {

    override fun tuneToFrequency(frequency: Double, noisiness: Noisiness) {
        this.frequency = frequency
        println("$this $noisiness turn to frequency ${this.frequency}")
    }

    override fun hear(soundable: Soundable) {
        println("$this hear $soundable")
        tuneToFrequency(COMMON_FREQUENCY, Noisiness.QUITE)
    }
}

data class LoudSpeaker(
    private var frequency: Double = 100.0
) : Frequenceable, Hearable {

    override fun tuneToFrequency(frequency: Double, noisiness: Noisiness) {
        this.frequency = frequency
        println("$this $noisiness turn to frequency ${this.frequency}")
    }

    override fun hear(soundable: Soundable) {
        println("$this hear $soundable")
        tuneToFrequency(COMMON_FREQUENCY, Noisiness.QUITE)
    }
}

data class Speaker(
    private var frequency: Double = 100.0
) : Frequenceable, Hearable {

    override fun tuneToFrequency(frequency: Double, noisiness: Noisiness) {
        this.frequency = frequency
        println("$this $noisiness turn to frequency ${this.frequency}")
    }

    override fun hear(soundable: Soundable) {
        println("$this hear $soundable")
        tuneToFrequency(COMMON_FREQUENCY, Noisiness.QUITE)
    }
}
