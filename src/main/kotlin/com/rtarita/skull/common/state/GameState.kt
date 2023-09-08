package com.rtarita.skull.common.state

import com.rtarita.skull.common.CommonConstants
import kotlinx.serialization.Serializable

@Serializable
public data class GameState(
    val numPlayers: Int,
    val roundCount: Int = 0,
    val lastRoundBeginner: Int = -1,
    val currentTurn: Int = -1,
    val currentTurnMode: TurnMode = TurnMode.FIRST_CARD,
    val cardsAvailable: Map<Int, List<Card>> = (0 until numPlayers).associateWith { CommonConstants.defaultHand },
    val cardsOnTable: Map<Int, List<Card>> = (0 until numPlayers).associateWith { emptyList() },
    val cardsInHand: Map<Int, List<Card>> = cardsAvailable,
    val bids: Map<Int, Int> = (0 until numPlayers).associateWith { 0 },
    val revealedCards: List<Pair<Int, Int>> = emptyList(),
    val points: Map<Int, Int> = (0 until numPlayers).associateWith { 0 }
)
