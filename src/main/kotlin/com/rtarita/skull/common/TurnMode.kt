package com.rtarita.skull.common

import kotlinx.serialization.Serializable

@Serializable
public enum class TurnMode {
    FIRST_CARD,
    LAY,
    BID,
    GUESS
}
