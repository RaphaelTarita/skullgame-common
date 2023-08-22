package com.rtarita.skull.common

import kotlinx.serialization.Serializable

@Serializable
public data class PlayerGameState(
    val playerIndex: Int,
    val numPlayers: Int,
    val roundCount: Int,
    val lastRoundBeginner: Int,
    val currentTurn: Int,
    val currentTurnMode: TurnMode,
    val ownCardsAvailable: List<Card>,
    val allCardsAvailable: Map<Int, Int>,
    val ownCardsOnTable: List<Card>,
    val allCardsOnTable: Map<Int, Int>,
    val ownCardsInHand: List<Card>,
    val allCardsInHand: Map<Int, Int>,
    val bids: Map<Int, Int>,
    val revealedCards: Map<Int, List<Pair<Int, Card>>>,
    val points: Map<Int, Int>
)