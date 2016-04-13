package com.ludi.tt_ludi;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TableLayout;
import android.widget.TableRow;

import java.util.Arrays;
import java.util.Collections;

/**
 * Created by Salma on 15/03/16.
 */
public class Actividad2 extends AppCompatActivity implements View.OnClickListener{

    private static final int[] CARTA_RESOURCES = new int[]{
            R.drawable.carne,
            R.drawable.cerdito,
            R.drawable.gallina,
            R.drawable.huevo,
            R.drawable.queso,
            R.drawable.vaquita,
            R.drawable.pez,
            R.drawable.leche

    };



    private Handler handler = new Handler();
    private  Carta[] cartas;
    private boolean touchActivo = true;
    private Carta visible = null;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.actividad2_layout);
        final TableLayout tabla = new TableLayout(this);

        tabla.setBackgroundColor(Color.parseColor("#C2185B"));

        Button btnEspacio = new Button(this);
        Drawable image = (Drawable)getResources().getDrawable(R.drawable.espaciomem);
        btnEspacio.setBackground(image);

        Button btnSiguiente = new Button(this);
        Drawable image4 = (Drawable)getResources().getDrawable(R.drawable.cuestionariomem);
        btnSiguiente.setBackground(image4);
        btnSiguiente.setOnClickListener(this);

        Button btnReinicio = new Button(this);
        Drawable image2 = (Drawable)getResources().getDrawable(R.drawable.reiniciomem);
        btnReinicio.setBackground(image2);
        btnReinicio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
                Intent intentAct2 = new Intent(Actividad2.this, Actividad2.class);
                startActivity(intentAct2);
            }

        });

        Button btnRegreso = new Button(this);
        Drawable image3 = (Drawable)getResources().getDrawable(R.drawable.regresomem);
        btnRegreso.setBackground(image3);
        btnRegreso.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }

        });

        final TableRow fila2 = new TableRow(this);
        fila2.addView(btnRegreso);
        fila2.addView(btnEspacio);
        fila2.addView(btnSiguiente);
        fila2.addView(btnReinicio);


        final int tam =  4;
        cartas = crearCeldas(tam*tam);
        Collections.shuffle(Arrays.asList(cartas));
        for(int y=0; y < tam; y++){
            final TableRow fila = new TableRow(this);
            for(int x=0; x<tam; x++){
                fila.addView(cartas[(y * tam) + x].boton);
                fila.setBackgroundColor(Color.parseColor("#C2185B"));
            }

            tabla.addView(fila);
        }
        tabla.addView(fila2);
        setContentView(tabla);


    }

    @Override
    public void onClick(View v) {
        Intent intent = new Intent(this,CuestionarioAct2.class);
        startActivity(intent);
    }

    private class Carta implements View.OnClickListener {


        private final ImageButton boton;
        private final int imagen;
        private  boolean caraVisible = false;


        Carta(final int imagen){
            this.imagen = imagen;
            this.boton = new ImageButton(Actividad2.this);
            this.boton.setLayoutParams(new TableRow.LayoutParams(180, 140));

            this.boton.setScaleType(ImageView.ScaleType.FIT_XY);
            this.boton.setImageResource(R.drawable.pregunta);
            this.boton.setBackgroundColor(Color.parseColor("#C2185B"));
            this.boton.setOnClickListener(this);
        }

        void setCaraVisible(final boolean caraVisible){
            this.caraVisible = caraVisible;
            boton.setImageResource(caraVisible ? imagen : R.drawable.pregunta);

        }

        @Override
        public void onClick(View v) {
            if(!caraVisible&&touchActivo){
                onCartaDescubierta(this);
            }

        }

    }

    private Carta[] crearCeldas(final int cont){
        final Carta[] array = new Carta[cont];
        for (int i=0; i<array.length; i++){
            array[i] = new Carta(CARTA_RESOURCES[i/2]);

        }
        return array;
    }

    private void onCartaDescubierta(final Carta celda) {
        if(visible==null){
            visible = celda;
            visible.setCaraVisible(true);
        }else if (visible.imagen == celda.imagen) {
            celda.setCaraVisible(true);
            celda.boton.setEnabled(false);
            visible.boton.setEnabled(false);
            visible = null;
        }
        else{
            celda.setCaraVisible(true);
            touchActivo = false;
            handler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    celda.setCaraVisible(false);
                    visible.setCaraVisible(false);
                    visible = null;
                    touchActivo = true;
                }
            }, 1000);
        }

    }


}
