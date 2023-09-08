package com.rtarita.skull.common

import kotlinx.serialization.json.Json

public object CommonConstants {
    public const val USER_ID_CLAIM: String = "userid"
    public const val WIN_WITH_POINTS: Int = 2
    public const val WEBSOCKET_PING_PERIOD_SECONDS: Long = 10
    public const val WEBSOCKET_TIMEOUT_SECONDS: Long = 30
    public const val WEBSOCKET_MAX_FRAME_SIZE: Long = 128

    public val defaultHand: List<Card> = listOf(Card.ROSE, Card.ROSE, Card.ROSE, Card.SKULL)
    public val json: Json = Json {
        encodeDefaults = true
        isLenient = true
        classDiscriminator = "__TYPE__"
    }
}
