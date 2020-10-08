package domain

import domain.subscribers.Hearable
import domain.subscribers.acousticDevices.*
import domain.model.Location
import domain.model.Noisiness
import domain.pubishers.Whisper
import domain.model.Contamination
import domain.subscribers.stereoSystems.*

fun main() {
    val whisper = Whisper(
        Noisiness.LOUDLY,
        Location.AIR,
        comprehensive = true,
        arrayOf(
            Radio(), TV(), RecordPlayer(), LoudSpeaker(), Speaker(), StereoSystem(),
            Tin(Contamination.RUSTY), Tin(Contamination.PURE), Bin(), Window(), Car(), Glass()
        ).toList() as ArrayList<Hearable>
    )

    whisper.rangOut()
}