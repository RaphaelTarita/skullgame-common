package com.rtarita.skull.common.condition

import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.channels.ClosedReceiveChannelException

public abstract class ConditionBase<T : Any>(initial: T?, channelCapacity: Int) : Condition<T> {
    protected var current: T? = initial
    protected val channel: Channel<T?> = Channel(channelCapacity)

    override fun currently(predicate: (T) -> Boolean): Boolean {
        return predicate(current ?: return false)
    }

    override fun currently(): Boolean = currently(defaultPredicate)

    override suspend fun waitFor(predicate: (T) -> Boolean): T {
        val finalCurrent = current
        if (finalCurrent != null && predicate(finalCurrent)) return finalCurrent
        for (subject in channel) {
            if (subject != null && predicate(subject)) return subject
        }
        throw ClosedReceiveChannelException(null)
    }

    override suspend fun waitFor(): T = waitFor(defaultPredicate)

    override fun close() {
        channel.close()
    }
}
