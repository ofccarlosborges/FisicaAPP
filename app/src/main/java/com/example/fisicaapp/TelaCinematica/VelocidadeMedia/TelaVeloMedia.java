package com.example.fisicaapp.TelaCinematica.VelocidadeMedia;

import androidx.appcompat.app.AppCompatActivity;

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

public class TelaVeloMedia extends AppCompatActivity {

   private EditText editCampo1VeloMedia, editCampo2VeloMedia;
   private TextView exibirResultVeloMedia;
   private Spinner escolhaVeloMedia;
   private Button btnCalcularVeloMedia;
   private TextInputLayout textInputLayoutVelo1, textInputLayoutVelo2;


    DecimalFormat df = new
            DecimalFormat("0.00");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_velo_media);

        textInputLayoutVelo1 = findViewById(R.id.textInputLayoutVelo1);
        textInputLayoutVelo2 = findViewById(R.id.textInputLayoutVelo2);

        exibirResultVeloMedia = findViewById(R.id.exibirResultVeloMedia);
        editCampo1VeloMedia = findViewById(R.id.editCampo1VeloMedia);
        editCampo2VeloMedia = findViewById(R.id.editCampo2VeloMedia);
        btnCalcularVeloMedia = findViewById(R.id.btnCalcularVeloMedia);
        escolhaVeloMedia = findViewById(R.id.escolhaVeloMedia);

        escolhaVelo();
    }


    private void escolhaVelo(){

        escolhaVeloMedia.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if(position == 0){
                    Toast.makeText(getApplication(), "Selecione opção.", Toast.LENGTH_SHORT).show();
                }
                else if (position == 1){
                    textInputLayoutVelo1.setHint("Digite a posição (m)");
                    textInputLayoutVelo2.setHint("Digite o tempo (s)");

                    btnCalcularVeloMedia.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            CalcularVelocidade();
                        }
                    });
                }
                else if (position == 2){
                    textInputLayoutVelo1.setHint("Digite a velocidade (m/s)");
                    textInputLayoutVelo2.setHint("Digite o tempo (s)");

                    btnCalcularVeloMedia.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            CalcularPosicao();
                        }
                    });
                }
                else if (position == 3){
                    textInputLayoutVelo1.setHint("Digite a posição (m)");
                    textInputLayoutVelo2.setHint("Digite a velocidade (m/s)");

                    btnCalcularVeloMedia.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            CalcularTempo();
                        }
                    });
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }




    public void CalcularVelocidade() {

        if (editCampo1VeloMedia.getText().toString().isEmpty() || editCampo2VeloMedia.getText().toString().isEmpty()) {

            Toast.makeText(getApplicationContext(), "Campos vazios", Toast.LENGTH_SHORT).show();
        } else {
            float Posicao = Float.parseFloat(editCampo1VeloMedia.getText().toString());
            float Tempo = Float.parseFloat(editCampo2VeloMedia.getText().toString());

            float Resultado = (Posicao / Tempo);

            exibirResultVeloMedia.setText(df.format(Resultado) +" m/s");
        }

    }
    public void CalcularPosicao() {

        if (editCampo1VeloMedia.getText().toString().isEmpty() || editCampo2VeloMedia.getText().toString().isEmpty()) {

            Toast.makeText(getApplicationContext(), "Campos vazios", Toast.LENGTH_SHORT).show();
        } else {
            float Velocidade = Float.parseFloat(editCampo1VeloMedia.getText().toString());
            float Tempo = Float.parseFloat(editCampo2VeloMedia.getText().toString());

            float Resultado = (Velocidade * Tempo);

            exibirResultVeloMedia.setText(df.format(Resultado) +" m");
        }

    }
    public void CalcularTempo() {

        if (editCampo1VeloMedia.getText().toString().isEmpty() || editCampo2VeloMedia.getText().toString().isEmpty()) {

            Toast.makeText(getApplicationContext(), "Campos vazios", Toast.LENGTH_SHORT).show();
        } else {
            float Posicao = Float.parseFloat(editCampo1VeloMedia.getText().toString());
            float Velocidade = Float.parseFloat(editCampo2VeloMedia.getText().toString());

            float Resultado = (Posicao / Velocidade);

            exibirResultVeloMedia.setText(df.format(Resultado) +" s");
        }







    }
}




