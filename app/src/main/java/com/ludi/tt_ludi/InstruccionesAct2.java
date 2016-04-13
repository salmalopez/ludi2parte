package com.ludi.tt_ludi;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class InstruccionesAct2 extends AppCompatActivity implements View.OnClickListener{

    Button btn_ra, btn_comenzar,btn_regresar;
    TextView txtTittle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_instrucciones_act2);

        Typeface myTypeFace = Typeface.createFromAsset(getAssets(),"KGS.ttf");
        txtTittle = (TextView) findViewById(R.id.txtTittle);
        txtTittle.setTypeface(myTypeFace);

        Typeface myTypeFace2 = Typeface.createFromAsset(getAssets(),"dot.ttf");
        btn_ra = (Button) findViewById (R.id.btn_ra);
        btn_ra.setTypeface(myTypeFace2);
        btn_ra.setOnClickListener(this);

        btn_comenzar = (Button) findViewById (R.id.btn_comenzar);
        btn_comenzar.setTypeface(myTypeFace2);
        btn_comenzar.setOnClickListener(this);

        btn_regresar = (Button) findViewById (R.id.btn_regresar);
        btn_regresar.setTypeface(myTypeFace2);
        btn_regresar.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {

            case (R.id.btn_ra):
                Intent siguiente = new Intent(InstruccionesAct2.this, Libro.class);
                InstruccionesAct2.this.startActivity(siguiente);
                break;

            case (R.id.btn_comenzar):
                Intent intentAct2 = new Intent(InstruccionesAct2.this, Actividad2.class);
                startActivity(intentAct2);
                break;

            case (R.id.btn_regresar):
                finish();
                break;
        }
    }
}
