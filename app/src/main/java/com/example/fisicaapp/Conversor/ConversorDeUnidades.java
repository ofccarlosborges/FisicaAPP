package com.example.fisicaapp.Conversor;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import com.example.fisicaapp.R;
import com.example.fisicaapp.inicial2;

public class ConversorDeUnidades extends AppCompatActivity {

    CardView cardConversorVelocidade, cardConversorTempo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_conversor_de_unidades);

        cardConversorVelocidade = findViewById(R.id.cardConversorVelocidade);
        cardConversorTempo = findViewById(R.id.cardConversorTempo);

        cardConversorVelocidade.setOnClickListener(view -> {
            Intent intent = new Intent(getApplicationContext(), Conversor_velocidade.class);
            startActivity(intent);
        });

        cardConversorTempo.setOnClickListener(view -> {
            Intent intent = new Intent(getApplicationContext(), inicial2.class);
            startActivity(intent);
        });

    }
}