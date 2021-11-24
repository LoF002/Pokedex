package com.example.pokedex;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.pokedex.modelo.Makeup;

public class act_Detalles extends AppCompatActivity {

    ImageView imgAPI;
    TextView lblName, lblDescription, lblPrice;

    Makeup makeup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.lyt_detalles);

        imgAPI = findViewById(R.id.imgAPI);
        lblName = findViewById(R.id.lblName);
        lblDescription = findViewById(R.id.lblDescription);
        lblPrice = findViewById(R.id.lblPrice);

        makeup = getIntent().getParcelableExtra("makeup");

        if(makeup != null){
            Glide.with(this)
                    .load(makeup.getImage_link())
                    .into(imgAPI);

            lblName.setText(makeup.getName());
            lblDescription.setText(makeup.getDescription());
            lblPrice.setText("$"+makeup.getPrice());
        }//Fin if

    }//Fin onCreate

}//Fin clase act_Detalles