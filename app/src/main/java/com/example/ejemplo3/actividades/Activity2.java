package com.example.ejemplo3.actividades;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import com.example.ejemplo3.R;

public class Activity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_2);

        //Todas acts tiene acceso al intent que las creo

        Intent in2=this.getIntent();
        Bundle mochila2=in2.getExtras();

        if(mochila2!=null){
            int numero=mochila2.getInt("NUMERO");
            Toast.makeText(this, "Numero---> "+numero, Toast.LENGTH_SHORT).show();

        }else{
            Toast.makeText(this, "No hay DATOS", Toast.LENGTH_SHORT).show();
        }

    }
}