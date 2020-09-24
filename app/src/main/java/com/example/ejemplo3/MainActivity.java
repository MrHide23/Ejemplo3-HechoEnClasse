
package com.example.ejemplo3;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.ejemplo3.actividades.Activity2;
import com.example.ejemplo3.actividades.Activity3;
import com.example.ejemplo3.actividades.Activity4;
import com.example.ejemplo3.actividades.Activity5;
import com.example.ejemplo3.modelos.Persona;

public class MainActivity extends AppCompatActivity {

    private Button btnact2, btnact3,btnact4,btnact5;
    Persona persona;
    private final int ACT4=0;
    private final int ACT5=1;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnact2=findViewById(R.id.btnAct2Main);
        btnact3=findViewById(R.id.btnAct3Main);
        btnact4=findViewById(R.id.btnAct4Main);
        btnact5=findViewById(R.id.btnAct5Main);

        persona=new Persona("Edu","Samperis",41,180, 80,true);

    }

    public void clickButton(View boton){
        Button btnClicked=(Button)boton;

        Intent in=null;
        Bundle mochila=new Bundle();

        switch (btnClicked.getId()){
            case R.id.btnAct2Main:
                in=new Intent(MainActivity.this, Activity2.class);
                mochila.putInt("NUMERO",100);
                break;

            case R.id.btnAct3Main:
                in=new Intent(MainActivity.this, Activity3.class);
                mochila.putInt("NUMERO",50);
                mochila.putString("SALUDO", "Hola friki");
                break;

            case R.id.btnAct4Main:
                in=new Intent(MainActivity.this, Activity4.class);
                mochila.putParcelable("PERSONA", persona);

                in.putExtras(mochila);
                startActivityForResult(in, ACT4);
                break;

            case R.id.btnAct5Main:
                in=new Intent(MainActivity.this, Activity5.class);
                mochila.putInt("NUMERO",100);

                in.putExtras(mochila);
                startActivityForResult(in, ACT5); //A parte de Abe¡rir la actividad te notifica el resultado
                break;
        }

        in.putExtras(mochila); //HACER SIEMPRE
        startActivity(in);

    } //Hacer esto sabiendo que es un botton

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode==ACT4){
            if (resultCode==RESULT_OK){
                if (data!=null){
                    persona=data.getExtras().getParcelable("PERSONA");
                }
            }
        }

        if (requestCode==ACT5){
            Toast.makeText(this, "Actividad 5", Toast.LENGTH_SHORT).show();
            if (data!=null){
                float rating= getIntent().getExtras().getFloat("RATING"); //SCAMO EL VALOR "RAING" de la mochila, que se encurntra en el bundle
                Toast.makeText(this, "rating--> "+rating, Toast.LENGTH_SHORT).show();
            }

        }

    }
}