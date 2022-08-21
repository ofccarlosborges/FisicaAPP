package com.example.fisicaapp.Conversor;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.fisicaapp.DAO.DAO;
import com.example.fisicaapp.R;

import java.text.DecimalFormat;

public class conversor2 extends AppCompatActivity {

    Spinner spinner_conversor, escolhaConverterDe, escolhaConverterPara;
    private EditText editTextConverter2;
    private TextView Resultconversor2;
    DecimalFormat df = new
            DecimalFormat("0.0");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_conversor2);

    spinner_conversor = findViewById(R.id.escolhaConversor);
    escolhaConverterDe = findViewById(R.id.escolhaConverterDe);
    escolhaConverterPara = findViewById(R.id.escolhaConverterPara);
    editTextConverter2 = findViewById(R.id.editTextConverter2);
    Resultconversor2 = findViewById(R.id.Resultconversor2);

    editTextConverter2.addTextChangedListener(textWatcher);

    DAO dao = new DAO(this, "dados_spinner_conversor",null,1);

        ArrayAdapter<String> adapter_spinner = new ArrayAdapter<>(this,
                android.R.layout.simple_list_item_1, dao.buscaDadosSpinnerConversor());

    spinner_conversor.setAdapter(adapter_spinner);



    spinner_conversor.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
        @Override
        public void onItemSelected(AdapterView<?> adapterView, View view, int position, long l) {

            if(spinner_conversor.getSelectedItem().equals("Velocidade")){

                ArrayAdapter adapter2 = ArrayAdapter.createFromResource(getBaseContext(),
                        R.array.ConverterVelocidade2, android.R.layout.simple_spinner_item);
                escolhaConverterDe.setAdapter(adapter2);

                ArrayAdapter adapter3 = ArrayAdapter.createFromResource(getBaseContext(),
                        R.array.ConverterVelocidade2, android.R.layout.simple_spinner_item);
                escolhaConverterPara.setAdapter(adapter3);

                SelecaoSpinner();
            }

        }

        @Override
        public void onNothingSelected(AdapterView<?> adapterView) {

        }
    });

    }

    public void SelecaoSpinner(){
        if((escolhaConverterDe.getSelectedItem().equals("m/s")) && (escolhaConverterPara.getSelectedItem().equals("km/h"))){
            CalcularMetroQuilometro();
        } else if((escolhaConverterDe.getSelectedItem().equals("km/h")) && (escolhaConverterPara.getSelectedItem().equals("m/s"))){
            CalcularQuilometroMetro();
        } else if((escolhaConverterDe.getSelectedItem()) == (escolhaConverterPara.getSelectedItem())){

        }
    }

    private boolean verificarValores() {
        boolean res = true;
        if (editTextConverter2.getText().toString().isEmpty()) {
            res = false;
        }
        return res;
    }

    TextWatcher textWatcher = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

        }

        @Override
        public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {


            if((escolhaConverterDe.getSelectedItem().equals("m/s")) && (escolhaConverterPara.getSelectedItem().equals("km/h"))){

                if (editTextConverter2.getText().toString().isEmpty()){
                    Resultconversor2.setText(null);
                } else {

                    float Valor = Float.parseFloat(editTextConverter2.getText().toString());
                    float Resultado = (float) (Valor * 3.6);
                    Resultconversor2.setText(df.format(Resultado));

                    //Resultconversor2.setText(editTextConverter2.getText().toString());
                }


            }



        }

        @Override
        public void afterTextChanged(Editable editable) {

        }

    };



    @SuppressLint("SetTextI18n")
    private void CalcularMetroQuilometro() {
        if (verificarValores()) {


        } else {
            Toast.makeText(getApplicationContext(), "Campos vazios", Toast.LENGTH_SHORT).show();
        }
    }

    @SuppressLint("SetTextI18n")
    private void CalcularQuilometroMetro() {
        if (verificarValores()) {
            float Valor = Float.parseFloat(editTextConverter2.getText().toString());
            float Resultado = (float) (Valor / 3.6);
            Resultconversor2.setText(df.format(Resultado));

        } else {
            Toast.makeText(getApplicationContext(), "Campos vazios", Toast.LENGTH_SHORT).show();
        }
    }



}