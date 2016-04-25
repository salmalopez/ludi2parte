package com.ludi.tt_ludi;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.content.res.ResourcesCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class Ahorcado extends AppCompatActivity implements View.OnClickListener{

    private final String[] preguntas = {
            "Grupo alimenticio que te aporta principalmente fibra.",
            "Cereal que te aporta más energía.",
            "Color que tienen los cereales y tubérculos en el plato del bien comer.",
            "Avena, granola, tortillas y bolillo son ejemplos de...¿?",
            "Nutriente que nos ayuda a regular los procesos digestivos y disminuye las cantidades de colesterol en la sangre.",
            "Papa, camote, jícama y ajo son ejemplos de...¿?",
            "Nutriente que nos ayuda a regular los procesos digestivos y disminuye las cantidades de colesterol en la sangre.",
            "Son los cereales que contienen mucha azúcar y químicos, los cuales no nutren."};

    //IMPORTANTE: No quitar los puntos de las respuestas que lo contienen
    private final String[] arregloRespuestas = {
        "Cereales.", "Integral", "Amarillo", "Cereales", "Fibra", "Tuberculos", "Fibra.", "Industrializados"
    };

    HashMap<Integer, String> respuestas;
    HashMap<String, Integer> posicionPreguntas;

    private final Button[] opciones = {
            (Button) findViewById(R.id.button3),
            (Button) findViewById(R.id.button2),
            (Button) findViewById(R.id.button5),
            (Button) findViewById(R.id.button7),
            (Button) findViewById(R.id.button1),
            (Button) findViewById(R.id.button8),
            (Button) findViewById(R.id.button4),
            (Button) findViewById(R.id.button6),
    };

    private ImageView ahorcado;
    private final Drawable[] imagenes = {
            ResourcesCompat.getDrawable(getResources(), R.drawable.ahorcado0, null),
            ResourcesCompat.getDrawable(getResources(), R.drawable.ahorcado1, null),
            ResourcesCompat.getDrawable(getResources(), R.drawable.ahorcado2, null),
            ResourcesCompat.getDrawable(getResources(), R.drawable.ahorcado3, null),
            ResourcesCompat.getDrawable(getResources(), R.drawable.ahorcado4, null),
            ResourcesCompat.getDrawable(getResources(), R.drawable.ahorcado5, null),
            ResourcesCompat.getDrawable(getResources(), R.drawable.ahorcado6, null),
            ResourcesCompat.getDrawable(getResources(), R.drawable.ahorcado7, null)
    };
    private int pointerPreguntas, pointerAhorcado, correctas;
    private TextView pregunta;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ahorcado);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        iniciar();
    }

    @Override
    public void onClick(View v) {
        if(esBoton(v)){
            Button boton = (Button)findViewById(v.getId());

            /*
            * 1) Obtiene el texto del botón.
            * 2) Obtiene la posición a la que corresponde dicha respuesta.
            * 3) Compara la posición de la pregunta actual con la posición correspondiente de la respuesta elegida.
            * 4) Verifica si son iguales para saber si es correcta.
            * */
            if(posicionPreguntas.get(boton.getText())==(pointerPreguntas-1)){
                Toast toast = Toast.makeText(this, "¡Correcto!",Toast.LENGTH_SHORT);
                toast.show();
                correctas++;
                boton.setEnabled(false);
                if(correctas < 8)
                    mostrarPregunta();
                else{
                    ganar();
                }
            }else{
                avanzarAhorcado();
            }
        }else{
            switch (v.getId()){
                case R.id.btnReiniciar:
                    iniciar();
                    break;
                case R.id.btnCuestionario:
                    Intent intent = new Intent(this,CuestionarioAct2.class);
                    startActivity(intent);
                    break;
            }
        }

    }

    private void ganar(){
        ahorcado.setBackground(ResourcesCompat.getDrawable(getResources(), R.drawable.ahorcadowin, null));
        AlertDialog alertDialog = new AlertDialog.Builder(Ahorcado.this).create();
        alertDialog.setTitle("¡Felicidades!");
        alertDialog.setMessage("Has ganado el juego, puedes continuar al cuestionario.");
        alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL, "OK",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                });
        alertDialog.show();
    }

    private void mostrarPregunta(){
        pregunta.setText(preguntas[pointerPreguntas++]);
    }

    private void avanzarAhorcado(){
        Toast toast = Toast.makeText(this, "¡Oops! Intenta con otra opicón.",Toast.LENGTH_SHORT);
        toast.show();
        ahorcado.setBackground(imagenes[pointerAhorcado++]);
        if(pointerAhorcado == 8){
            AlertDialog alertDialog = new AlertDialog.Builder(Ahorcado.this).create();
            alertDialog.setTitle("¡Vaya!");
            alertDialog.setMessage("Se te han terminado los intentos, puedes intentarlo de nuevo o ir al cuestionario.");
            alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL, "OK",
                    new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {
                            dialog.dismiss();
                        }
                    });
            alertDialog.show();
        }
    }

    private void iniciar(){
        pregunta = (TextView) findViewById(R.id.pregunta);
        ahorcado = (ImageView) findViewById(R.id.imagen);

        respuestas = new HashMap<Integer,String>();
        posicionPreguntas = new HashMap<String,Integer>();

        ahorcado.setBackground(ResourcesCompat.getDrawable(getResources(), R.drawable.comenzar_ahorcado, null));

        for(int i=0; i<arregloRespuestas.length; i++){
            respuestas.put(opciones[i].getId(),arregloRespuestas[i]);
            posicionPreguntas.put(arregloRespuestas[i], i);
            opciones[i].setText(arregloRespuestas[i]);
            opciones[i].setEnabled(true);
        }


        AlertDialog alertDialog = new AlertDialog.Builder(Ahorcado.this).create();
        alertDialog.setTitle("¡Hola!");
        alertDialog.setMessage("Puedes comenzar a jugar seleccionando la respuesta correcta.");
        alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL, "OK",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                });
        alertDialog.show();

        pointerPreguntas = 0;
        pointerAhorcado = 0;
        correctas = 0;
        mostrarPregunta();
    }

    private boolean esBoton(View v){
        Iterator it = respuestas.entrySet().iterator();
        Map.Entry pair;
        while (it.hasNext()) {
            pair = (Map.Entry)it.next();
            if( v.getId() == (Integer)pair.getKey() )
                return true;
        }
        return false;
    }
}
