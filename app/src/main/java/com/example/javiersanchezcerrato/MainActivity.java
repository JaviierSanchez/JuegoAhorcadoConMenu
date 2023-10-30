package com.example.javiersanchezcerrato;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private TextView tvIntentos;
    private TextView tvPalabra;
    private EditText etLetra;
    private String[] ciudades = {"merida", "badajoz", "caceres", "trujillo", "guadalupe"};
    private char[] palabraActual; // Utilizamos un array de caracteres para representar la palabra.
    private String citySelect;
    private int contador = 10;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvIntentos = findViewById(R.id.intentos);
        tvPalabra = findViewById(R.id.palabra);
        etLetra = findViewById(R.id.letra);
    }

    public void nuevo(View vista) {
        int numAle = (int) (Math.random() * 5);
        citySelect = ciudades[numAle];
        palabraActual = new char[citySelect.length()];
        for (int i = 0; i < citySelect.length(); i++) {
            palabraActual[i] = '_';
        }

        actualizarPalabra();
        contador = 10;
        tvIntentos.setText("Intentos: " + contador);
    }

    public void averiguar(View vista) {
        String letra = etLetra.getText().toString();

        if (citySelect.contains(letra) && contador > 0) {
            for (int i = 0; i < citySelect.length(); i++) {
                if (citySelect.charAt(i) == letra.charAt(0) && palabraActual[i] == '_') {
                    palabraActual[i] = letra.charAt(0);
                }
            }

            actualizarPalabra();

            if (String.valueOf(palabraActual).equals(citySelect)) {
                Toast.makeText(this, "¡ADIVINASTE LA PALABRA!", Toast.LENGTH_SHORT).show();
            }
        } else {
            if (contador > 0) {
                contador--;
                tvIntentos.setText("Intentos: " + contador);
            } else {
                Toast.makeText(this, "SE ACABARON LOS INTENTOS", Toast.LENGTH_SHORT).show();
            }
        }
    }

    private void actualizarPalabra() {
        StringBuilder palabraMostrada = new StringBuilder();
        for (char letra : palabraActual) {
            palabraMostrada.append(letra);
            palabraMostrada.append(" "); // Agrega un espacio después de cada letra o guión bajo.
        }
        tvPalabra.setText(palabraMostrada.toString().trim()); // Quita el espacio al final.
    }
}