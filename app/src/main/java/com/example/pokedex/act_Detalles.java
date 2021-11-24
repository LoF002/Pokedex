package com.example.pokedex;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.pokedex.modelo.Foto;

public class act_Detalles extends AppCompatActivity {

    ImageView imgAPI;
    TextView lblTitulo;
    TextView lblURL;

    Foto foto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.lyt_detalles);

        imgAPI = findViewById(R.id.imgAPI);
        lblTitulo = findViewById(R.id.lblTitulo);
        lblURL = findViewById(R.id.lblURL);

        foto = getIntent().getParcelableExtra("foto");

        if(foto != null){
            lblTitulo.setText(foto.getTitle());
            lblURL.setText(foto.getUrl());
        }//Fin if

    }//Fin onCreate

}//Fin clase act_Detalles