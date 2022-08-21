package com.example.fisicaapp.Conversor;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.fisicaapp.R;

public class Conversor_tempo extends AppCompatActivity {

    private EditText editValorConversorTempo;
    private Button btnConverterTempo;
    private TextView exibirResultConversorTempo;
    private Spinner escolhaConverterDeTempo, escolhaConverterParaTempo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_conversor_tempo);

        escolhaConverterDeTempo = findViewById(R.id.escolhaConverterDeTempo);
        escolhaConverterParaTempo = findViewById(R.id.escolhaConverterParaTempo);
        editValorConversorTempo = findViewById(R.id.editValorConversorTempo);
        btnConverterTempo = findViewById(R.id.btnConverterTempo);
        exibirResultConversorTempo = findViewById(R.id.exibirResultConversorTempo);

        btnConverterTempo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (escolhaConverterDeTempo.getItemAtPosition(0) == escolhaConverterParaTempo.getItemAtPosition(0)){
                    double Tempo = Float.parseFloat(editValorConversorTempo.getText().toString());

                    exibirResultConversorTempo.setText(String.format(" %s", Tempo +"ms"));

                }
                else if (escolhaConverterDeTempo.getItemAtPosition(0) == escolhaConverterParaTempo.getItemAtPosition(1)){
                    ConverterMilissegundoSegundo();

                }
                else if (escolhaConverterDeTempo.getItemAtPosition(0) == escolhaConverterParaTempo.getItemAtPosition(2)){

                }
                else if (escolhaConverterDeTempo.getItemAtPosition(0) == escolhaConverterParaTempo.getItemAtPosition(3)){
                    ConverterMilissegundoHora();

                }
                else if (escolhaConverterDeTempo.getItemAtPosition(1) == escolhaConverterParaTempo.getItemAtPosition(0)){

                }
                else if (escolhaConverterDeTempo.getItemAtPosition(1) == escolhaConverterParaTempo.getItemAtPosition(2)){
                    ConverterSegundoMinuto();
                }
                else if (escolhaConverterDeTempo.getItemAtPosition(1) == escolhaConverterParaTempo.getItemAtPosition(3)){
                }
            }
        });




    }


    // Funções dos Calculos de conversão \\

    public void ConverterMilissegundoSegundo(){
        if(verificarValores()){
            float Valor = Float.parseFloat(editValorConversorTempo.getText().toString());
            float Resultado = Valor / 1000;
            exibirResultConversorTempo.setText(String.format(" %s", Resultado +"s"));
        } else {
            Toast.makeText(getApplicationContext(), "Campos vazios", Toast.LENGTH_SHORT).show();
        }
    }

    public void ConverterSegundoMinuto(){
        if(verificarValores()){
            float Valor = Float.parseFloat(editValorConversorTempo.getText().toString());
            float Resultado = Valor / 60;
            exibirResultConversorTempo.setText(String.format(" %s", Resultado +"min"));
        } else {
            Toast.makeText(getApplicationContext(), "Campos vazios", Toast.LENGTH_SHORT).show();
        }
    }


    public void ConverterMinutoHora(){
        if(verificarValores()){
            float Valor = Float.parseFloat(editValorConversorTempo.getText().toString());
            float Resultado = Valor / 60;
            exibirResultConversorTempo.setText(String.format(" %s", Resultado +"h(s)"));
        } else {
            Toast.makeText(getApplicationContext(), "Campos vazios", Toast.LENGTH_SHORT).show();
        }
    }

    public void ConverterHoraMinuto(){
        if(verificarValores()){
            float Valor = Float.parseFloat(editValorConversorTempo.getText().toString());
            float Resultado = Valor * 60;
            exibirResultConversorTempo.setText(String.format(" %s", Resultado +"Min"));
        } else {
            Toast.makeText(getApplicationContext(), "Campos vazios", Toast.LENGTH_SHORT).show();
        }
    }

    public void ConverterMinutoSegundo(){
        if(verificarValores()){
            float Valor = Float.parseFloat(editValorConversorTempo.getText().toString());
            float Resultado = Valor * 60;
            exibirResultConversorTempo.setText(String.format(" %s", Resultado +"s"));
        } else {
            Toast.makeText(getApplicationContext(), "Campos vazios", Toast.LENGTH_SHORT).show();
        }
    }

    public void ConverterSegundoMilissegundo(){
        if(verificarValores()){
            float Valor = Float.parseFloat(editValorConversorTempo.getText().toString());
            float Resultado = Valor * 1000;
            exibirResultConversorTempo.setText(String.format(" %s", Resultado +"ms"));
        } else {
            Toast.makeText(getApplicationContext(), "Campos vazios", Toast.LENGTH_SHORT).show();
        }
    }

    public void ConverterMilissegundoHora(){
        if(verificarValores()){
            float Valor = Float.parseFloat(editValorConversorTempo.getText().toString());
            float Resultado = (float) (Valor / 3.6e+6);
            exibirResultConversorTempo.setText(String.format(" %s", Resultado +"h"));
        } else {
            Toast.makeText(getApplicationContext(), "Campos vazios", Toast.LENGTH_SHORT).show();
        }
    }

    // Final dos Calculos de conversão \\

    private boolean verificarValores(){
        boolean res = true;
        if(editValorConversorTempo.getText().toString().isEmpty()){
            res = false;
        }
        return res;
    }
}