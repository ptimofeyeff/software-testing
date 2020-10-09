package domain.subscribers.stereoSystems

import domain.model.Noisiness
import domain.subscribers.Hearable

interface Frequenceable : Hearable {
    fun tuneToFrequency(frequency: Double, noisiness: Noisiness)

    fun toDefaultFrequency()
}
