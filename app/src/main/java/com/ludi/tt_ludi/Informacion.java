package com.ludi.tt_ludi;

import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Informacion extends AppCompatActivity implements View.OnClickListener {

    TextView txtTittle,textInfo;
    Button buttonRegreso;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_informacion);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        Typeface myTypeFace = Typeface.createFromAsset(getAssets(),"KGS.ttf");
        txtTittle = (TextView) findViewById(R.id.txtTittle);
        txtTittle.setTypeface(myTypeFace);

        Typeface myTypeFace2 = Typeface.createFromAsset(getAssets(),"DK.ttf");
        textInfo = (TextView) findViewById(R.id.textInfo);
        textInfo.setTypeface(myTypeFace2);

        buttonRegreso = (Button) findViewById(R.id.buttonRegreso);
        buttonRegreso.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        finish();
    }

    @Override
    public void onBackPressed(){

    }
}
