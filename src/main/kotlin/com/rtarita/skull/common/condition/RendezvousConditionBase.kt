package com.rtarita.skull.common.condition

import kotlinx.coroutines.channels.Channel

public abstract class RendezvousConditionBase<T : Any>(initial: T?) : ConditionBase<T>(initial, Channel.RENDEZVOUS), RendezvousCondition<T> {
    public override suspend fun update(subject: T) {
        current = subject
        channel.send(subject)
    }
}
