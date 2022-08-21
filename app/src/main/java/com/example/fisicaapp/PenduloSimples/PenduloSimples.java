package com.example.fisicaapp.PenduloSimples;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.fisicaapp.R;
import com.google.android.material.textfield.TextInputLayout;

import java.text.DecimalFormat;

import static java.lang.Math.pow;
import static java.lang.StrictMath.PI;
import static java.lang.StrictMath.sqrt;

public class PenduloSimples extends AppCompatActivity {

    private EditText editPenduloValor1, editPenduloValor2;
    private Spinner escolhaPenduloSimples;
    private Button btnCalcularPenduloSimples;
    private TextView exibirResultPenduloSimples, textValorPI;
    private TextInputLayout textInputLayoutPendulo1, textInputLayoutPendulo2;
    private LinearLayout linearLayoutAlert;

    DecimalFormat df = new
            DecimalFormat("0.00");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pendulo_simples);

        editPenduloValor1 = findViewById(R.id.editPenduloValor1);
        editPenduloValor2 = findViewById(R.id.editPenduloValor2);
        escolhaPenduloSimples = findViewById(R.id.escolhaPenduloSimples);
        exibirResultPenduloSimples = findViewById(R.id.exibirResultPenduloSimples);
        textValorPI = findViewById(R.id.textValorPI);
        btnCalcularPenduloSimples = findViewById(R.id.btnCalcularPenduloSimples);
        textInputLayoutPendulo1 = findViewById(R.id.textInputLayoutPendulo1);
        textInputLayoutPendulo2 = findViewById(R.id.textInputLayoutPendulo2);
        linearLayoutAlert = findViewById(R.id.linearLayoutAlert);

        escolhaPenduloSimples();

    }

    private void escolhaPenduloSimples(){

        escolhaPenduloSimples.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if(position == 0){
                    Toast.makeText(getApplicationContext(), "Selecione opção.", Toast.LENGTH_SHORT).show();
                    linearLayoutAlert.setVisibility(View.INVISIBLE);

                }
                else if(position == 1){
                    textInputLayoutPendulo1.setHint("Digite o comprimento do fio (m)");
                    textInputLayoutPendulo2.setHint("Digite o valor da gravidade (m/s²)");

                    btnCalcularPenduloSimples.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {

                            CalcularPeriodo();
                        }
                    });
                }
                else if(position == 2){
                    textInputLayoutPendulo1.setHint("Digite o período (s)");
                    textInputLayoutPendulo2.setHint("Digite o valor da gravidade (m/s²)");

                    btnCalcularPenduloSimples.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {

                            CalcularComprimento();
                        }
                    });
                }
                else if(position == 3){
                    textInputLayoutPendulo1.setHint("Digite o comprimento do fio (m)");
                    textInputLayoutPendulo2.setHint("Digite o período (s)");

                    btnCalcularPenduloSimples.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            CalcularAceleracao();
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
        if(editPenduloValor2.getText().toString().isEmpty() || editPenduloValor1.getText().toString().isEmpty()){
            res = false;
        }
        return res;
    }

    @SuppressLint("SetTextI18n")
    public void CalcularPeriodo(){
        if(verficarValores()){

            float comprimento = Float.parseFloat(editPenduloValor1.getText().toString());
            float gravidade = Float.parseFloat(editPenduloValor2.getText().toString());

            double Resultado = (2 * PI) * (sqrt(comprimento/gravidade));

            exibirResultPenduloSimples.setText(df.format(Resultado) +" s");
            textValorPI.setText("ATENÇÃO!\nVALOR DE PI = "+PI);
            linearLayoutAlert.setVisibility(View.VISIBLE);

        } else {
            Toast.makeText(getApplicationContext(), "Campos vazios", Toast.LENGTH_SHORT).show();
        }
    }

    @SuppressLint("SetTextI18n")
    public void CalcularComprimento(){
        if(verficarValores()){

            float periodo = Float.parseFloat(editPenduloValor1.getText().toString());
            float gravidade = Float.parseFloat(editPenduloValor2.getText().toString());

            double Resultado = (pow(periodo, 2) * gravidade) / (4 * pow(PI, 2));

            exibirResultPenduloSimples.setText(df.format(Resultado) +" m");
            textValorPI.setText("ATENÇÃO!\nVALOR DE PI = "+PI);
            linearLayoutAlert.setVisibility(View.VISIBLE);

        } else {
            Toast.makeText(getApplicationContext(), "Campos vazios", Toast.LENGTH_SHORT).show();
        }
    }

    @SuppressLint("SetTextI18n")
    public void CalcularAceleracao(){
        if(verficarValores()){

            float comprimento = Float.parseFloat(editPenduloValor1.getText().toString());
            float periodo = Float.parseFloat(editPenduloValor2.getText().toString());

            double Resultado = (4 * pow(PI, 2) * comprimento) / pow(periodo,2);

            exibirResultPenduloSimples.setText(df.format(Resultado) +" m/s²");
            textValorPI.setText("ATENÇÃO!\nVALOR DE PI = "+PI);
            linearLayoutAlert.setVisibility(View.VISIBLE);

        } else {
            Toast.makeText(getApplicationContext(), "Campos vazios", Toast.LENGTH_SHORT).show();
        }
    }

}