package com.rtarita.skull.common

import kotlinx.serialization.Serializable

@Serializable
public data class LoginCredentials(
    val id: String,
    val passHash: String
)
