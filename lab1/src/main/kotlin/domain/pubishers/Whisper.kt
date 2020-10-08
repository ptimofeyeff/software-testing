package domain.pubishers

import domain.model.Location
import domain.model.Noisiness
import domain.subscribers.Hearable

data class Whisper(
    private var noisiness: Noisiness,
    private var location: Location,
    private var comprehensive: Boolean,
    private val hearables: ArrayList<Hearable>
) : Soundable {

    fun rangOut() {
        println("rang out $this")
        makeSound()
    }

    override fun subscribe(sub: Hearable) {
        hearables.add(sub)
    }

    override fun unsubscribe(sub: Hearable) {
        hearables.remove(sub)
    }

    override fun makeSound() {
        if (comprehensive) {
            hearables.forEach {
                it.hear(this)
            }
        } else {
            hearables.forEach {
                if (Math.random() > 0.5) {
                    it.hear(this)
                }
            }
        }
    }

    override fun toString(): String {
        return "Whisper(noisiness=$noisiness, location=$location, comprehensive=$comprehensive)"
    }

}

