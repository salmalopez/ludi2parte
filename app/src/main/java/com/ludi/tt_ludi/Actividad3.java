package com.ludi.tt_ludi;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.DragEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.TextView;

/**
 * Created by Salma on 17/03/16.
 */
public class Actividad3 extends AppCompatActivity implements View.OnTouchListener,View.OnDragListener, View.OnClickListener {

    private TextView textG1,textG1_1,textG1_2,textG1_3,textG1_4,textG2,textG2_1,textG2_2,textG3,textG3_1,textG3_2,textG3_3, textGrupo1,textGrupo2,textGrupo3;


    Button btn_regresar,btnCuestionario,btn_reinicio;

    Animation error,bounce;

    //When touched text gets dropped into either text4 or text5 or text6 then this method will be called
    @Override
    public boolean onDrag(View v, DragEvent event) {
        if (event.getAction()==DragEvent.ACTION_DROP)
        {
            //handle the dragged view being dropped over a target view
            TextView dropped = (TextView)event.getLocalState();
            TextView dropTarget = (TextView) v;
            System.out.println(dropped);
            System.out.println(dropTarget);
            //stop displaying the view where it was before it was dragged
            dropped.setVisibility(View.INVISIBLE);

            //if an item has already been dropped here, there will be different string
            String text = dropTarget.getText().toString();
            //if there is already an item here, set it back visible in its original place

            if(text.equals("G2")){
                if(dropped.equals(text.equals(textG2.getText().toString()))
                        || dropped.equals(text.equals(textG2_1.getText().toString()))
                        || dropped.equals(text.equals(textG2_2.getText().toString()))){
                    dropTarget.setText(dropped.getText());
                }else{
                    if(dropped.getText().toString().equals(textG1.getText())){
                        textG1.setVisibility(View.VISIBLE);
                        textG1.startAnimation(error);
                    }else if (dropped.getText().toString().equals(textG1_1.getText())){
                        textG1_1.setVisibility(View.VISIBLE);
                        textG1_1.startAnimation(error);
                    }else if (dropped.getText().toString().equals(textG1_2.getText())){
                        textG1_2.setVisibility(View.VISIBLE);
                        textG1_2.startAnimation(error);
                    }else if (dropped.getText().toString().equals(textG1_3.getText())){
                        textG1_3.setVisibility(View.VISIBLE);
                        textG1_3.startAnimation(error);
                    }else if (dropped.getText().toString().equals(textG1_4.getText())){
                        textG1_4.setVisibility(View.VISIBLE);
                        textG1_4.startAnimation(error);
                    }else if (dropped.getText().toString().equals(textG3.getText())){
                        textG3.setVisibility(View.VISIBLE);
                        textG3.startAnimation(error);
                    }else if (dropped.getText().toString().equals(textG3_1.getText())){
                        textG3_1.setVisibility(View.VISIBLE);
                        textG3_1.startAnimation(error);
                    }else if (dropped.getText().toString().equals(textG3_2.getText())){
                        textG3_2.setVisibility(View.VISIBLE);
                        textG3_2.startAnimation(error);
                    }else if (dropped.getText().toString().equals(textG3_3.getText())){
                        textG3_3.setVisibility(View.VISIBLE);
                        textG3_3.startAnimation(error);
                    }
                }
            }else if(text.equals("GUNO")){
                if(dropped.equals(text.equals(textG1.getText().toString()))
                        || dropped.equals(text.equals(textG1_1.getText().toString()))
                        || dropped.equals(text.equals(textG1_2.getText().toString()))
                        || dropped.equals(text.equals(textG1_3.getText().toString()))
                        || dropped.equals(text.equals(textG1_4.getText().toString()))){
                }else{
                    if(dropped.getText().toString().equals(textG2.getText())){
                        textG2.setVisibility(View.VISIBLE);
                        textG2.startAnimation(error);
                    }else if (dropped.getText().toString().equals(textG2_1.getText())){
                        textG2_1.setVisibility(View.VISIBLE);
                        textG2_1.startAnimation(error);
                    }else if (dropped.getText().toString().equals(textG2_2.getText())){
                        textG2_2.setVisibility(View.VISIBLE);
                        textG2_2.startAnimation(error);
                    }else if (dropped.getText().toString().equals(textG3.getText())){
                        textG3.setVisibility(View.VISIBLE);
                        textG3.startAnimation(error);
                    }else if (dropped.getText().toString().equals(textG3_1.getText())){
                        textG3_1.setVisibility(View.VISIBLE);
                        textG3_1.startAnimation(error);
                    }else if (dropped.getText().toString().equals(textG3_2.getText())){
                        textG3_2.setVisibility(View.VISIBLE);
                        textG3_2.startAnimation(error);
                    }else if (dropped.getText().toString().equals(textG3_3.getText())){
                        textG3_3.setVisibility(View.VISIBLE);
                        textG3_3.startAnimation(error);
                    }
                }

            }else{
                if(dropped.equals(text.equals(textG3.getText().toString()))
                        || dropped.equals(text.equals(textG3_1.getText().toString()))
                        || dropped.equals(text.equals(textG3_2.getText().toString()))
                        || dropped.equals(text.equals(textG3_3.getText().toString()))){
                }else{
                    if(dropped.getText().toString().equals(textG1.getText())){
                        textG1.setVisibility(View.VISIBLE);
                        textG1.startAnimation(error);
                    }else if (dropped.getText().toString().equals(textG1_1.getText())){
                        textG1_1.setVisibility(View.VISIBLE);
                        textG1_1.startAnimation(error);
                    }else if (dropped.getText().toString().equals(textG1_2.getText())){
                        textG1_2.setVisibility(View.VISIBLE);
                        textG1_2.startAnimation(error);
                    }else if (dropped.getText().toString().equals(textG1_3.getText())){
                        textG1_3.setVisibility(View.VISIBLE);
                        textG1_3.startAnimation(error);
                    }else if (dropped.getText().toString().equals(textG1_4.getText())){
                        textG1_4.setVisibility(View.VISIBLE);
                        textG1_4.startAnimation(error);
                    }else if (dropped.getText().toString().equals(textG2.getText())){
                        textG2.setVisibility(View.VISIBLE);
                        textG2.startAnimation(error);
                    }else if (dropped.getText().toString().equals(textG2_1.getText())){
                        textG2_1.setVisibility(View.VISIBLE);
                        textG2_1.startAnimation(error);
                    }else if (dropped.getText().toString().equals(textG2_2.getText())){
                        textG2_2.setVisibility(View.VISIBLE);
                        textG2_2.startAnimation(error);
                    }
                }

            }
        }
        return true;
    }



