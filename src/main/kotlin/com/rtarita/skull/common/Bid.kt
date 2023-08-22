package com.rtarita.skull.common

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
@SerialName("Bid")
public data class Bid(val bid: Int) : Move {
    override fun toString(): String {
        return "Bid: $bid"
    }
}
