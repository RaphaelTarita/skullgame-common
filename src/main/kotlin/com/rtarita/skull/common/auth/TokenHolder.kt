package com.rtarita.skull.common.auth

import kotlinx.serialization.Serializable

@Serializable
public data class TokenHolder(val token: String)
