package com.rtarita.skull.common

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
@SerialName("RoundEnded")
public data class RoundEnded(val outcome: RoundOutcome, val playerIndex: Int) : MoveOutcome {
    override fun toString(): String {
        return "round ended (player #$playerIndex ${
            when (outcome) {
                RoundOutcome.WON -> "won"
                RoundOutcome.LOST -> "lost"

            }
        })"
    }
}