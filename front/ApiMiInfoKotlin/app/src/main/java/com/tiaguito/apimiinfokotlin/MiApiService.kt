package com.tiaguito.apimiinfokotlin

import retrofit2.Call
import retrofit2.http.GET

interface MiApiService {
    @GET("operaciongetusuario")
    fun getUsuario(): Call<MiApiResponse>
}