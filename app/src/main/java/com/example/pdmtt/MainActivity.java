package com.example.pdmtt;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    Button button;
    EditText editTextMin, editTextMax;
    TextView tv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        button=findViewById(R.id.button);
        editTextMin=findViewById(R.id.edMin);
        editTextMax=findViewById(R.id.edMax);
        tv=findViewById(R.id.tvResultado);

        button.setOnClickListener(v ->{

            Random random = new Random();

            int min,max;
            min=Integer.parseInt(editTextMin.getText().toString());
            max=Integer.parseInt(editTextMax.getText().toString());
            int delta= max- min;

            int sortiado= random.nextInt(delta)+min;
            tv.setText(Integer.toString(sortiado));
        });

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.wtf("ciclo de vida", "onStart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.wtf("ciclo de vida", "onResume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.wtf("ciclo de vida", "onResume");
    }
}