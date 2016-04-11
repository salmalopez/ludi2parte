package com.ludi.tt_ludi;

import android.app.Activity;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by Salma on 15/03/16.
 */
public class Actividad1 extends Activity implements Animation.AnimationListener, View.OnClickListener{

    TextView txtPregunta;
    Button btnRespuesta1,btnRespuesta2, btnSiguiente, btn_regresar, btnCuestionario;
    Pregunta[] preguntas = new Pregunta().getPreguntas();
    static int idpregunta = 0, nivel =0;
    static int respuesta = 0;

    ImageView imagenJarra;

    // Animation
    Animation animFadein;
    Animation error;

    private static final int[] PREGUNTA_RESOURCES = new int[]{
            R.drawable.jarra6,
            R.drawable.jarra3,
            R.drawable.vasos3,
            R.drawable.ocho,
            R.drawable.dos,
            R.drawable.cuatro,
            R.drawable.agua,
            R.drawable.cafe,
            R.drawable.refresco,
            R.drawable.cafe,
            R.drawable.agua,
            R.drawable.jugo,
            R.drawable.vasos3,
            R.drawable.refnaranja,

    };


    private static final int[] NIVELES_JARRA = new int[]{
            R.drawable.jarra,
            R.drawable.jarra1,
            R.drawable.jarra2,
            R.drawable.jarra3,
            R.drawable.jarra4,
            R.drawable.jarra5,
            R.drawable.jarra6

    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // TODO Auto-generated method stub

        super.onCreate(savedInstanceState);
        setContentView(R.layout.actividad1_layout);

        imagenJarra = (ImageView) findViewById(R.id.imagenJarra);
        imagenJarra.setImageResource(NIVELES_JARRA[nivel]);


        txtPregunta = (TextView) findViewById(R.id.txtPregunta);
        txtPregunta.setText(preguntas[idpregunta].pregunta);

        btn_regresar = (Button) findViewById(R.id.btn_regresar);
        btn_regresar.setOnClickListener(this);

        btnCuestionario = (Button) findViewById(R.id.btnCuestionario);
        btnCuestionario.setOnClickListener(this);

        btnRespuesta1 = (Button) findViewById(R.id.btnRespuesta1);
        btnRespuesta1.setText(preguntas[idpregunta].respuesta[0]);
        Drawable image = (Drawable)getResources().getDrawable(PREGUNTA_RESOURCES[respuesta]);
        btnRespuesta1.setBackground(image);


        btnRespuesta2 = (Button) findViewById(R.id.btnRespuesta2);
        btnRespuesta2.setText(preguntas[idpregunta].respuesta[1]);
        Drawable image2 =(Drawable)getResources().getDrawable(PREGUNTA_RESOURCES[++respuesta]);
        btnRespuesta2.setBackground(image2);

        btnSiguiente = (Button) findViewById(R.id.btnSiguiente);

        // load the animation
        animFadein = AnimationUtils.loadAnimation(getApplicationContext(),
                R.anim.fade_in);

        error = AnimationUtils.loadAnimation(getApplicationContext(),
                R.anim.error);
        // set animation listener
        animFadein.setAnimationListener(this);

        // button click event
        btnRespuesta1.setOnClickListener(this);
        btnRespuesta2.setOnClickListener(this);
        btnSiguiente.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

        switch (v.getId()){
            case (R.id.btnRespuesta1):
                if(idpregunta<6 && preguntas[idpregunta].correcta == 0 ) {
                    idpregunta++;
                    respuesta++;
                    nivel++;

                    imagenJarra.setImageResource(NIVELES_JARRA[nivel]);

                    System.out.println(idpregunta + "_ " + Pregunta.contador);
                    txtPregunta.setText(preguntas[idpregunta].pregunta);
                    btnRespuesta1.setText(preguntas[idpregunta].respuesta[0]);
                    btnRespuesta2.setText(preguntas[idpregunta].respuesta[1]);

                    Drawable image=(Drawable)getResources().getDrawable(PREGUNTA_RESOURCES[respuesta]);
                    btnRespuesta1.setBackground(image);
                    Drawable image2=(Drawable)getResources().getDrawable(PREGUNTA_RESOURCES[++respuesta]);
                    btnRespuesta2.setBackground(image2);

                    txtPregunta.setVisibility(View.VISIBLE);
                    txtPregunta.startAnimation(animFadein);


                    if(idpregunta==6){
                        Toast toast2 = Toast.makeText(getApplicationContext(),
                                "Concluiste la actividad", Toast.LENGTH_LONG);
                        toast2.show();
                    }
                }else{
                    //btnRespuesta1.startAnimation(error);

                }

                break;

            case (R.id.btnRespuesta2):
                if(idpregunta<6 && preguntas[idpregunta].correcta == 1) {
                    idpregunta++;
                    respuesta++;
                    nivel++;
                    imagenJarra.setImageResource(NIVELES_JARRA[nivel]);
                    System.out.println(idpregunta + "_ " + Pregunta.contador);
                    txtPregunta.setText(preguntas[idpregunta].pregunta);
                    btnRespuesta1.setText(preguntas[idpregunta].respuesta[0]);
                    btnRespuesta2.setText(preguntas[idpregunta].respuesta[1]);
                    txtPregunta.setVisibility(View.VISIBLE);
                    txtPregunta.startAnimation(animFadein);

                    Drawable image=(Drawable)getResources().getDrawable(PREGUNTA_RESOURCES[respuesta]);
                    btnRespuesta1.setBackground(image);
                    Drawable image2=(Drawable)getResources().getDrawable(PREGUNTA_RESOURCES[++respuesta]);
                    btnRespuesta2.setBackground(image2);

                    if(idpregunta==6){
                        Toast toast2 = Toast.makeText(getApplicationContext(),
                                "Concluiste la actividad", Toast.LENGTH_LONG);
                        toast2.show();
                    }else {
                       // btnRespuesta2.startAnimation(error);

                    }
                }
                break;


            case (R.id.btnSiguiente):
                    idpregunta=0;
                    respuesta=0;
                    nivel=0;

                imagenJarra = (ImageView) findViewById(R.id.imagenJarra);
                imagenJarra.setImageResource(NIVELES_JARRA[nivel]);

                System.out.println(idpregunta + "_ " + Pregunta.contador);
                    txtPregunta.setText(preguntas[idpregunta].pregunta);
                    btnRespuesta1.setText(preguntas[idpregunta].respuesta[0]);
                    btnRespuesta2.setText(preguntas[idpregunta].respuesta[1]);
                    txtPregunta.setVisibility(View.VISIBLE);
                    txtPregunta.startAnimation(animFadein);

                    Drawable image=(Drawable)getResources().getDrawable(PREGUNTA_RESOURCES[respuesta]);
                    btnRespuesta1.setBackground(image);
                    Drawable image2=(Drawable)getResources().getDrawable(PREGUNTA_RESOURCES[++respuesta]);
                    btnRespuesta2.setBackground(image2);
                    break;

            case (R.id.btnCuestionario):
                Intent i = new Intent(this, CuestionarioAct1.class);
                startActivity(i);
                break;

            case (R.id.btn_regresar):
                finish();
                break;
        }

    }

    @Override
    public void onAnimationEnd(Animation animation) {
        // Take any action after completing the animation

        // check for fade in animation
       /* if (animation == animFadein) {
            Toast.makeText(getApplicationContext(), "Animation Stopped",
                    Toast.LENGTH_SHORT).show();
        } */

    }

    @Override
    public void onAnimationRepeat(Animation animation) {
        // TODO Auto-generated method stub

    }

    @Override
    public void onAnimationStart(Animation animation) {
        // TODO Auto-generated method stub

    }

}
