package com.rtarita.skull.common.condition.dsl

import com.rtarita.skull.common.condition.BooleanCondition
import com.rtarita.skull.common.condition.Condition
import com.rtarita.skull.common.condition.SignalCondition
import com.rtarita.skull.common.condition.isFalsePredicate

// DSL definitions

public data object Wait

public fun <T : Any> Condition<T>.isSatisfied(): WaitDslToken1<T> = WaitDslToken1(this, defaultPredicate)
public val BooleanCondition.isTrue: WaitDslToken1<Boolean>
    get() = WaitDslToken1(this, defaultPredicate)
public val BooleanCondition.isGiven: WaitDslToken1<Boolean>
    get() = WaitDslToken1(this, defaultPredicate)
public val BooleanCondition.isFalse: WaitDslToken1<Boolean>
    get() = WaitDslToken1(this, isFalsePredicate)
public val BooleanCondition.isNotGiven: WaitDslToken1<Boolean>
    get() = WaitDslToken1(this, isFalsePredicate)
public val SignalCondition.happens: WaitDslToken1<Unit>
    get() = WaitDslToken1(this, defaultPredicate)


public open class WaitDslToken1<T : Any>(private val condition: Condition<T>, private val predicate: (T) -> Boolean) {
    internal suspend fun waitFor() = condition.waitFor(predicate)
}

public class WaitDslToken2<T : Any>(condition: Condition<T>, predicate: (T) -> Boolean) : WaitDslToken1<T>(condition, predicate)

@JvmInline
public value class WaitDslToken3<T : Any>(@PublishedApi internal val condition: Condition<T>)

public operator fun <T : Any> Condition<T>.invoke(predicate: (T) -> Boolean): WaitDslToken2<T> = WaitDslToken2(this, predicate)

public suspend infix fun <T : Any> Wait.`for`(condition: Condition<T>): T = condition.waitFor()

@Suppress("FunctionName")
public suspend infix fun <T : Any> Wait.For(condition: Condition<T>): T = condition.waitFor()

public suspend infix fun <T : Any> Wait.`for`(token: WaitDslToken2<T>): T = token.waitFor()

@Suppress("FunctionName")
public suspend infix fun <T : Any> Wait.For(token: WaitDslToken2<T>): T = token.waitFor()

public suspend infix fun <T : Any> Wait.until(token: WaitDslToken1<T>): T = token.waitFor()
public infix fun <T : Any> Wait.until(condition: Condition<T>): WaitDslToken3<T> = WaitDslToken3(condition)

public suspend infix fun <T : Any> WaitDslToken3<T>.becomes(value: T): T = condition.waitFor { it == value }
public suspend infix fun <T : Any> WaitDslToken3<T>.satisfies(predicate: (T) -> Boolean): T = condition.waitFor(predicate)
