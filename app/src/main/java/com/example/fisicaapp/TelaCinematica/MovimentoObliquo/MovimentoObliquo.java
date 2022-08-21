package com.example.fisicaapp.TelaCinematica.MovimentoObliquo;

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

import static java.lang.Math.abs;
import static java.lang.Math.cos;
import static java.lang.Math.pow;
import static java.lang.Math.sin;
import static java.lang.Math.sqrt;

public class MovimentoObliquo extends AppCompatActivity {

    private EditText editObliquoValor1, editObliquoValor2, editObliquoValor3;
    private TextView exibirResultObliquo;
    private Spinner escolhaObliquo;
    private Button btnCalcularObliquo;
    private TextInputLayout textInputLayoutObliquo, textInputLayoutObliquo2, textInputLayoutObliquo3;

    DecimalFormat df = new
            DecimalFormat("0.00");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movimento_obliquo);

        editObliquoValor1 = findViewById(R.id.editObliquoValor1);
        editObliquoValor2 = findViewById(R.id.editObliquoValor2);
        editObliquoValor3 = findViewById(R.id.editObliquoValor3);
        exibirResultObliquo = findViewById(R.id.exibirResultObliquo);
        escolhaObliquo = findViewById(R.id.escolhaObliquo);
        btnCalcularObliquo = findViewById(R.id.btnCalcularObliquo);
        textInputLayoutObliquo = findViewById(R.id.textInputLayoutObliquo);
        textInputLayoutObliquo2 = findViewById(R.id.textInputLayoutObliquo2);
        textInputLayoutObliquo3 = findViewById(R.id.textInputLayoutObliquo3);

        escolhaObliquo();
    }

    public void escolhaObliquo() {
        escolhaObliquo.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

                if (escolhaObliquo.getSelectedItem().equals("Selecione opção")) {
                    Toast.makeText(getApplicationContext(), "Selecione opção.", Toast.LENGTH_SHORT).show();
                } else if (escolhaObliquo.getSelectedItem().equals("Velocidade inicial em x")) {

                    textInputLayoutObliquo.setHint("Digite a Velocidade inicial (m/s)");
                    textInputLayoutObliquo2.setHint("Digite o ângulo");
                    textInputLayoutObliquo3.setVisibility(View.INVISIBLE);

                    bntAcao();

                } else if (escolhaObliquo.getSelectedItem().equals("Velocidade inicial em y")) {

                    textInputLayoutObliquo.setHint("Digite a Velocidade inicial (m/s)");
                    textInputLayoutObliquo2.setHint("Digite o ângulo");
                    textInputLayoutObliquo3.setVisibility(View.INVISIBLE);

                    bntAcao();

                } else if (escolhaObliquo.getSelectedItem().equals("Alcance Máximo")) {

                    textInputLayoutObliquo.setHint("Digite a Velocidade (m/s)");
                    textInputLayoutObliquo2.setHint("Digite o ângulo");
                    textInputLayoutObliquo3.setVisibility(View.VISIBLE);
                    textInputLayoutObliquo3.setHint("Digite a Gravidade (m/s²)");


                    bntAcao();
                } else if (escolhaObliquo.getSelectedItem().equals("Altura Máxima")) {

                    textInputLayoutObliquo.setHint("Digite a Velocidade inicial (m/s)");
                    textInputLayoutObliquo2.setHint("Digite o ângulo");
                    textInputLayoutObliquo3.setVisibility(View.VISIBLE);
                    textInputLayoutObliquo3.setHint("Digite a Gravidade (m/s²)");

                    bntAcao();

                } else if (escolhaObliquo.getSelectedItem().equals("Tempo de subida/queda")) {

                    textInputLayoutObliquo.setHint("Digite a Velocidade inicial (m/s)");
                    textInputLayoutObliquo2.setHint("Digite o ângulo");
                    textInputLayoutObliquo3.setVisibility(View.VISIBLE);
                    textInputLayoutObliquo3.setHint("Digite a Gravidade (m/s²)");

                    bntAcao();
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }

    public void bntAcao() {
        btnCalcularObliquo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (escolhaObliquo.getSelectedItem().equals("Velocidade inicial em x")) {
                    calcularMoviX();

                } else if (escolhaObliquo.getSelectedItem().equals("Velocidade inicial em y")) {
                    calcularMoviY();

                } else if (escolhaObliquo.getSelectedItem().equals("Alcance Máximo")) {
                    calcularAlcance();

                } else if (escolhaObliquo.getSelectedItem().equals("Altura Máxima")) {
                    calcularAltura();

                } else if (escolhaObliquo.getSelectedItem().equals("Tempo de subida/queda")) {
                    calcularTempo();
                }

            }
        });
    }


    public boolean verficarValores() {
        boolean res = true;
        if (editObliquoValor1.getText().toString().isEmpty() || editObliquoValor2.getText().toString().isEmpty() || editObliquoValor3.getText().toString().isEmpty()) {
            res = false;
        }
        return res;
    }

    @SuppressLint("SetTextI18n")
    public void calcularMoviX() {
        if (verficarValores()) {
            float VeloInical = Float.parseFloat(editObliquoValor1.getText().toString());
            float Angulo = Float.parseFloat(editObliquoValor2.getText().toString());
            float Resultado = (float) (abs(VeloInical) * cos(Angulo));
            exibirResultObliquo.setText(df.format(Resultado) +" m/s");

        } else {
            Toast.makeText(getApplicationContext(), "Campos vazios", Toast.LENGTH_SHORT).show();
        }
    }

    public void calcularMoviY() {
        if (verficarValores()) {
            float VeloInical = Float.parseFloat(editObliquoValor1.getText().toString());
            float Angulo = Float.parseFloat(editObliquoValor2.getText().toString());
            float Resultado = (float) (abs(VeloInical) * sin(Angulo));
            exibirResultObliquo.setText(df.format(Resultado) +" m/s");
        } else{
            Toast.makeText(getApplicationContext(), "Campos vazios", Toast.LENGTH_SHORT).show();
        }
    }

    public void calcularAltura(){
        if(verficarValores()){
            float VeloInicial = Float.parseFloat(editObliquoValor1.getText().toString());
            float Angulo = Float.parseFloat(editObliquoValor2.getText().toString());
            float Gravidade = Float.parseFloat(editObliquoValor3.getText().toString());
            float Resultado = (float) ((pow(VeloInicial,2)*pow(sin(2*Angulo),2)))/(2*Gravidade);
            exibirResultObliquo.setText(df.format(Resultado) +" m/s");

        } else {
            Toast.makeText(getApplicationContext(), "Campos vazios", Toast.LENGTH_SHORT).show();
        }
    }

    public void calcularAlcance(){
        if(verficarValores()){
            float Velo = Float.parseFloat(editObliquoValor1.getText().toString());
            float Angulo = Float.parseFloat(editObliquoValor2.getText().toString());
            float Gravidade = Float.parseFloat(editObliquoValor3.getText().toString());
            float Resultado = (float) ((pow(abs(Velo),2)*sin(2*Angulo))/Gravidade);

            exibirResultObliquo.setText(df.format(Resultado) +" m");
        } else {
            Toast.makeText(getApplicationContext(), "Campos vazios", Toast.LENGTH_SHORT).show();
        }
    }

    public void calcularTempo(){
        if(verficarValores()){
            float VeloInicial = Float.parseFloat(editObliquoValor1.getText().toString());
            float Angulo = Float.parseFloat(editObliquoValor2.getText().toString());
            float Gravidade = Float.parseFloat(editObliquoValor3.getText().toString());
            float Resultado = (float) (VeloInicial*sin(2*Angulo))/Gravidade;
            exibirResultObliquo.setText(df.format(Resultado) +" m/s");

        } else {
            Toast.makeText(getApplicationContext(), "Campos vazios", Toast.LENGTH_SHORT).show();
        }
    }



}