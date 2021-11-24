package com.example.pokedex.client;

import com.example.pokedex.service.RetrofitApiService;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitCliente {

    public static final String URL_BASE = "http://makeup-api.herokuapp.com/api/v1/";
    public static Retrofit retrofit;

    public static RetrofitApiService getApiService(){
        if(retrofit==null){
            retrofit = new Retrofit.Builder()
                    .baseUrl(URL_BASE)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }//Fin If
        return retrofit.create(RetrofitApiService.class);
    }//Fin getApiService

}//Fin clase RetrofitCliente
