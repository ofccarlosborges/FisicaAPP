package com.example.fisicaapp.TelaCinematica.MUV;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.fisicaapp.R;
import com.example.fisicaapp.TelaCinematica.MU.MU;
import com.example.fisicaapp.TelaCinematica.VelocidadeMedia.TelaVeloMedia;

public class MUV extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_m_u_v);

        CardView cardFHP = findViewById(R.id.cardFHP);
        CardView cardFHV = findViewById(R.id.cardFHV);
        CardView cardTorricelli = findViewById(R.id.cardTorricelli);

        cardFHP.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), FHP.class);
                startActivity(intent);
            }
        });
        cardFHV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), FHV.class);
                startActivity(intent);
            }
        });
        cardTorricelli.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), Torricelli.class);
                startActivity(intent);
            }
        });

}
}