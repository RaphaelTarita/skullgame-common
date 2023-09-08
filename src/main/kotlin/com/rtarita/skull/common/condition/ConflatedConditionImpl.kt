package com.rtarita.skull.common.condition

internal class ConflatedConditionImpl<T : Any>(
    initial: T?,
    override val defaultPredicate: (T) -> Boolean
) : ConflatedConditionBase<T>(initial)
