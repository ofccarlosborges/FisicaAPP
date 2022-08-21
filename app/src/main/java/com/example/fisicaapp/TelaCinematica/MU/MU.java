package com.example.fisicaapp.TelaCinematica.MU;

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

public class MU extends AppCompatActivity {

    private EditText editMUValor1, editMUValor2, editMUValor3;
    private TextView exibirResultMU;
    private Spinner escolhaMU;
    private Button btnCalcularMU;
    private TextInputLayout textInputLayoutMU, textInputLayoutMU2, textInputLayoutMU3;


    DecimalFormat df = new
            DecimalFormat("0.00");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_m_u);

        editMUValor1 = findViewById(R.id.editMUValor1);
        editMUValor2 = findViewById(R.id.editMUValor2);
        editMUValor3 = findViewById(R.id.editMUValor3);
        exibirResultMU = findViewById(R.id.exibirResultMU);
        escolhaMU = findViewById(R.id.escolhaMU);
        btnCalcularMU = findViewById(R.id.btnCalcularMU);
        textInputLayoutMU = findViewById(R.id.textInputLayoutMU);
        textInputLayoutMU2 = findViewById(R.id.textInputLayoutMU2);
        textInputLayoutMU3 = findViewById(R.id.textInputLayoutMU3);

        escolhadoMU();

    }

    private void escolhadoMU(){

        escolhaMU.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if(position == 0){
                    Toast.makeText(getApplication(), "Selecione opção.", Toast.LENGTH_SHORT).show();
                }
                else if (position == 1){
                    textInputLayoutMU.setHint("Digite a posição incial (m)");
                    textInputLayoutMU2.setHint("Digite a posicao final (m)");
                    textInputLayoutMU3.setHint("Digite o tempo (s)");

                    btnCalcularMU.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            CalcularVelocidadeMU();
                        }
                    });
                }
                else if (position == 2){
                    textInputLayoutMU.setHint("Digite a posição incial (m)");
                    textInputLayoutMU2.setHint("Digite a velocidade (m/s)");
                    textInputLayoutMU3.setHint("Digite o tempo (s)");

                    btnCalcularMU.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            CalcularPosicaoMU();
                        }
                    });
                }
                else if (position == 3){
                    textInputLayoutMU.setHint("Digite a posição incial (m)");
                    textInputLayoutMU2.setHint("Digite a posicao final (m)");
                    textInputLayoutMU3.setHint("Digite a velocidade (m/s)");

                    btnCalcularMU.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            CalcularTempoMU();
                        }
                    });
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }

    public boolean verficarValores(){
        boolean res = true;
        if(editMUValor1.getText().toString().isEmpty() || editMUValor2.getText().toString().isEmpty() || editMUValor3.getText().toString().isEmpty()){
            res = false;
        }
        return res;
    }


    @SuppressLint("SetTextI18n")
    public void CalcularVelocidadeMU() {

        if (verficarValores()) {
            float Posicao1 = Float.parseFloat(editMUValor1.getText().toString());
            float Posicao2 = Float.parseFloat(editMUValor2.getText().toString());
            float Tempo = Float.parseFloat(editMUValor3.getText().toString());

            float Resultado = ((Posicao2 - Posicao1) / Tempo);

            exibirResultMU.setText(df.format(Resultado) +" m/s");
        } else {
            Toast.makeText(getApplicationContext(), "Campos vazios", Toast.LENGTH_SHORT).show();
        }

    }

    @SuppressLint("SetTextI18n")
    public void CalcularTempoMU() {

        if (verficarValores()) {
            float Posicao1 = Float.parseFloat(editMUValor1.getText().toString());
            float Posicao2 = Float.parseFloat(editMUValor2.getText().toString());
            float Velocidade = Float.parseFloat(editMUValor3.getText().toString());

            float Resultado = ((Posicao2 - Posicao1) / Velocidade);

            exibirResultMU.setText(df.format(Resultado) +" s");
        } else {
            Toast.makeText(getApplicationContext(), "Campos vazios", Toast.LENGTH_SHORT).show();
        }

    }

    @SuppressLint("SetTextI18n")
    public void CalcularPosicaoMU() {

        if (verficarValores()) {
            float Posicao1 = Float.parseFloat(editMUValor1.getText().toString());
            float Velocidade = Float.parseFloat(editMUValor2.getText().toString());
            float Tempo = Float.parseFloat(editMUValor3.getText().toString());

            float Resultado = (Posicao1 + (Velocidade * Tempo));

            exibirResultMU.setText(df.format(Resultado) +" m");
        } else {
            Toast.makeText(getApplicationContext(), "Campos vazios", Toast.LENGTH_SHORT).show();
        }

    }
}