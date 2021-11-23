package com.example.pokedex.service;

import com.example.pokedex.modelo.PokemonLista;

import retrofit2.Call;
import retrofit2.http.GET;

public interface RetrofitApiService {

    @GET("pokemon")
    Call<PokemonLista> getListaPokemons();

}//Fin interfaz RetrofitApiService
