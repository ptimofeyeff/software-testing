package domain

import domain.model.Contamination
import domain.model.Location
import domain.model.Noisiness
import domain.pubishers.Whisper
import domain.subscribers.acousticDevices.*
import domain.subscribers.stereoSystems.*

fun main() {
    val whisper = Whisper(
        Noisiness.LOUDLY,
        Location.AIR,
        comprehensive = true,
        ArrayList(
            listOf(
                Radio(), TV(), RecordPlayer(), LoudSpeaker(), Speaker(), StereoSystem(),
                Tin(Contamination.RUSTY), Tin(Contamination.PURE), Bin(), Window(), Car(), Glass()
            )
        )
    )

    whisper.rangOut()
}