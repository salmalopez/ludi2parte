package com.ludi.tt_ludi;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v4.content.res.ResourcesCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class Ahorcado extends AppCompatActivity implements View.OnClickListener{

    Button button1, button2,button3,button4,button5,button6,button7,button8;
    MediaPlayer botonaplauso, sonidoerror, sonidoperdio, sonidobien;

    private final String[] preguntas = {
            "1) Grupo alimenticio que te aporta principalmente fibra.",
            "2) Cereal que te aporta más energía.",
            "3) Color que tienen los cereales y tubérculos en el plato del bien comer.",
            "4) Avena, granola, tortillas y bolillo son ejemplos de...¿?",
            "5) Nutriente que nos ayuda a regular los procesos digestivos y disminuye las cantidades de colesterol en la sangre.",
            "6) Papa, camote, jícama y ajo son ejemplos de...¿?",
            "7) Nutriente que nos ayuda a regular los procesos digestivos y disminuye las cantidades de colesterol en la sangre.",
            "8) Son los cereales que contienen mucha azúcar y químicos, los cuales no nutren."};

    private final String[] arregloRespuestas = {
        "Cereales", "Integral", "Amarillo", "Cereales", "Fibra", "Tuberculos", "Fibra", "Industrializados"
    };

    private Button[] opciones;

    private Button btnReiniciar,btnCuestionario,btn_regresar;

    private ImageView ahorcado;
    private  Drawable[] imagenes;
    private int pointerPreguntas, pointerAhorcado, correctas;
    private TextView pregunta;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ahorcado);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        botonaplauso = MediaPlayer.create(Ahorcado.this, R.raw.aplauso);
        sonidoerror  = MediaPlayer.create(Ahorcado.this, R.raw.sonidito);
        sonidoperdio = MediaPlayer.create(Ahorcado.this, R.raw.tache1);
        sonidobien = MediaPlayer.create(Ahorcado.this, R.raw.bien1);

        Typeface myTypeFace2 = Typeface.createFromAsset(getAssets(),"DK.ttf");
        pregunta = (TextView) findViewById(R.id.pregunta);
        pregunta.setTypeface(myTypeFace2);

        button1 = (Button) findViewById(R.id.button1);
        button1.setTypeface(myTypeFace2);
        button1.setOnClickListener(this);

        button2 = (Button) findViewById(R.id.button2);
        button2.setTypeface(myTypeFace2);
        button2.setOnClickListener(this);

        button3 = (Button) findViewById(R.id.button3);
        button3.setTypeface(myTypeFace2);
        button3.setOnClickListener(this);

        button4 = (Button) findViewById(R.id.button4);
        button4.setTypeface(myTypeFace2);
        button4.setOnClickListener(this);

        button5 = (Button) findViewById(R.id.button5);
        button5.setTypeface(myTypeFace2);
        button5.setOnClickListener(this);

        button6 = (Button) findViewById(R.id.button6);
        button6.setTypeface(myTypeFace2);
        button6.setOnClickListener(this);

        button7 = (Button) findViewById(R.id.button7);
        button7.setTypeface(myTypeFace2);
        button7.setOnClickListener(this);

        button8 = (Button) findViewById(R.id.button8);
        button8.setTypeface(myTypeFace2);
        button8.setOnClickListener(this);

        btnReiniciar = (Button) findViewById(R.id.btnReiniciar);
        btnReiniciar.setOnClickListener(this);

        btnCuestionario = (Button) findViewById(R.id.btnCuestionario);
        btnCuestionario.setOnClickListener(this);

        btn_regresar = (Button) findViewById(R.id.btn_regresar);
        btn_regresar.setOnClickListener(this);

        opciones = new Button[]{
                button3,
                button2,
                button5,
                button7,
                button1,
                button8,
                button4,
                button6
        };


        imagenes = new Drawable[]{
                ResourcesCompat.getDrawable(getResources(), R.drawable.ahorcado0, null),
                ResourcesCompat.getDrawable(getResources(), R.drawable.ahorcado1, null),
                ResourcesCompat.getDrawable(getResources(), R.drawable.ahorcado2, null),
                ResourcesCompat.getDrawable(getResources(), R.drawable.ahorcado3, null),
                ResourcesCompat.getDrawable(getResources(), R.drawable.ahorcado4, null),
                ResourcesCompat.getDrawable(getResources(), R.drawable.ahorcado5, null),
                ResourcesCompat.getDrawable(getResources(), R.drawable.ahorcado6, null),
                ResourcesCompat.getDrawable(getResources(), R.drawable.ahorcado7, null)
        };

        iniciar();
    }

    @Override
    public void onClick(View v) {

        switch (v.getId()){

                case R.id.button3: case R.id.button7: //Pregunta 1 y 4
                    if(pointerPreguntas-1 == 0 || pointerPreguntas-1 == 3){
                        correcta(v);
                    }else{
                        avanzarAhorcado();
                    }
                    break;
                case R.id.button2://Pregunta 2
                    if(pointerPreguntas-1 == 1 ){
                        correcta(v);
                    }else{
                        avanzarAhorcado();
                    }
                    break;
                case R.id.button5://Pregunta 3
                    if(pointerPreguntas-1 == 2 ){
                        correcta(v);
                    }else{
                        avanzarAhorcado();
                    }
                    break;
                case R.id.button1: case R.id.button4: //Pregunta 5 y 7
                if(pointerPreguntas-1 == 4 || pointerPreguntas-1 == 6){
                    correcta(v);
                }else{
                    avanzarAhorcado();
                }
                    break;
                case R.id.button8://Pregunta 6
                    if(pointerPreguntas-1 == 5 ){
                        correcta(v);
                    }else{
                        avanzarAhorcado();
                    }
                    break;
                case R.id.button6://Pregunta 8
                    if(pointerPreguntas-1 == 7 ){
                        correcta(v);
                    }else{
                        avanzarAhorcado();
                    }
                    break;
                case R.id.btnReiniciar://Reinicio
                    iniciar();
                    break;
                case R.id.btnCuestionario://Ir a cuestionario
                    Intent intent = new Intent(this,CuestionarioAct2.class);
                    startActivity(intent);
                    break;
            case R.id.btn_regresar:
                finish();
                break;
        }

    }

    private void correcta(View v){

        Button boton = (Button)findViewById(v.getId());
        Toast toast = Toast.makeText(this, "¡Correcto!",Toast.LENGTH_SHORT);
        toast.show();
        correctas++;
        boton.setEnabled(false);
        boton.setVisibility(View.GONE);
        if(correctas < 8){
            sonidobien.start();
            mostrarPregunta();
        }
        else{
            ganar();
        }
    }

    private void ganar(){
        //Se muestra ahorcado ganando
        ahorcado.setBackground(ResourcesCompat.getDrawable(getResources(), R.drawable.ahorcadowin, null));
        //Se hace saber al usuario que ya ganó
        botonaplauso.start();
        AlertDialog alertDialog = new AlertDialog.Builder(Ahorcado.this).create();
        alertDialog.setTitle("¡Felicidades!");
        alertDialog.setMessage("Has ganado el juego, dirígete al cuestionario para reafirmar tus conocimientos");
        alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL, "✓✓",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                });
        alertDialog.show();
    }

    private void mostrarPregunta(){
        //Mostramos la pregunta que el pointer indica y lo aumentamos a la que se mostrará posteriormente.
        pregunta.setText(preguntas[pointerPreguntas++]);
    }

    private void avanzarAhorcado(){
        sonidoerror.start();
        // Se indica al usuario que se equivocó
        Toast toast = Toast.makeText(this, "¡Oops! Intenta con otra opicón.",Toast.LENGTH_SHORT);
        toast.show();
        // Se cambia la imagen del ahorcado
        ahorcado.setBackground(imagenes[pointerAhorcado++]);

        // Se verifica si el usuario ya perdió
        if(pointerAhorcado == 8){
            sonidoperdio.start();
            AlertDialog alertDialog = new AlertDialog.Builder(Ahorcado.this).create();
            alertDialog.setTitle("¡Sigue intentando!");
            alertDialog.setMessage("Se te agotaron los intentos\n Inténtalo de nuevo o dirígete al cuestionario para reafirmar tus conocimientos.");
            alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL, "✓✓",
                    new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {
                            bloquear();
                            dialog.dismiss();
                        }
                    });
            alertDialog.show();
        }
    }

    private void iniciar(){

        //Obtención de vistas
        pregunta = (TextView) findViewById(R.id.pregunta);
        ahorcado = (ImageView) findViewById(R.id.imagen);

        //Iniciar imagen de ahorcado
        ahorcado.setBackground(ResourcesCompat.getDrawable(getResources(), R.drawable.comenzar_ahorcado, null));

        //Llenar los botones con los textos de las respuestas
        for(int i=0; i<arregloRespuestas.length; i++){
            opciones[i].setText(arregloRespuestas[i]);
            opciones[i].setEnabled(true);
            opciones[i].setVisibility(View.VISIBLE);
        }

        //Inicializar todos los contadores
        pointerPreguntas = 0; //Indica la pregunta siguiente, es decir, para iniciar, la siguiente pregunta es la primera (posición 0).
        pointerAhorcado = 0; //Indica en qué etapa se encuentra el ahorcado, pierde en la etapa 8.
        correctas = 0; //Indica las respuestas correctas que el usuario lleva.

        mostrarPregunta();
    }


    private void bloquear(){
        for(int i=0; i<arregloRespuestas.length; i++){
            opciones[i].setEnabled(false);

        }
    }
}
