package com.ludi.tt_ludi;

import android.content.Intent;
import android.graphics.Typeface;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class InstruccionesAct1 extends AppCompatActivity implements View.OnClickListener{

    Button btn_ra,btn_comenzar,btn_regresar;
    TextView txtIntruciones,txtTitle,textCuadernillo;
    MediaPlayer botonsonido,botonsalida;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_instrucciones_act1);
        //LETRAS TEXTVIE
        Typeface myTypeFace = Typeface.createFromAsset(getAssets(),"KGS.ttf");
        txtTitle = (TextView) findViewById(R.id.txtTitle);
        txtTitle.setTypeface(myTypeFace);

        botonsonido = MediaPlayer.create(InstruccionesAct1.this, R.raw.regreso);
        botonsalida = MediaPlayer.create(InstruccionesAct1.this, R.raw.inicio);

        Typeface myTypeFace2 = Typeface.createFromAsset(getAssets(),"BU.ttf");
        textCuadernillo = (TextView) findViewById(R.id.textCuadernillo);
        textCuadernillo.setTypeface(myTypeFace2);

        Typeface myTypeFace3 = Typeface.createFromAsset(getAssets(),"DK.ttf");
        txtIntruciones = (TextView) findViewById(R.id.txtIntruciones);
        txtIntruciones.setTypeface(myTypeFace3);
        //FIN LETRAS

        btn_ra = (Button) findViewById (R.id.btn_ra);
        btn_ra.setOnClickListener(this);

        btn_comenzar = (Button) findViewById (R.id.btn_comenzar);
        btn_comenzar.setOnClickListener(this);

        btn_regresar = (Button) findViewById (R.id.btn_regresar);
        btn_regresar.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {

            case (R.id.btn_ra):
                botonsonido.start();
                Intent siguiente = new Intent(InstruccionesAct1.this, Libro.class);
                InstruccionesAct1.this.startActivity(siguiente);
                break;

            case (R.id.btn_comenzar):
                botonsonido.start();
                Intent intentAct2 = new Intent(InstruccionesAct1.this, Actividad1.class);
                startActivity(intentAct2);
                break;

            case (R.id.btn_regresar):
                botonsalida.start();
                finish();
                break;
        }
    }
}
