package com.tiaguito.apimiinfo;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;


public interface MiApiService {
    @GET("operaciongetusuario")
    Call<MiApiResponse> getUsuario();
}