package com.cibertec.cibertecapp.network

import io.reactivex.Single
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface CibertecApi {

    @POST("login")
    fun login(@Body loginRequest: LoginRequest): Single<LoginResponse>

    @GET("users")
    fun usersList()

}