package com.example.logoquiz;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Inicio extends AppCompatActivity {

    Button bo1,bo2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inicio);
        bo1 = (Button)findViewById(R.id.pasar);
        bo2 = (Button)findViewById(R.id.registrate);
        bo1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               PasarActivity();
            }
        });

        bo2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PasarActivity2();
            }
        });

    }

    public void PasarActivity(){
        Intent intent = new Intent(this , MainActivity.class);
        startActivity(intent);
    }

    public void PasarActivity2(){
        Intent intent = new Intent(this , Registro.class);
        startActivity(intent);
    }
}
