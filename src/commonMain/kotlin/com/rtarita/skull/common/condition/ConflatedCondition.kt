package com.rtarita.skull.common.condition

public interface ConflatedCondition<T : Any> : Condition<T> {
    public fun update(subject: T)
}
