package com.rtarita.skull.common

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
@SerialName("GameEnded")
public data class GameEnded(val winningPlayerIndex: Int) : MoveOutcome {
    override fun toString(): String {
        return "game ended (player #$winningPlayerIndex won the game)"
    }
}