    //When text1 or text2 or text3 gets clicked or touched then this method will be called
    @Override
    public boolean onTouch(View v, MotionEvent event) {
        if (event.getAction()==MotionEvent.ACTION_DOWN)
        {
            View.DragShadowBuilder shadowBuilder = new View.DragShadowBuilder(v);
            v.startDrag(null, shadowBuilder, v, 0);
            return true;
        }
        else return false;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.actividad3_layout);

        error = AnimationUtils.loadAnimation(getApplicationContext(),
                R.anim.error);

        bounce = AnimationUtils.loadAnimation(getApplicationContext(),
                R.anim.bounce);

        btn_regresar = (Button)findViewById(R.id.btn_regresar);
        btn_regresar.setOnClickListener(this);

        btn_reinicio  = (Button)findViewById(R.id.btn_reinicio);
        btn_reinicio.setOnClickListener(this);

        btnCuestionario = (Button) findViewById(R.id.btnCuestionario);
        btnCuestionario.setOnClickListener(this);

        textG1 = (TextView)findViewById(R.id.textG1);
        textG1_1 = (TextView)findViewById(R.id.textG1_1);
        textG1_2 = (TextView)findViewById(R.id.textG1_2);
        textG1_3 = (TextView)findViewById(R.id.textG1_3);
        textG1_4 = (TextView)findViewById(R.id.textG1_4);
        textG2 = (TextView)findViewById(R.id.textG2);
        textG2_1 = (TextView)findViewById(R.id.textG2_1);
        textG2_2 = (TextView)findViewById(R.id.textG2_2);
        textG3 = (TextView)findViewById(R.id.textG3);
        textG3_1 = (TextView)findViewById(R.id.textG3_1);
        textG3_2 = (TextView)findViewById(R.id.textG3_2);
        textG3_3 = (TextView)findViewById(R.id.textG3_3);

        textGrupo1 = (TextView)findViewById(R.id.textGrupo1);
        textGrupo2 = (TextView)findViewById(R.id.textGrupo2);
        textGrupo3 = (TextView)findViewById(R.id.textGrupo3);

        //Setting touch and drag listeners
        textG1.setOnTouchListener(this);
        textG1_1.setOnTouchListener(this);
        textG1_2.setOnTouchListener(this);
        textG1_3.setOnTouchListener(this);
        textG1_4.setOnTouchListener(this);
        textG2.setOnTouchListener(this);
        textG2_1.setOnTouchListener(this);
        textG2_2.setOnTouchListener(this);
        textG3.setOnTouchListener(this);
        textG3_1.setOnTouchListener(this);
        textG3_2.setOnTouchListener(this);
        textG3_3.setOnTouchListener(this);

        textGrupo1.setOnDragListener(this);
        textGrupo2.setOnDragListener(this);
        textGrupo3.setOnDragListener(this);
    }

    @Override
    public void onClick(View v) {

        switch (v.getId()){
            case (R.id.btnCuestionario):
                Intent i = new Intent(this, CuestionarioAct4.class);
                startActivity(i);
                break;

            case (R.id.btn_regresar):
                finish();
                break;

            case (R.id.btn_reinicio):
                finish();
                Intent i2 = new Intent(this, Actividad3.class);
                startActivity(i2);
                break;
        }


    }
}

