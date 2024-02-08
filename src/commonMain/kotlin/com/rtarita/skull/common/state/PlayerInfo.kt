package com.rtarita.skull.common.state

import kotlinx.serialization.Serializable

@Serializable
public data class PlayerInfo(
    val userId: String,
    val displayName: String,
    val isInitiator: Boolean,
    val playerIndex: Int
)