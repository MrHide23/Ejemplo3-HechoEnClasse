package com.example.ejemplo3.actividades;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.RatingBar;

import com.example.ejemplo3.R;

public class Activity5 extends AppCompatActivity {

    RatingBar valoracion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_5);

        valoracion=findViewById(R.id.rbValoracionAt5);

        valoracion.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser) {
                Bundle moch1=new Bundle();
                moch1.putFloat("RATING",rating);
                Intent in=new Intent();
                in.putExtras(moch1);
                setResult(RESULT_OK, in);
                finish();
            }
        });
    }
}