package com.rtarita.skull.common

public fun hash(vararg values: Any?): Int = values.contentDeepHashCode()
