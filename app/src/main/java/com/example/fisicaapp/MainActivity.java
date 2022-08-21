package com.example.fisicaapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import com.example.fisicaapp.Conversor.ConversorDeUnidades;
import com.example.fisicaapp.Conversor.Conversor_temperatura;
import com.example.fisicaapp.Conversor.conversor2;
import com.example.fisicaapp.Cronometro.Cronometro;
import com.example.fisicaapp.PenduloSimples.PenduloSimples;
import com.example.fisicaapp.Somatorio.Somatorio;
import com.example.fisicaapp.TelaCinematica.MU.MU;
import com.example.fisicaapp.TelaCinematica.MUV.MUV;
import com.example.fisicaapp.TelaCinematica.TelaCinematica;
import com.example.fisicaapp.TelaDinamica.TelaDinamica;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity{


    CardView cardMUinicio, cardMUVinicio, cardCronometro, cardCronometroinicio, cardCinematica, cardDinamica, cardConversor, cardPendulo, cardSobre, cardSomatorio;
    TextView textVerTodas;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        cardCinematica = findViewById(R.id.cardCinematicaT2);
        cardDinamica = findViewById(R.id.cardDinamica);
        cardConversor = findViewById(R.id.cardConversor);
        cardPendulo = findViewById(R.id.cardPendulo);
        cardSomatorio = findViewById(R.id.cardSomatorio);
        cardSobre = findViewById(R.id.cardSobre);
        cardMUinicio = findViewById(R.id.cardMUinicio);
        cardCronometro = findViewById(R.id.cardCronometro);
        textVerTodas = findViewById(R.id.textVerTodas);

        eventosCard();


    }


    private void eventosCard() {

        textVerTodas.setOnClickListener(view -> {
            Intent intent = new Intent(getApplicationContext(), MU.class);
            startActivity(intent);
        });


        cardCinematica.setOnClickListener(view -> {
            Intent intent = new Intent(getApplicationContext(), TelaCinematica.class);
            startActivity(intent);
        });

        cardDinamica.setOnClickListener(view -> {
            Intent intent = new Intent(getApplicationContext(), inicial2.class);
            startActivity(intent);

        });

        cardConversor.setOnClickListener(view -> {
            Intent intent = new Intent(getApplicationContext(), ConversorDeUnidades.class);
            startActivity(intent);
        });

        cardPendulo.setOnClickListener(view -> {
            Intent intent = new Intent(getApplicationContext(), PenduloSimples.class);
            startActivity(intent);
        });

        cardCronometro.setOnClickListener(view -> {
            Intent intent = new Intent(getApplicationContext(), Cronometro.class);
            startActivity(intent);

        });

        cardSobre.setOnClickListener(view -> {
            Intent intent = new Intent(getApplicationContext(), Conversor_temperatura.class);
            startActivity(intent);

        });

    }


}