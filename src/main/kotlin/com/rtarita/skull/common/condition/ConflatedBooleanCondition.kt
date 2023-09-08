package com.rtarita.skull.common.condition


public class ConflatedBooleanCondition internal constructor(initial: Boolean = false) : ConflatedConditionBase<Boolean>(initial), BooleanCondition {
    public fun toggle() {
        val notNull = current ?: return
        update(!notNull)
    }

    public fun given(): Unit = update(true)

    public fun notGiven(): Unit = update(false)
}
