package com.ludi.tt_ludi;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class Noticias extends AppCompatActivity {
    TextView txt_noticias;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_noticias);

        txt_noticias = (TextView) findViewById(R.id.txt_noticias);

    }
}
