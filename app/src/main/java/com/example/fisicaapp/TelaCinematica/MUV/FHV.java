package com.example.fisicaapp.TelaCinematica.MUV;

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

public class FHV extends AppCompatActivity {

    DecimalFormat df = new
            DecimalFormat("0.00");

    private EditText editfhvValor1, editfhvValor2, editfhvValor3;
    private Spinner escolhafhv;
    private TextView exibirResultfhv;
    private TextInputLayout textInputLayoutfhv, textInputLayoutfhv2, textInputLayoutfhv3;
    private Button btnCalcularfhv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_f_h_v);

        editfhvValor1 = findViewById(R.id.editfhvValor1);
        editfhvValor2 = findViewById(R.id.editfhvValor2);
        editfhvValor3 = findViewById(R.id.editfhvValor3);
        exibirResultfhv = findViewById(R.id.exibirResultfhv);
        escolhafhv = findViewById(R.id.escolhafhv);
        btnCalcularfhv = findViewById(R.id.btnCalcularfhv);
        textInputLayoutfhv = findViewById(R.id.textInputLayoutfhv);
        textInputLayoutfhv2 = findViewById(R.id.textInputLayoutfhv2);
        textInputLayoutfhv3 = findViewById(R.id.textInputLayoutfhv3);

        escolhaFHV();

    }

    public boolean verficarValores() {
        boolean res = true;
        if (editfhvValor1.getText().toString().isEmpty() || editfhvValor2.getText().toString().isEmpty() || editfhvValor3.getText().toString().isEmpty()) {
            res = false;
        }
        return res;
    }

    public void escolhaFHV() {
        escolhafhv.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int position, long l) {

                if (position == 0) {
                    Toast.makeText(getApplicationContext(), "Selecione opção.", Toast.LENGTH_SHORT).show();

                } else if (position == 1) {
                    textInputLayoutfhv.setHint("Digite a Velocidade inicial (m/s)");
                    textInputLayoutfhv2.setHint("Digite a Aceleração (m/s²)");
                    textInputLayoutfhv3.setHint("Digite o Tempo (s)");

                    btnCalcularfhv.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {

                            calcularVelocidade();
                        }
                    });
                } else if(position == 2){
                    textInputLayoutfhv.setHint("Digite a Velocidade (m/s)");
                    textInputLayoutfhv2.setHint("Digite o Tempo  (s)");
                    textInputLayoutfhv3.setHint("Digite a Aceleracao (m/s²)");

                    btnCalcularfhv.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {

                            calcularVelocidadeInicialFHV();
                        }
                    });
                } else if(position ==3){
                    textInputLayoutfhv.setHint("Digite a Velocidade (m/s)");
                    textInputLayoutfhv2.setHint("Digite a Velocidade inicial  (m/s)");
                    textInputLayoutfhv3.setHint("Digite a Aceleracao (m/s²)");

                    btnCalcularfhv.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {

                            calcularTempo();
                        }
                    });
                } else if(position == 4){
                    textInputLayoutfhv.setHint("Digite a Velocidade (m/s)");
                    textInputLayoutfhv2.setHint("Digite a Velocidade inicial  (m/s)");
                    textInputLayoutfhv3.setHint("Digite o Tempo (s)");

                    btnCalcularfhv.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {

                            calcularAceleracaoFHV();
                        }
                    });
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

    }

    public void calcularAceleracaoFHV() {

        if (verficarValores()) {
            float Velocidade = Float.parseFloat(editfhvValor1.getText().toString());
            float VelocidadeInicial = Float.parseFloat(editfhvValor2.getText().toString());
            float Tempo = Float.parseFloat(editfhvValor3.getText().toString());

            float Aceleracao = (Velocidade - VelocidadeInicial) / Tempo;

            exibirResultfhv.setText(df.format(Aceleracao) + " m/s");
        } else {
            Toast.makeText(getApplicationContext(), "Campos vazios", Toast.LENGTH_SHORT).show();
        }
    }

    public void calcularVelocidadeInicialFHV() {
        if (verficarValores()) {
            float Velocidade = Float.parseFloat(editfhvValor1.getText().toString());
            float Tempo = Float.parseFloat(editfhvValor2.getText().toString());
            float Aceleracao = Float.parseFloat(editfhvValor3.getText().toString());

            float VelocidadeInicial = Velocidade - (Aceleracao * Tempo);
            exibirResultfhv.setText(df.format(Aceleracao) + " m/s");
        } else {
            Toast.makeText(getApplicationContext(), "Campos vazios", Toast.LENGTH_SHORT).show();
        }

    }

    public void calcularTempo() {
        if (verficarValores()) {
            float Velocidade = Float.parseFloat(editfhvValor1.getText().toString());
            float VelocidadeInicial = Float.parseFloat(editfhvValor2.getText().toString());
            float Aceleracao = Float.parseFloat(editfhvValor3.getText().toString());

            float Tempo = ((Velocidade-VelocidadeInicial)/Aceleracao);

            exibirResultfhv.setText(df.format(Tempo) + " m/s");
        } else {
            Toast.makeText(getApplicationContext(), "Campos vazios", Toast.LENGTH_SHORT).show();
        }
    }
    public void calcularVelocidade(){
        if (verficarValores()){
            float VelocidadeInicial = Float.parseFloat(editfhvValor1.getText().toString());
            float Tempo = Float.parseFloat(editfhvValor3.getText().toString());
            float Aceleracao = Float.parseFloat(editfhvValor2.getText().toString());

            float Velocidade = (VelocidadeInicial+(Aceleracao*Tempo));
            exibirResultfhv.setText(df.format(Velocidade) + " m/s");
        }else{
            Toast.makeText(getApplicationContext(), "Campos vazios", Toast.LENGTH_SHORT).show();
        }
    }

}
