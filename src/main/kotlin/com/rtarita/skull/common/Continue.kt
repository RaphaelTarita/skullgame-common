package com.rtarita.skull.common

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
@SerialName("Continue")
public data class Continue(val nextPlayerIndex: Int) : MoveOutcome {
    override fun toString(): String {
        return "game continues (next player is #$nextPlayerIndex)"
    }
}
