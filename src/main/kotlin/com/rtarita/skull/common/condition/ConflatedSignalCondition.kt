package com.rtarita.skull.common.condition

public class ConflatedSignalCondition internal constructor() : ConflatedConditionBase<Unit>(null), SignalCondition {
    public fun signal(): Unit = update(Unit)

    public fun signalAndClose() {
        signal()
        close()
    }
}
