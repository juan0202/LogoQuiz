package com.example.logoquiz;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class Registro extends AppCompatActivity {

    Button registrate;
    EditText txtNom,txtCorreo,txtPass,txtUsu,txtGenero,txtEdad;

    SQLite_OpenHelper helper = new SQLite_OpenHelper(this, "BD1",null, 1);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);

        registrate = findViewById(R.id.registrate);
        txtNom = findViewById(R.id.nombre);
        txtCorreo = findViewById(R.id.correo);
        txtPass = findViewById(R.id.contrasena);
        txtUsu = findViewById(R.id.usu);
        txtEdad = findViewById(R.id.edad);
        txtGenero= findViewById(R.id.gen);

        registrate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                helper.insertarReg(String.valueOf(txtNom.getText()),
                        String.valueOf(txtCorreo.getText()),
                        String.valueOf(txtPass.getText()),
                        String.valueOf(txtUsu.getText()), String.valueOf(txtEdad.getText()), String.valueOf(txtGenero.getText()));
                helper.cerrar();
                Toast.makeText(getApplicationContext(), "Registro almacenado con exito",Toast.LENGTH_LONG).show();

               PasarMain();



            }
        });

    }

    public void PasarMain(){
        Intent intent = new Intent(this, Inicio.class);
        startActivity(intent);
    }




}
