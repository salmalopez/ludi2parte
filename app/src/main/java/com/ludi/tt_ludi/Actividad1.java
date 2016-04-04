package com.ludi.tt_ludi;

import android.app.Activity;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by Salma on 15/03/16.
 */
public class Actividad1 extends Activity implements Animation.AnimationListener, View.OnClickListener{

    TextView txtPregunta;
    Button btnRespuesta1,btnRespuesta2, btnSiguiente;
    Pregunta[] preguntas = new Pregunta().getPreguntas();
    static int idpregunta = 0;
    static int respuesta = 0;

    ImageButton btn;

    // Animation
    Animation animFadein;

    private static final int[] PREGUNTA_RESOURCES = new int[]{
            R.drawable.brocoli,
            R.drawable.uva,
            R.drawable.berenjena,
            R.drawable.cebolla,
            R.drawable.fresa,
            R.drawable.jitomate,
            R.drawable.manzana,
            R.drawable.naranja,
            R.drawable.platano,
            R.drawable.zanahoria,
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // TODO Auto-generated method stub

        super.onCreate(savedInstanceState);
        setContentView(R.layout.actividad1_layout);

        txtPregunta = (TextView) findViewById(R.id.txtPregunta);
        txtPregunta.setText(preguntas[idpregunta].pregunta);


        btnRespuesta1 = (Button) findViewById(R.id.btnRespuesta1);
        btnRespuesta1.setText(preguntas[idpregunta].respuesta[0]);
        Drawable image = (Drawable)getResources().getDrawable(PREGUNTA_RESOURCES[respuesta]);
        btnRespuesta1.setBackground(image);


        btnRespuesta2 = (Button) findViewById(R.id.btnRespuesta2);
        btnRespuesta2.setText(preguntas[idpregunta].respuesta[1]);
        Drawable image2 =(Drawable)getResources().getDrawable(PREGUNTA_RESOURCES[respuesta+1]);
        btnRespuesta2.setBackground(image2);

        btnSiguiente = (Button) findViewById(R.id.btnSiguiente);

        // load the animation
        animFadein = AnimationUtils.loadAnimation(getApplicationContext(),
                R.anim.fade_in);
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
                if(idpregunta<8 && preguntas[idpregunta].correcta == 0 ) {
                    idpregunta++;
                    respuesta++;
                    System.out.println(idpregunta + "_ " + Pregunta.contador);
                    txtPregunta.setText(preguntas[idpregunta].pregunta);
                    btnRespuesta1.setText(preguntas[idpregunta].respuesta[0]);
                    btnRespuesta2.setText(preguntas[idpregunta].respuesta[1]);

                    Drawable image=(Drawable)getResources().getDrawable(PREGUNTA_RESOURCES[respuesta]);
                    btnRespuesta1.setBackground(image);
                    Drawable image2=(Drawable)getResources().getDrawable(PREGUNTA_RESOURCES[respuesta+1]);
                    btnRespuesta2.setBackground(image2);

                    txtPregunta.setVisibility(View.VISIBLE);
                    txtPregunta.startAnimation(animFadein);

                    if(idpregunta==8){
                        btnSiguiente.setVisibility(View.VISIBLE);
                    }
                }
                break;

            case (R.id.btnRespuesta2):
                if(idpregunta<8 && preguntas[idpregunta].correcta == 1) {
                    idpregunta++;
                    respuesta++;
                    System.out.println(idpregunta + "_ " + Pregunta.contador);
                    txtPregunta.setText(preguntas[idpregunta].pregunta);
                    btnRespuesta1.setText(preguntas[idpregunta].respuesta[0]);
                    btnRespuesta2.setText(preguntas[idpregunta].respuesta[1]);
                    txtPregunta.setVisibility(View.VISIBLE);
                    txtPregunta.startAnimation(animFadein);

                    Drawable image=(Drawable)getResources().getDrawable(PREGUNTA_RESOURCES[respuesta]);
                    btnRespuesta1.setBackground(image);
                    Drawable image2=(Drawable)getResources().getDrawable(PREGUNTA_RESOURCES[respuesta+1]);
                    btnRespuesta2.setBackground(image2);


                    if(idpregunta==8){
                        btnSiguiente.setVisibility(View.VISIBLE);
                    }

                }
                break;


            case (R.id.btnSiguiente):
                    idpregunta=0;
                    respuesta=0;
                    System.out.println(idpregunta + "_ " + Pregunta.contador);
                    txtPregunta.setText(preguntas[idpregunta].pregunta);
                    btnRespuesta1.setText(preguntas[idpregunta].respuesta[0]);
                    btnRespuesta2.setText(preguntas[idpregunta].respuesta[1]);
                    txtPregunta.setVisibility(View.VISIBLE);
                    txtPregunta.startAnimation(animFadein);

                    Drawable image=(Drawable)getResources().getDrawable(PREGUNTA_RESOURCES[respuesta]);
                    btnRespuesta1.setBackground(image);
                    Drawable image2=(Drawable)getResources().getDrawable(PREGUNTA_RESOURCES[respuesta+1]);
                    btnRespuesta2.setBackground(image2);
                    break;

            case (R.id.btnCuestionario):
                Intent i = new Intent(this, CuestionarioAct1.class);
                startActivity(i);
                break;
        }

    }

    @Override
    public void onAnimationEnd(Animation animation) {
        // Take any action after completing the animation

        // check for fade in animation
        if (animation == animFadein) {
            Toast.makeText(getApplicationContext(), "Animation Stopped",
                    Toast.LENGTH_SHORT).show();
        }

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
