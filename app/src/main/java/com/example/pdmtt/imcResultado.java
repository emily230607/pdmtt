package com.example.pdmtt;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

public class imcResultado extends AppCompatActivity {

    TextView tvResultado;
    ImageView imageView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_imc_resultado);
        tvResultado = findViewById(R.id.tvResultado);
        imageView = findViewById(R.id.imageViewPerfil);

        Intent i = getIntent();
        Bundle b = i.getExtras();
        Double peso = b.getDouble("peso");
        Double altura = b.getDouble("altura");

        Double imc = peso/(altura*altura);

        tvResultado.setText(Double.toString(imc));
        imageView.setImageResource(R.drawable.perfil);



    }
}