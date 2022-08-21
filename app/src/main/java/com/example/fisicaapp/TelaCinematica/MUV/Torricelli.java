package com.example.fisicaapp.TelaCinematica.MUV;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.fisicaapp.R;
import com.google.android.material.textfield.TextInputLayout;

import java.text.DecimalFormat;
import static java.lang.Math.pow;
import static java.lang.StrictMath.sqrt;

public class Torricelli extends AppCompatActivity {

    private EditText editTorricelliValor1, editTorricelliValor2, editTorricelliValor3;
    private TextView exibirResultTorricelli;
    private Spinner escolhaTorricelli;
    private Button btnCalcularTorricelli;
    private TextInputLayout textInputLayoutTorricelli, textInputLayoutTorricelli2, textInputLayoutTorricelli3;


    DecimalFormat df = new
            DecimalFormat("0.00");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_torricelli);

        editTorricelliValor1 = findViewById(R.id.editTorricelliValor1);
        editTorricelliValor2 = findViewById(R.id.editTorricelliValor2);
        editTorricelliValor3 = findViewById(R.id.editTorricelliValor3);
        exibirResultTorricelli = findViewById(R.id.exibirResultTorricelli);
        escolhaTorricelli = findViewById(R.id.escolhaTorricelli);
        btnCalcularTorricelli = findViewById(R.id.btnCalcularTorricelli);
        textInputLayoutTorricelli = findViewById(R.id.textInputLayoutTorricelli);
        textInputLayoutTorricelli2 = findViewById(R.id.textInputLayoutTorricelli2);
        textInputLayoutTorricelli3 = findViewById(R.id.textInputLayoutTorricelli3);

        escolhaTorricelli();

    }

    private void escolhaTorricelli(){

        escolhaTorricelli.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if(position == 0){
                    Toast.makeText(getApplicationContext(), "Selecione opção.", Toast.LENGTH_SHORT).show();
                }
                else if(position == 1){
                    textInputLayoutTorricelli.setHint("Digite a Velocidade inicial (m/s)");
                    textInputLayoutTorricelli2.setHint("Digite a Aceleração (m/s²)");
                    textInputLayoutTorricelli3.setHint("Digite a Posição (m)");

                    btnCalcularTorricelli.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {

                            CalcularVelocidadeTorricelli();
                        }
                    });
                }
                else if(position == 2){
                    textInputLayoutTorricelli.setHint("Digite a Velocidade (m/s)");
                    textInputLayoutTorricelli2.setHint("Digite a Aceleração (m/s²)");
                    textInputLayoutTorricelli3.setHint("Digite a Posição (m)");

                    btnCalcularTorricelli.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {

                            CalcularVelocidadeInicialTorricelli();
                        }
                    });
                }
                else if(position == 3){
                    textInputLayoutTorricelli.setHint("Digite a Velocidade (m/s)");
                    textInputLayoutTorricelli2.setHint("Digite a Velocidade inicial (m/s)");
                    textInputLayoutTorricelli3.setHint("Digite a Posição (m)");

                    btnCalcularTorricelli.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            CalcularAceleracaoTorricelli();
                        }
                    });
                }
                else if(position == 4){
                    textInputLayoutTorricelli.setHint("Digite a Velocidade (m/s)");
                    textInputLayoutTorricelli2.setHint("Digite a Velocidade inicial (m/s)");
                    textInputLayoutTorricelli3.setHint("Digite a Aceleração (m/s²)");

                    btnCalcularTorricelli.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            CalcularPosicaoTorricelli();
                        }
                    });
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

    }

    public boolean verficarValores() {
        boolean res = true;
        if (editTorricelliValor1.getText().toString().isEmpty() || editTorricelliValor2.getText().toString().isEmpty() || editTorricelliValor3.getText().toString().isEmpty()) {
            res = false;
        }
        return res;
    }

    @SuppressLint("SetTextI18n")
    public void CalcularVelocidadeTorricelli() {

        if (verficarValores()) {
            float VeloInicial = Float.parseFloat(editTorricelliValor1.getText().toString());
            float Aceleracao = Float.parseFloat(editTorricelliValor2.getText().toString());
            float Posicao = Float.parseFloat(editTorricelliValor3.getText().toString());

            double Resultado = sqrt(pow(VeloInicial,2) + (2*Aceleracao*Posicao));

            exibirResultTorricelli.setText(df.format(Resultado) + " m/s");
        } else {
            Toast.makeText(getApplicationContext(), "Campos vazios", Toast.LENGTH_SHORT).show();
        }

    }

    @SuppressLint("SetTextI18n")
    public void CalcularVelocidadeInicialTorricelli() {

        if (verficarValores()) {
            float Velocidade = Float.parseFloat(editTorricelliValor1.getText().toString());
            float Aceleracao = Float.parseFloat(editTorricelliValor2.getText().toString());
            float Posicao = Float.parseFloat(editTorricelliValor3.getText().toString());

            double Resultado = sqrt(pow(Velocidade,2)-(2*Aceleracao*Posicao));

            exibirResultTorricelli.setText(df.format(Resultado) + " m/s");
        } else {
            Toast.makeText(getApplicationContext(), "Campos vazios", Toast.LENGTH_SHORT).show();
        }

    }

    @SuppressLint("SetTextI18n")
    public void CalcularAceleracaoTorricelli() {

        if (verficarValores()) {
            float Velociade = Float.parseFloat(editTorricelliValor1.getText().toString());
            float VeloInicial = Float.parseFloat(editTorricelliValor2.getText().toString());
            float POsicao = Float.parseFloat(editTorricelliValor3.getText().toString());

            double Resultado = (pow(Velociade,2)-pow(VeloInicial,2))/(2*POsicao);

            exibirResultTorricelli.setText(df.format(Resultado) + " m/s²");
        } else {
            Toast.makeText(getApplicationContext(), "Campos vazios", Toast.LENGTH_SHORT).show();
        }

    }

    @SuppressLint("SetTextI18n")
    public void CalcularPosicaoTorricelli() {

        if (verficarValores()) {
            float Velocidade = Float.parseFloat(editTorricelliValor1.getText().toString());
            float VeloInicial = Float.parseFloat(editTorricelliValor2.getText().toString());
            float Aceleracao = Float.parseFloat(editTorricelliValor3.getText().toString());

            double Resultado = (pow(Velocidade,2)-pow(VeloInicial,2))/(2*Aceleracao);

            exibirResultTorricelli.setText(df.format(Resultado) + " m");
        } else {
            Toast.makeText(getApplicationContext(), "Campos vazios", Toast.LENGTH_SHORT).show();
        }

    }
}