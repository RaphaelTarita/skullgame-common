package com.rtarita.skull.common.condition

import kotlinx.coroutines.channels.Channel

public abstract class ConflatedConditionBase<T : Any>(initial: T?) : ConditionBase<T>(initial, Channel.CONFLATED), ConflatedCondition<T> {
    init {
        channel.trySend(initial)
    }

    public override fun update(subject: T) {
        current = subject
        channel.trySend(subject)
    }
}
