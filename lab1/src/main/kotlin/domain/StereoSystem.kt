package domain

interface StereoSystem {
    fun tuneToFrequency(frequency: Double)
    fun sound()
}

class Radio(
    private var frequency: Double
): StereoSystem {

    override fun tuneToFrequency(frequency: Double) {
        this.frequency = frequency
    }

    override fun sound() {
        println("I am radio, and I am sound on $frequency")
    }
}

class TV: StereoSystem {
    override fun tuneToFrequency(frequency: Double) {
        TODO("Not yet implemented")
    }

    override fun sound() {
        println("I am radio, and I am sound in frequency")
    }
}
class RecordPlayer: StereoSystem {
    override fun tuneToFrequency(frequency: Double) {
        TODO("Not yet implemented")
    }

    override fun sound() {
        TODO("Not yet implemented")
    }
}
class LoudSpeaker: StereoSystem {
    override fun tuneToFrequency(frequency: Double) {
        TODO("Not yet implemented")
    }

    override fun sound() {
        TODO("Not yet implemented")
    }
}
class Speaker: StereoSystem {
    override fun tuneToFrequency(frequency: Double) {
        TODO("Not yet implemented")
    }

    override fun sound() {
        TODO("Not yet implemented")
    }
}