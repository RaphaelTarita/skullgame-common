package com.rtarita.skull.common.moves

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
@SerialName("BadMove")
public data class BadMove(val reason: String) : MoveOutcome {
    override fun toString(): String {
        return "bad move: $reason"
    }
}
