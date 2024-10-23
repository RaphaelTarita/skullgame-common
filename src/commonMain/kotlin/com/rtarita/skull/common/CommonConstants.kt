package com.rtarita.skull.common

import com.rtarita.skull.common.state.Card
import kotlinx.serialization.json.Json
import kotlin.time.Duration

public object CommonConstants {
    public const val USER_ID_CLAIM: String = "userid"
    public const val WIN_WITH_POINTS: Int = 2
    public const val WEBSOCKET_MAX_FRAME_SIZE: Long = 128

    public val WEBSOCKET_PING_PERIOD: Duration = with(Duration) { 10.seconds }
    public val WEBSOCKET_TIMEOUT: Duration = with(Duration) { 30.seconds }

    public val defaultHand: List<Card> = listOf(Card.ROSE, Card.ROSE, Card.ROSE, Card.SKULL)
    public val json: Json = Json {
        encodeDefaults = true
        isLenient = true
        classDiscriminator = "__TYPE__"
    }
}
