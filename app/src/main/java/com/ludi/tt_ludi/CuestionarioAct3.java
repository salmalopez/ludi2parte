package com.ludi.tt_ludi;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

/**
 * Created by Josh on 12/04/16.
 */
public class CuestionarioAct3 extends AppCompatActivity implements View.OnClickListener{


    TextView txtP1, txtP2, txtP3, txtP4, txtP5, txtP6, txtP7, txtP8, txtP9, txtP10;
    Button btnFin;
    RadioButton
            rb1_0, rb1_1, rb1_2,
            rb2_0, rb2_1, rb2_2,
            rb3_0, rb3_1, rb3_2,
            rb4_0, rb4_1,
            rb5_0, rb5_1, rb5_2,
            rb6_0, rb6_1, rb6_2,
            rb7_0, rb7_1,
            rb8_0, rb8_1, rb8_2,
            rb9_0, rb9_1, rb9_2,
            rb10_0, rb10_1;

    PreguntasCuestionario3[] preguntas = new PreguntasCuestionario3().getPreguntas();
    static int idpregunta = 0;
    static int respuesta = 0;
    int correctas = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.cuestionario3_layout);

        //Se llenan todas las preguntas:
        txtP1 = (TextView) findViewById(R.id.txtPregunta1);
        txtP1.setText(preguntas[0].pregunta);
        txtP2 = (TextView) findViewById(R.id.txtPregunta2);
        txtP2.setText(preguntas[1].pregunta);
        txtP3 = (TextView) findViewById(R.id.txtPregunta3);
        txtP3.setText(preguntas[2].pregunta);
        txtP4 = (TextView) findViewById(R.id.txtPregunta4);
        txtP4.setText(preguntas[3].pregunta);
        txtP5 = (TextView) findViewById(R.id.txtPregunta5);
        txtP5.setText(preguntas[4].pregunta);
        txtP6 = (TextView) findViewById(R.id.txtPregunta6);
        txtP6.setText(preguntas[5].pregunta);
        txtP7 = (TextView) findViewById(R.id.txtPregunta7);
        txtP7.setText(preguntas[6].pregunta);
        txtP8 = (TextView) findViewById(R.id.txtPregunta8);
        txtP8.setText(preguntas[7].pregunta);
        txtP9 = (TextView) findViewById(R.id.txtPregunta9);
        txtP9.setText(preguntas[8].pregunta);
        txtP10 = (TextView) findViewById(R.id.txtPregunta10);
        txtP10.setText(preguntas[9].pregunta);

        //Se llenan las opciones
        rb1_0 = ((RadioButton) findViewById(R.id.rb1_0));
        rb1_0.setText(preguntas[0].respuesta[0]);
        rb1_1 = ((RadioButton) findViewById(R.id.rb1_1));
        rb1_1.setText(preguntas[0].respuesta[1]);
        rb1_2 = ((RadioButton) findViewById(R.id.rb1_2));
        rb1_2.setText(preguntas[0].respuesta[2]);

        rb2_0 = ((RadioButton) findViewById(R.id.rb2_0));
        rb2_0.setText(preguntas[1].respuesta[0]);
        rb2_1 = ((RadioButton) findViewById(R.id.rb2_1));
        rb2_1.setText(preguntas[1].respuesta[1]);
        rb2_2 = ((RadioButton) findViewById(R.id.rb2_2));
        rb2_2.setText(preguntas[1].respuesta[2]);

        rb3_0 = ((RadioButton) findViewById(R.id.rb3_0));
        rb3_0.setText(preguntas[2].respuesta[0]);
        rb3_1 = ((RadioButton) findViewById(R.id.rb3_1));
        rb3_1.setText(preguntas[2].respuesta[1]);
        rb3_2 = ((RadioButton) findViewById(R.id.rb3_2));
        rb3_2.setText(preguntas[2].respuesta[2]);

        rb4_0 = ((RadioButton) findViewById(R.id.rb4_0));
        rb4_0.setText(preguntas[3].respuesta[0]);
        rb4_1 = ((RadioButton) findViewById(R.id.rb4_1));
        rb4_1.setText(preguntas[3].respuesta[1]);

        rb5_0 = ((RadioButton) findViewById(R.id.rb5_0));
        rb5_0.setText(preguntas[4].respuesta[0]);
        rb5_1 = ((RadioButton) findViewById(R.id.rb5_1));
        rb5_1.setText(preguntas[4].respuesta[1]);
        rb5_2 = ((RadioButton) findViewById(R.id.rb5_2));
        rb5_2.setText(preguntas[4].respuesta[2]);

        rb6_0 = ((RadioButton) findViewById(R.id.rb6_0));
        rb6_0.setText(preguntas[5].respuesta[0]);
        rb6_1 = ((RadioButton) findViewById(R.id.rb6_1));
        rb6_1.setText(preguntas[5].respuesta[1]);
        rb6_2 = ((RadioButton) findViewById(R.id.rb6_2));
        rb6_2.setText(preguntas[5].respuesta[2]);

        rb7_0 = ((RadioButton) findViewById(R.id.rb7_0));
        rb7_0.setText(preguntas[6].respuesta[0]);
        rb7_1 = ((RadioButton) findViewById(R.id.rb7_1));
        rb7_1.setText(preguntas[6].respuesta[1]);

        rb8_0 = ((RadioButton) findViewById(R.id.rb8_0));
        rb8_0.setText(preguntas[7].respuesta[0]);
        rb8_1 = ((RadioButton) findViewById(R.id.rb8_1));
        rb8_1.setText(preguntas[7].respuesta[1]);
        rb8_2 = ((RadioButton) findViewById(R.id.rb8_2));
        rb8_2.setText(preguntas[7].respuesta[2]);

        rb9_0 = ((RadioButton) findViewById(R.id.rb9_0));
        rb9_0.setText(preguntas[8].respuesta[0]);
        rb9_1 = ((RadioButton) findViewById(R.id.rb9_1));
        rb9_1.setText(preguntas[8].respuesta[1]);
        rb9_2 = ((RadioButton) findViewById(R.id.rb9_2));
        rb9_2.setText(preguntas[8].respuesta[2]);

        rb10_0 = ((RadioButton) findViewById(R.id.rb10_0));
        rb10_0.setText(preguntas[9].respuesta[0]);
        rb10_1 = ((RadioButton) findViewById(R.id.rb10_1));
        rb10_1.setText(preguntas[9].respuesta[1]);


        btnFin = (Button) findViewById(R.id.btnFin);
        btnFin.setOnClickListener(this);


    }

    @Override
    public void onClick(View v) {

        if(((RadioButton)((RadioGroup)findViewById(R.id.grpP1)).getChildAt(preguntas[0].correcta)).isChecked())
            correctas++;
        if(((RadioButton)((RadioGroup)findViewById(R.id.grpP2)).getChildAt(preguntas[1].correcta)).isChecked())
            correctas++;
        if(((RadioButton)((RadioGroup)findViewById(R.id.grpP3)).getChildAt(preguntas[2].correcta)).isChecked())
            correctas++;
        if(((RadioButton)((RadioGroup)findViewById(R.id.grpP4)).getChildAt(preguntas[3].correcta)).isChecked())
            correctas++;
        if(((RadioButton)((RadioGroup)findViewById(R.id.grpP5)).getChildAt(preguntas[4].correcta)).isChecked())
            correctas++;
        if(((RadioButton)((RadioGroup)findViewById(R.id.grpP6)).getChildAt(preguntas[5].correcta)).isChecked())
            correctas++;
        if(((RadioButton)((RadioGroup)findViewById(R.id.grpP7)).getChildAt(preguntas[6].correcta)).isChecked())
            correctas++;
        if(((RadioButton)((RadioGroup)findViewById(R.id.grpP8)).getChildAt(preguntas[7].correcta)).isChecked())
            correctas++;
        if(((RadioButton)((RadioGroup)findViewById(R.id.grpP9)).getChildAt(preguntas[8].correcta)).isChecked())
            correctas++;
        if(((RadioButton)((RadioGroup)findViewById(R.id.grpP10)).getChildAt(preguntas[9].correcta)).isChecked())
            correctas++;

        System.out.println("Las respuestas correctas fueron "+correctas);

    }
}
