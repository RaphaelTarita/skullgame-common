package com.rtarita.skull.common.condition

// avoid re-instantiation of lambda inside getter

internal val signalPredicate: (Unit) -> Boolean = { true }
internal val isTruePredicate: (Boolean) -> Boolean = { it }
internal val isFalsePredicate: (Boolean) -> Boolean = { !it }
