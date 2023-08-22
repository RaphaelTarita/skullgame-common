package com.rtarita.skull.common

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
@SerialName("Guess")
public data class Guess(val otherPlayerIndex: Int, val cardIndex: Int) : Move {
    override fun toString(): String {
        return "Reveal card #$cardIndex of player $cardIndex"
    }
}