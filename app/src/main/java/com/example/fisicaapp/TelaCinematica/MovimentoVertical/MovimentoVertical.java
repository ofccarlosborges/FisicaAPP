package com.example.fisicaapp.TelaCinematica.MovimentoVertical;

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

import static java.lang.StrictMath.PI;
import static java.lang.StrictMath.pow;
import static java.lang.StrictMath.sqrt;

public class MovimentoVertical extends AppCompatActivity {

    private EditText editMovimentoVertical, editMovimentoVertical2;
    private Spinner escolhaMovimentoVertical;
    private Button btnCalcularMovimentoVertical;
    private TextView exibirResultMovimentoVertical;

    DecimalFormat df = new
            DecimalFormat("0.00");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movimento_vertical);

        editMovimentoVertical = findViewById(R.id.editMovimentoVertical);
        editMovimentoVertical2 = findViewById(R.id.editMovimentoVertical2);
        escolhaMovimentoVertical = findViewById(R.id.escolhaMovimentoVertical);
        exibirResultMovimentoVertical = findViewById(R.id.exibirResultMovimentoVertical);
        btnCalcularMovimentoVertical = findViewById(R.id.btnCalcularMovimentoVertical);

        escolhaMV();
    }

    private void escolhaMV(){
        escolhaMovimentoVertical.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if (position == 0){
                    Toast.makeText(getApplicationContext(), "Selecione opção.", Toast.LENGTH_SHORT).show();
                }
                else if (position == 1){
                    btnCalcularMovimentoVertical.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            CalcularTempo();
                        }
                    });
                }
                else if (position == 2){
                    btnCalcularMovimentoVertical.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            CalcularAltura();
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
        if(editMovimentoVertical.getText().toString().isEmpty() || editMovimentoVertical2.getText().toString().isEmpty()){
            res = false;
        }
        return res;
    }

    @SuppressLint("SetTextI18n")
    private void CalcularTempo(){
        if (verficarValores()){

            float VeloInicial = Float.parseFloat(editMovimentoVertical.getText().toString());
            float gravidade = Float.parseFloat(editMovimentoVertical2.getText().toString());

            double Resultado = VeloInicial/gravidade;

            exibirResultMovimentoVertical.setText(df.format(Resultado) +" s");
        } else {
            Toast.makeText(getApplicationContext(), "Campos vazios", Toast.LENGTH_SHORT).show();
        }
        }

    @SuppressLint("SetTextI18n")
    private void CalcularAltura(){
        if (verficarValores()){

            float VeloInicial = Float.parseFloat(editMovimentoVertical.getText().toString());
            float gravidade = Float.parseFloat(editMovimentoVertical2.getText().toString());

            double Resultado = (pow(VeloInicial,2)/(2*gravidade));

            exibirResultMovimentoVertical.setText(df.format(Resultado) +"m");
        } else {
            Toast.makeText(getApplicationContext(), "Campos vazios", Toast.LENGTH_SHORT).show();
        }
    }

}