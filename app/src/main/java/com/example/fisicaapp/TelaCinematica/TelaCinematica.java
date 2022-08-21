package com.example.fisicaapp.TelaCinematica;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.fisicaapp.R;
import com.example.fisicaapp.TelaCinematica.MU.MU;
import com.example.fisicaapp.TelaCinematica.MUV.MUV;
import com.example.fisicaapp.TelaCinematica.MovimentoObliquo.MovimentoObliquo;
import com.example.fisicaapp.TelaCinematica.MovimentoVertical.MovimentoVertical;
import com.example.fisicaapp.TelaCinematica.VelocidadeMedia.TelaVeloMedia;

public class TelaCinematica extends AppCompatActivity {

    private CardView cardVeloMedia, cardMU, cardMUV, cardMoviVertical, cardMoviObliquo,cardMoviCircular;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_cinematica);

        cardVeloMedia = findViewById(R.id.cardVeloMedia);
        cardMU = findViewById(R.id.cardMUinicio);
        cardMUV = findViewById(R.id.cardMUV);
        cardMoviVertical = findViewById(R.id.cardMoviVertical);
        cardMoviObliquo = findViewById(R.id.cardMoviObliquo);
        cardMoviCircular = findViewById(R.id.cardMoviCircular);

        eventoCinematica();
    }

    private void eventoCinematica() {

        cardVeloMedia.setOnClickListener(view -> {
            Intent intent = new Intent(getApplicationContext(), TelaVeloMedia.class);
            startActivity(intent);
        });
        cardMU.setOnClickListener(view -> {
            Intent intent = new Intent(getApplicationContext(), MU.class);
            startActivity(intent);
        });
        cardMUV.setOnClickListener(view -> {
            Intent intent = new Intent(getApplicationContext(), MUV.class);
            startActivity(intent);
        });
        cardMoviVertical.setOnClickListener(view -> {
            Intent intent = new Intent(getApplicationContext(), MovimentoVertical.class);
            startActivity(intent);
        });
        cardMoviObliquo.setOnClickListener(view -> {
            Intent intent = new Intent(getApplicationContext(), MovimentoObliquo.class);
            startActivity(intent);
        });
        cardMoviCircular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               // Intent intent = new Intent(getApplicationContext(), TelaVeloMedia.class);
             //   startActivity(intent);
            }
        });


    }
}