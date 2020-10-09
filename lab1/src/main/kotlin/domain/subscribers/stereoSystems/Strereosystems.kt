package domain.subscribers.stereoSystems

import domain.model.Noisiness
import domain.pubishers.Soundable

const val COMMON_FREQUENCY = 424.3
const val DEFAULT_FREQUENCY = 100.0

data class StereoSystem(
    private var frequency: Double = DEFAULT_FREQUENCY
) : Frequenceable {

    override fun tuneToFrequency(frequency: Double, noisiness: Noisiness) {
        this.frequency = frequency
        println("$this $noisiness turn to frequency ${this.frequency}")
    }

    override fun hear(soundable: Soundable) {
        println("$this hear $soundable")
        tuneToFrequency(COMMON_FREQUENCY, Noisiness.QUITE)
    }

    override fun toDefaultFrequency() {
        this.frequency = DEFAULT_FREQUENCY
    }
}

data class Radio(
    private var frequency: Double = DEFAULT_FREQUENCY
) : Frequenceable {

    override fun tuneToFrequency(frequency: Double, noisiness: Noisiness) {
        this.frequency = frequency
        println("$this $noisiness turn to frequency ${this.frequency}")
    }

    override fun hear(soundable: Soundable) {
        println("$this hear $soundable")
        tuneToFrequency(COMMON_FREQUENCY, Noisiness.QUITE)
    }

    override fun toDefaultFrequency() {
        this.frequency = DEFAULT_FREQUENCY
    }
}

data class TV(
    private var frequency: Double = DEFAULT_FREQUENCY
) : Frequenceable {

    override fun tuneToFrequency(frequency: Double, noisiness: Noisiness) {
        this.frequency = frequency
        println("$this $noisiness turn to frequency ${this.frequency}")
    }

    override fun hear(soundable: Soundable) {
        println("$this hear $soundable")
        tuneToFrequency(COMMON_FREQUENCY, Noisiness.QUITE)
    }

    override fun toDefaultFrequency() {
        this.frequency = DEFAULT_FREQUENCY
    }
}

data class RecordPlayer(
    private var frequency: Double = DEFAULT_FREQUENCY
) : Frequenceable {

    override fun tuneToFrequency(frequency: Double, noisiness: Noisiness) {
        this.frequency = frequency
        println("$this $noisiness turn to frequency ${this.frequency}")
    }

    override fun hear(soundable: Soundable) {
        println("$this hear $soundable")
        tuneToFrequency(COMMON_FREQUENCY, Noisiness.QUITE)
    }

    override fun toDefaultFrequency() {
        this.frequency = DEFAULT_FREQUENCY
    }
}

data class LoudSpeaker(
    private var frequency: Double = DEFAULT_FREQUENCY
) : Frequenceable {

    override fun tuneToFrequency(frequency: Double, noisiness: Noisiness) {
        this.frequency = frequency
        println("$this $noisiness turn to frequency ${this.frequency}")
    }

    override fun hear(soundable: Soundable) {
        println("$this hear $soundable")
        tuneToFrequency(COMMON_FREQUENCY, Noisiness.QUITE)
    }

    override fun toDefaultFrequency() {
        this.frequency = DEFAULT_FREQUENCY
    }
}

data class Speaker(
    private var frequency: Double = DEFAULT_FREQUENCY
) : Frequenceable {

    override fun tuneToFrequency(frequency: Double, noisiness: Noisiness) {
        this.frequency = frequency
        println("$this $noisiness turn to frequency ${this.frequency}")
    }

    override fun hear(soundable: Soundable) {
        println("$this hear $soundable")
        tuneToFrequency(COMMON_FREQUENCY, Noisiness.QUITE)
    }

    override fun toDefaultFrequency() {
        this.frequency = DEFAULT_FREQUENCY
    }
}
