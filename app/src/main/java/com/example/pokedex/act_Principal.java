package com.example.pokedex;

import static android.content.ContentValues.TAG;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.example.pokedex.client.RetrofitCliente;
import com.example.pokedex.modelo.Foto;
import com.example.pokedex.service.RetrofitApiService;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class act_Principal extends AppCompatActivity {

    List<Foto> lista;
    ListView listaVista;
    ArrayAdapter<Foto> adapter;

    int id;

    private RetrofitApiService apiService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.lyt_principal);

        listaVista = findViewById(R.id.listaPokemons);

        iniciarValores();

        getListaPokemons();

        listaVista.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Foto foto = lista.get(position);
                id = lista.get(position).getId();

                Intent intent = new Intent(act_Principal.this, act_Detalles.class);
                intent.putExtra("foto", foto);
                startActivity(intent);
            }//onItemClick
        });//setOnItemClickListener

    }//Fin onCreate

    private void iniciarValores(){
        apiService = RetrofitCliente.getApiService();
    }//Fin iniciarValores

    private void getListaPokemons(){
        apiService.getListaPokemons().enqueue(new Callback<List<Foto>>() {
            @Override
            public void onResponse(Call<List<Foto>> call, Response<List<Foto>> response) {
                lista = new ArrayList<>();
                lista = response.body();

                adapter = new ArrayAdapter<>(act_Principal.this, android.R.layout.simple_list_item_1, lista);
                listaVista.setAdapter(adapter);
            }//Fin onResponse

            @Override
            public void onFailure(Call<List<Foto>> call, Throwable t) {
                Log.e(TAG, ""+ t.getMessage());
                Toast.makeText(getApplicationContext(), t.getMessage(), Toast.LENGTH_LONG).show();
            }//Fin onFailure
        });
    }//Fin getListaPokemons

}//Fin act_Principal