package com.example.pokedex.service;

import com.example.pokedex.modelo.Foto;
import com.example.pokedex.modelo.Pokemon;
import com.example.pokedex.modelo.PokemonLista;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface RetrofitApiService {

    @GET("photos")
    Call<List<Foto>> getListaPokemons();

}//Fin interfaz RetrofitApiService
