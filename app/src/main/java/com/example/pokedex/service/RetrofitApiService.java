package com.example.pokedex.service;

import com.example.pokedex.modelo.Makeup;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface RetrofitApiService {

    @GET("products.json")
    Call<List<Makeup>> getListaMakeups(@Query("brand") String brand);

}//Fin interfaz RetrofitApiService
