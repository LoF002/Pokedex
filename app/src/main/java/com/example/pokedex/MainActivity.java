package com.example.pokedex;

import static android.content.ContentValues.TAG;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.example.pokedex.client.RetrofitCliente;
import com.example.pokedex.modelo.Pokemon;
import com.example.pokedex.modelo.PokemonLista;
import com.example.pokedex.service.RetrofitApiService;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    ListView listaPokemons;
    ArrayAdapter<Pokemon> adapter;

    private RetrofitApiService apiService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listaPokemons = findViewById(R.id.listaPokemons);

        iniciarValores();
        getListaPokemons();

    }//Fin onCreate

    private void iniciarValores(){
        apiService = RetrofitCliente.getApiService();
    }//Fin iniciarValores

    private void getListaPokemons(){
        apiService.getListaPokemons().enqueue(new Callback<PokemonLista>() {
            @Override
            public void onResponse(Call<PokemonLista> call, Response<PokemonLista> response) {
                PokemonLista pokemonLista = response.body();
                ArrayList<Pokemon> lista = pokemonLista.getPokemons();

                /*
                for(int i = 0; i < lista.size(); i++){
                    Pokemon p = lista.get(i);
                    Log.i(TAG, "Pokemon:" + p.getName());
                }//Fin for
                 */

            }//Fin onResponse

            @Override
            public void onFailure(Call<PokemonLista> call, Throwable t) {
                Toast.makeText(getApplicationContext(), t.getMessage(), Toast.LENGTH_LONG).show();
            }//Fin onFailure
        });
    }//Fin getListaPokemons

}//Fin MainActivity