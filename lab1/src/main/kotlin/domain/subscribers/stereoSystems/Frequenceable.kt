package domain.subscribers.stereoSystems

import domain.model.Noisiness

interface Frequenceable {
    fun tuneToFrequency(frequency: Double, noisiness: Noisiness)
}
