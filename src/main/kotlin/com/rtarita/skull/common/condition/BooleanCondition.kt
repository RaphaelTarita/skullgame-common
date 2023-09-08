package com.rtarita.skull.common.condition

public interface BooleanCondition : Condition<Boolean> {
    override val defaultPredicate: (Boolean) -> Boolean
        get() = isTruePredicate

    public suspend fun waitUntilGiven(): Boolean = waitFor()
    public suspend fun waitUntilNotGiven(): Boolean = waitFor(isFalsePredicate)
}
