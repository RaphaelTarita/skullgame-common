package com.rtarita.skull.common.moves

import com.rtarita.skull.common.state.Card
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
@SerialName("Lay")
public data class Lay(val card: Card) : Move {
    override fun toString(): String {
        return "Lay: $card"
    }
}
