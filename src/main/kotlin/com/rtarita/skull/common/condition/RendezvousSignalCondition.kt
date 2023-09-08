package com.rtarita.skull.common.condition

public class RendezvousSignalCondition internal constructor() : RendezvousConditionBase<Unit>(null), SignalCondition {
    public suspend fun signal(): Unit = update(Unit)

    public suspend fun signalAndClose() {
        signal()
        close()
    }
}
