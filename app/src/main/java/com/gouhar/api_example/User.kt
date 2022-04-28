package com.gouhar.api_example

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter= true)
data class User(
    val id: Int,
    val name: String,
    val username: String,
    val email: String,
    val address:Address,
    val phone: String,
    val website: String,
    val company:Company
)

@JsonClass(generateAdapter= true)
data class Address(
    val street: String,
    val suite: String,
    val city: String,
    val zipcode: String
)

@JsonClass(generateAdapter= true)
data class Company(
    val name: String,
    val catchPhrase: String,
    val bs: String
)
