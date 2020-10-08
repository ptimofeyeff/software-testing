package domain.subscribers

import domain.pubishers.Soundable

interface Hearable {
    fun hear(soundable: Soundable)
}