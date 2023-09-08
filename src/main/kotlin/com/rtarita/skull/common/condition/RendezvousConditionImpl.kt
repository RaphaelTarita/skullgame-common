package com.rtarita.skull.common.condition

internal class RendezvousConditionImpl<T : Any>(
    initial: T?,
    override val defaultPredicate: (T) -> Boolean
) : RendezvousConditionBase<T>(initial)
