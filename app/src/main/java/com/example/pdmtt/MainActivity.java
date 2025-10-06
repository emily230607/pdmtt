package com.example.pdmtt;

import android.os.Bundle;
import android.renderscript.Script;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<String> nomes;

    ListView listView;

    Button button;

    EditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        listView = findViewById(R.id.listview);
        button = findViewById(R.id.salvar);
        editText = findViewById(R.id.editarNome);
        nomes = new ArrayList<String>();


        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        ArrayAdapter<String> adapter= new ArrayAdapter<>(getApplicationContext(),
                android.R.layout.simple_list_item_1,
                android.R.id.text1,
                nomes);


        listView.setAdapter(adapter);
        button.setOnClickListener(v -> {
            nomes.add(editText.getText().toString());
            adapter.notifyDataSetChanged();
            //adicionar elemento a listagem
            /**Toast.makeText(getApplicationContext(),nomes[position], Toast.LENGTH_LONG).show();
             **/
        });

        listView.setOnItemClickListener((parent, view, position, id) ->{
            //Excluir elementos ou listagem
            /** Toast.makeText(this,(position)+nomes[position], Toast.LENGTH_SHORT).show();
             **/
        });

    }
}