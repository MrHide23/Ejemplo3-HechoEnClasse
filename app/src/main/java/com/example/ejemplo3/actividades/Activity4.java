package com.example.ejemplo3.actividades;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.Toast;

import com.example.ejemplo3.R;
import com.example.ejemplo3.modelos.Persona;

public class Activity4 extends AppCompatActivity {
    private EditText txtNombre, txtApellidos, txtEdad, txtAltura, txtPeso;
    private Switch swcasado;
    private Button btnGuardar, btnCancelar;

    Persona p;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_4);

        InicializaVariables(); //Inicializamos las varibales del act4

        //Asignamos los valores
        p=getIntent().getExtras().getParcelable("PERSONA");

        if(p!=null){
            RellenarDatos(); //Pasmos los datos de PERSONA--->Act4
        }else{
            Toast.makeText(this, "No tengo DATOS", Toast.LENGTH_SHORT).show();
        }

        btnCancelar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setResult(RESULT_CANCELED); //Con esto la actividad_main se chapara y no ara nada
                finish();
            }
        });

        btnGuardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                p.setNombre(txtNombre.getText().toString());
                p.setApellidos(txtApellidos.getText().toString());
                p.setEdad(Integer.parseInt(txtEdad.getText().toString()));
                p.setAltura(Float.parseFloat(txtAltura.getText().toString()));
                p.setPeso(Float.parseFloat(txtPeso.getText().toString()));
                p.setCasado(swcasado.isChecked());

                Bundle moch=new Bundle();
                moch.putParcelable("persona",p);
                Intent intent=new Intent();
                intent.putExtras(moch);
                setResult(RESULT_OK, intent);
                finish();
            }
        });
    }

    private void RellenarDatos() {
        txtNombre.setText(p.getNombre());
        txtApellidos.setText(p.getApellidos());
        txtEdad.setText(String.valueOf(p.getEdad()));
        txtAltura.setText(String.valueOf(p.getAltura()));
        txtPeso.setText(String.valueOf(p.getPeso()));
        swcasado.setChecked(p.isCasado());
    }

    private void InicializaVariables() {
        txtNombre=findViewById(R.id.txtNombreAct4);
        txtApellidos=findViewById(R.id.txtApellidoAct4);
        txtEdad=findViewById(R.id.txtEdadAct4);
        txtAltura=findViewById(R.id.txtAlturaAct4);
        swcasado=findViewById(R.id.swCasadoAct4);
        btnGuardar=findViewById(R.id.btnGuardarAct4);
        btnCancelar=findViewById(R.id.btnCancelarAct4);
    }
}