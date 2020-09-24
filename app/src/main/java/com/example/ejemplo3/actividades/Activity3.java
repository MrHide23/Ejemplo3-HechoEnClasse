package com.example.ejemplo3.actividades;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.SeekBar;
import android.widget.TextView;

import com.example.ejemplo3.R;

public class Activity3 extends AppCompatActivity {

    private TextView txtTitulo3;
    private SeekBar sbValor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_3);

        txtTitulo3 = findViewById(R.id.txtTitle3);
        sbValor = findViewById(R.id.sbValoAct3);

        Bundle mochila2 = this.getIntent().getExtras();
        if (mochila2 != null){
            String titulo = mochila2.getString("SALUDO");
            int valor=mochila2.getInt("NUMERO");

            txtTitulo3.setText(titulo);
            sbValor.setProgress(valor);
        }


    }
}