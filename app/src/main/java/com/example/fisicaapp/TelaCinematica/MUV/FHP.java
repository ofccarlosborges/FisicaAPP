package com.example.fisicaapp.TelaCinematica.MUV;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.fisicaapp.R;
import com.google.android.material.textfield.TextInputLayout;

import java.text.DecimalFormat;
import static java.lang.Math.pow;
import static java.lang.StrictMath.sqrt;

public class FHP extends AppCompatActivity {

    private EditText editFHPValor1, editFHPValor2, editFHPValor3;
    private TextView exibirResultFHP;
    private Spinner escolhaFHP;
    private Button btnCalcularFHP;
    private TextInputLayout textInputLayoutFHP, textInputLayoutFHP2, textInputLayoutFHP3;


    DecimalFormat df = new
            DecimalFormat("0.00");


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_f_h_p);

        editFHPValor1 = findViewById(R.id.editFHPValor1);
        editFHPValor2 = findViewById(R.id.editFHPValor2);
        editFHPValor3 = findViewById(R.id.editFHPValor3);
        exibirResultFHP = findViewById(R.id.exibirResultFHP);
        escolhaFHP = findViewById(R.id.escolhaFHP);
        btnCalcularFHP = findViewById(R.id.btnCalcularFHP);
        textInputLayoutFHP = findViewById(R.id.textInputLayoutFHP);
        textInputLayoutFHP2 = findViewById(R.id.textInputLayoutFHP2);
        textInputLayoutFHP3 = findViewById(R.id.textInputLayoutFHP3);

        escolhaFHP();

    }

    private void escolhaFHP(){

        escolhaFHP.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if(escolhaFHP.getSelectedItem().equals("Selecione opção")){
                    Toast.makeText(getApplicationContext(), "Selecione opção.", Toast.LENGTH_SHORT).show();
                }
                else if(escolhaFHP.getSelectedItem().equals("Posição Inicial")){
                    textInputLayoutFHP.setHint("Digite a Velocidade inicial (m/s)");
                    textInputLayoutFHP2.setHint("Digite a Aceleração (m/s²)");
                    textInputLayoutFHP3.setHint("Digite a Posição (m)");

                    btnCalcularFHP.setOnClickListener(v -> CalcularPosicaoFHP());
                }
                else if(escolhaFHP.getSelectedItem().equals("Velocidade Inicial")){
                    textInputLayoutFHP.setHint("Digite a Velocidade (m/s)");
                    textInputLayoutFHP2.setHint("Digite a Aceleração (m/s²)");
                    textInputLayoutFHP3.setHint("Digite a Posição Final (m)");

                    btnCalcularFHP.setOnClickListener(v -> CalcularVelocidadeInicialFHP());
                }
                else if(escolhaFHP.getSelectedItem().equals("Aceleração")){
                    textInputLayoutFHP.setHint("Digite a Velocidade (m/s)");
                    textInputLayoutFHP2.setHint("Digite a Velocidade inicial (m/s)");
                    textInputLayoutFHP3.setHint("Digite a Posição Final (m)");

                    btnCalcularFHP.setOnClickListener(v -> CalcularAceleracaoFHP());
                }
                else if(escolhaFHP.getSelectedItem().equals("Tempo")){
                    textInputLayoutFHP.setHint("Digite a Posição Inicial (m)");
                    textInputLayoutFHP2.setHint("Digite a Posição Final (m)");
                    textInputLayoutFHP3.setHint("Digite a Aceleração (m/s²)");

                    btnCalcularFHP.setOnClickListener(v -> CalcularTempoFHP());
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

    }

    public boolean verficarValores() {
        boolean res = true;
        if (editFHPValor1.getText().toString().isEmpty() || editFHPValor2.getText().toString().isEmpty() || editFHPValor3.getText().toString().isEmpty()) {
            res = false;
        }
        return res;
    }

    @SuppressLint("SetTextI18n")
    public void CalcularTempoFHP() {

        if (verficarValores()) {
            float Posicao1 = Float.parseFloat(editFHPValor1.getText().toString());
            float Posicao2 = Float.parseFloat(editFHPValor2.getText().toString());
            float Aceleracao = Float.parseFloat(editFHPValor3.getText().toString());

            double Resultado = sqrt((2*(Posicao2-Posicao1))/Aceleracao);

            exibirResultFHP.setText(df.format(Resultado) + " s");
        } else {
            Toast.makeText(getApplicationContext(), "Campos vazios", Toast.LENGTH_SHORT).show();
        }

    }

    @SuppressLint("SetTextI18n")
    public void CalcularVelocidadeInicialFHP() {

        if (verficarValores()) {
            float Velocidade = Float.parseFloat(editFHPValor1.getText().toString());
            float Aceleracao = Float.parseFloat(editFHPValor2.getText().toString());
            float Posicao = Float.parseFloat(editFHPValor3.getText().toString());

            double Resultado = sqrt(pow(Velocidade,2)-(2*Aceleracao*Posicao));

            exibirResultFHP.setText(df.format(Resultado) + " m/s");
        } else {
            Toast.makeText(getApplicationContext(), "Campos vazios", Toast.LENGTH_SHORT).show();
        }

    }

    @SuppressLint("SetTextI18n")
    public void CalcularAceleracaoFHP() {

        if (verficarValores()) {
            float Velociade = Float.parseFloat(editFHPValor1.getText().toString());
            float VeloInicial = Float.parseFloat(editFHPValor2.getText().toString());
            float POsicao = Float.parseFloat(editFHPValor3.getText().toString());

            double Resultado = (pow(Velociade,2)-pow(VeloInicial,2))/(2*POsicao);

            exibirResultFHP.setText(df.format(Resultado) + " m/s²");
        } else {
            Toast.makeText(getApplicationContext(), "Campos vazios", Toast.LENGTH_SHORT).show();
        }

    }

    @SuppressLint("SetTextI18n")
    public void CalcularPosicaoFHP() {

        if (verficarValores()) {
            float Velocidade = Float.parseFloat(editFHPValor1.getText().toString());
            float VeloInicial = Float.parseFloat(editFHPValor2.getText().toString());
            float Aceleracao = Float.parseFloat(editFHPValor3.getText().toString());

            double Resultado = (pow(Velocidade,2)-pow(VeloInicial,2))/(2*Aceleracao);

            exibirResultFHP.setText(df.format(Resultado) + " m");
        } else {
            Toast.makeText(getApplicationContext(), "Campos vazios", Toast.LENGTH_SHORT).show();
        }

    }
}