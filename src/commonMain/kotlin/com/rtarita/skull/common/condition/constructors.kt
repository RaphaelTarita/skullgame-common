package com.rtarita.skull.common.condition

public fun <T : Any> conflatedCondition(
    initial: T?,
    defaultPredicate: (T) -> Boolean
): ConflatedCondition<T> = ConflatedConditionImpl(initial, defaultPredicate)

public fun conflatedBooleanCondition(initial: Boolean = false): ConflatedBooleanCondition = ConflatedBooleanCondition(initial)
public fun conflatedSignalCondition(): ConflatedSignalCondition = ConflatedSignalCondition()

public fun <T : Any> rendezvousCondition(
    initial: T?,
    defaultPredicate: (T) -> Boolean
): RendezvousCondition<T> = RendezvousConditionImpl(initial, defaultPredicate)

public fun rendezvousBooleanCondition(initial: Boolean = false): RendezvousBooleanCondition = RendezvousBooleanCondition(initial)
public fun rendezvousSignalCondition(): RendezvousSignalCondition = RendezvousSignalCondition()
