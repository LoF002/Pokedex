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
import com.example.pokedex.modelo.Makeup;
import com.example.pokedex.service.RetrofitApiService;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class act_Principal extends AppCompatActivity {

    List<Makeup> lista;
    ListView listaVista;
    ArrayAdapter<Makeup> adapter;

    int id;

    private RetrofitApiService apiService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.lyt_principal);

        listaVista = findViewById(R.id.listaMakeups);

        iniciarValores();

        getListaMakeups("maybelline");

        listaVista.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                //Foto foto = lista.get(position);
                Makeup makeup = lista.get(position);

                Intent intent = new Intent(act_Principal.this, act_Detalles.class);
                intent.putExtra("makeup", makeup);
                startActivity(intent);
            }//onItemClick
        });//setOnItemClickListener

    }//Fin onCreate

    private void iniciarValores(){
        apiService = RetrofitCliente.getApiService();
    }//Fin iniciarValores

    private void getListaMakeups(String brand){
        apiService.getListaMakeups(brand).enqueue(new Callback<List<Makeup>>() {
            @Override
            public void onResponse(Call<List<Makeup>> call, Response<List<Makeup>> response) {
                lista = new ArrayList<>();
                lista = response.body();

                adapter = new ArrayAdapter<>(act_Principal.this, android.R.layout.simple_list_item_1, lista);
                listaVista.setAdapter(adapter);
            }//Fin onResponse

            @Override
            public void onFailure(Call<List<Makeup>> call, Throwable t) {
                Log.e(TAG, ""+ t.getMessage());
                Toast.makeText(getApplicationContext(), t.getMessage(), Toast.LENGTH_LONG).show();
            }//Fin onFailure
        });
    }

}//Fin act_Principal