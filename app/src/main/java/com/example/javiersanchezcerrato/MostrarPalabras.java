package com.example.javiersanchezcerrato;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import java.util.Collections;

public class MostrarPalabras extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mostrar_palabras);

        ListView lista = findViewById(R.id.lista);


        // Obtener la lista de palabras desde el intent
        String[] palabras = getIntent().getStringArrayExtra("resultado");


        ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1,palabras);

        lista.setAdapter(adapter);

        lista.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Uri pagina = Uri.parse("https://es.wikipedia.org/wiki/Wikipedia:Portada");
                Intent i = new Intent(Intent.ACTION_VIEW,pagina);
                startActivity(i);
            }
        });


    }



    public void volverInicio(View view){

        Intent i = new Intent(this, MainActivity.class);
        startActivity(i);

    }
}