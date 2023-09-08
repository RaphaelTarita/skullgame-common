package com.rtarita.skull.common.condition

public interface RendezvousCondition<T : Any> : Condition<T> {
    public suspend fun update(subject: T)
}
