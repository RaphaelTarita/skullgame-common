package com.rtarita.skull.common.condition

@OptIn(ExperimentalStdlibApi::class)
public interface Condition<T : Any> : AutoCloseable {
    public val defaultPredicate: (T) -> Boolean

    public fun currently(predicate: (T) -> Boolean): Boolean
    public fun currently(): Boolean = currently(defaultPredicate)

    public suspend fun waitFor(predicate: (T) -> Boolean): T

    public suspend fun waitFor(): T = waitFor(defaultPredicate)
}
