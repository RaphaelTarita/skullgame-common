package com.rtarita.skull.common.condition

public interface SignalCondition : Condition<Unit> {
    override val defaultPredicate: (Unit) -> Boolean
        get() = signalPredicate

    public fun reset()

    public suspend fun await(): Unit = waitFor()
}
