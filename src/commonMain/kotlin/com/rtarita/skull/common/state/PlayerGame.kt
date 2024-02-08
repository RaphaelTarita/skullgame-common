package com.rtarita.skull.common.state

import kotlinx.serialization.Serializable

@Serializable
public data class PlayerGame(
    val gameId: String,
    val isRunning: Boolean,
    val isInitiator: Boolean
)