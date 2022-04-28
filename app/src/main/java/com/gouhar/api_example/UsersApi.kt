package com.gouhar.api_example

import retrofit2.http.GET

interface UsersApi {

    @GET("/users")
    suspend fun getUsers(): List<User>

}