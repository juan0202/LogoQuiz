package com.example.logoquiz;

import android.media.Image;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    ImageButton[] img;
    TextView puntaje,nombre;
    int contador;
    String[] nombres = {"facebook","instagram","twitter","youtube","snapchat","whatsapp","ford","google","uber","rappi"};
    Random random = new Random();
    int indice,numale;
    String eleccion;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        indice = random.nextInt(nombre.length());
        img[0] = (ImageButton) findViewById(R.id.img1);
        img[1] = (ImageButton) findViewById(R.id.img2);
        img[2] = (ImageButton) findViewById(R.id.img3);
        img[3] = (ImageButton) findViewById(R.id.img4);
        puntaje = (TextView) findViewById(R.id.puntaje);
        nombre = (TextView) findViewById(R.id.nombre);


        cambiarNombre(contador,indice,nombres);

        img[0].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String[] retorno = generarOpcionesAleatorias();
                eleccion = retorno[0];
            }
        });

        img[1].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String[] retorno = generarOpcionesAleatorias();
                eleccion = retorno[1];
            }
        });

        img[2].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String[] retorno = generarOpcionesAleatorias();
                eleccion = retorno[2];
            }
        });

        img[3].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String[] retorno = generarOpcionesAleatorias();
                eleccion = retorno[3];
            }
        });











    }

    public void cambiarNombre(int cont,int ind,String[] nom){

            while(contador <= 5){
                indice = random.nextInt(nombres.length);
                nombre.setText(nombres[indice]);
                sumarPuntos(nombres,eleccion);

                img[0].setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        String[] retorno = generarOpcionesAleatorias();
                        eleccion = retorno[0];
                    }
                });

                img[1].setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        String[] retorno = generarOpcionesAleatorias();
                        eleccion = retorno[1];
                    }
                });

                img[2].setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        String[] retorno = generarOpcionesAleatorias();
                        eleccion = retorno[2];
                    }
                });

                img[3].setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        String[] retorno = generarOpcionesAleatorias();
                        eleccion = retorno[3];
                    }
                });


            }


        }

        public String[] generarOpcionesAleatorias() {
            numale = random.nextInt(nombres.length);
            String opcion[] = new String[img.length];

            for (int i = 0; i < img.length; i++) {
                switch (numale) {
                    case 0:
                        img[i].setImageResource(R.drawable.facebook);
                        opcion[i] = "facebook";
                    case 1:
                        img[i].setImageResource(R.drawable.instagram);
                        opcion[i] = "instagram";
                    case 3:
                        img[i].setImageResource(R.drawable.snapshat);
                        opcion[i] = "snapchat";
                    case 4:
                        img[i].setImageResource(R.drawable.twitter);
                        opcion[i] = "twitter";
                    case 5:
                        img[i].setImageResource(R.drawable.nbc);
                        opcion[i] = "nbc";
                    case 6:
                        img[i].setImageResource(R.drawable.logo2);
                        opcion[i] = "logo2";
                    default:
                        Toast.makeText(this, "Hola, la imagen no se puede poner", Toast.LENGTH_SHORT).show();


                }


            }
            return opcion;

        }



    public void sumarPuntos(String[] nombres,String eleccion){

        if(nombres[indice] == eleccion  ){
            contador++;
           puntaje.setText("Puntaje:"+ contador);

        }


    }
}
