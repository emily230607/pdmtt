package com.example.pdmtt;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.text.DecimalFormat;

public class IMCResultado extends AppCompatActivity {

    TextView tvPeso, tvAltura, tvImc;
    ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_imc_resultado);

        tvPeso = findViewById(R.id.tvPeso);
        tvAltura = findViewById(R.id.tvAltura);
        tvImc = findViewById(R.id.tvImc);
        imageView = findViewById(R.id.imgPerfil);

        Bundle b = getIntent().getExtras();

        float peso = b.getFloat("peso");
        float altura = b.getFloat("altura");
        float imc = peso / (altura * altura);

        DecimalFormat df = new DecimalFormat("#.##");

        tvPeso.setText("Peso: " + df.format(peso) + " kg");
        tvAltura.setText("Altura: " + df.format(altura) + " m");
        tvImc.setText("IMC: " + df.format(imc));

        if (imc < 18.5) {
            imageView.setImageResource(R.drawable.abaixopeso);
        } else if (imc >= 18.5 && imc < 25) {
            imageView.setImageResource(R.drawable.normal);
        } else if (imc >= 25 && imc < 30) {
            imageView.setImageResource(R.drawable.sobrepeso);
        } else if (imc >= 30 && imc < 35) {
            imageView.setImageResource(R.drawable.obesidade1);
        } else if (imc >= 35 && imc < 40) {
            imageView.setImageResource(R.drawable.obesidade2);
        } else {
            imageView.setImageResource(R.drawable.obesidade3);
        }
    }
}