package com.rtarita.skull.common.condition

public class RendezvousBooleanCondition internal constructor(initial: Boolean = false) : RendezvousConditionBase<Boolean>(initial), BooleanCondition {
    public suspend fun toggle() {
        val notNull = current ?: return
        update(!notNull)
    }

    public suspend fun given(): Unit = update(true)

    public suspend fun notGiven(): Unit = update(false)
}
