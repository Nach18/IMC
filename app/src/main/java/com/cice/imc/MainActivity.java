package com.cice.imc;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.text.ParseException;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final EditText Altura = findViewById(R.id.altura);
        final EditText Peso = findViewById(R.id.peso);
        final TextView Resultado = findViewById(R.id.resultado);
        Button Boton = findViewById(R.id.boton);

        Boton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String alturaDada = Altura.getText().toString();
                String pesoDado = Peso.getText().toString();

                if(!alturaDada.isEmpty() && !pesoDado.isEmpty()) {
                    try {
                        double alturaNum = Double.parseDouble(alturaDada);
                        double pesoNum = Double.parseDouble(pesoDado);

                        double resultadoIMC = pesoNum / (alturaNum * alturaNum);

                        Resultado.setText(String.valueOf(resultadoIMC));

                    } catch (Exception e) {

                        Toast.makeText(MainActivity.this, "Solo valen datos numericos", Toast.LENGTH_LONG).show();

                    }
                } else {

                    Toast.makeText(MainActivity.this, "No has introducido ningún dato", Toast.LENGTH_LONG).show();

                }
            }
        });
    }


}
