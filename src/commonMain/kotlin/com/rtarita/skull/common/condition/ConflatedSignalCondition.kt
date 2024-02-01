package com.rtarita.skull.common.condition

public class ConflatedSignalCondition internal constructor() : ConflatedConditionBase<Unit>(null), SignalCondition {
    override fun reset() {
        current = null
    }

    public fun signal(): Unit = update(Unit)

    public fun signalAndClose() {
        signal()
        close()
    }
}
