package domain.pubishers

import domain.subscribers.Hearable

interface Soundable {
    fun subscribe(sub: Hearable)
    fun unsubscribe(sub: Hearable)
    fun makeSound()
}