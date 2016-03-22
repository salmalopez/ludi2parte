package actividad3;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.DragEvent;
import android.view.MotionEvent;
import android.view.View;
import android.widget.TextView;

import com.ludi.tt_ludi.R;

/**
 * Created by Salma on 17/03/16.
 */
public class Actividad3 extends AppCompatActivity implements View.OnTouchListener,View.OnDragListener {

    private TextView text1,text2,text3,text4,text5,text6,text7,text8;

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

            if(text.equals("FRUTA")){
                if(dropped.equals(text.equals(text4.getText().toString())) || dropped.equals(text.equals(text5.getText().toString()))
                        || dropped.equals(text.equals(text6.getText().toString()))){
                    dropTarget.setText(dropped.getText());
                }else{
                    if(dropped.getText().toString().equals(text1.getText())){
                        text1.setVisibility(View.VISIBLE);
                    }else if (dropped.getText().toString().equals(text2.getText())){
                        text2.setVisibility(View.VISIBLE);
                    }else if (dropped.getText().toString().equals(text3.getText())){
                        text3.setVisibility(View.VISIBLE);
                        System.out.println("no va aqui");
                    }
                }
            }else{
                if(dropped.equals(text.equals(text1.getText().toString())) || dropped.equals(text.equals(text2.getText().toString()))
                        || dropped.equals(text.equals(text3.getText().toString()))){
                    dropTarget.setText(dropped.getText());
                }else{
                    if(dropped.getText().toString().equals(text4.getText())){
                        text4.setVisibility(View.VISIBLE);
                    }else if (dropped.getText().toString().equals(text5.getText())){
                        text5.setVisibility(View.VISIBLE);
                    }else if (dropped.getText().toString().equals(text6.getText())){
                        text6.setVisibility(View.VISIBLE);
                        System.out.println("no va aqui");
                    }
                }

            }


/*
             if(text.equals(text1.getText().toString()))
            {
                System.out.println(text);
                text1.setVisibility(View.VISIBLE);
            }
            else if(text.equals(text2.getText().toString()))
                text2.setVisibility(View.VISIBLE);
            else if(text.equals(text3.getText().toString()))
                text3.setVisibility(View.VISIBLE);
            else if(text.equals(text7.getText().toString()))
                text7.setVisibility(View.VISIBLE);
            else if(text.equals(text8.getText().toString()))
                text8.setVisibility(View.VISIBLE);
            else if(text.equals(text9.getText().toString()))
                text9.setVisibility(View.VISIBLE);

            //update the text and color in the target view to reflect the data being dropped
            dropTarget.setText(dropped.getText());
            dropTarget.setBackgroundColor(Color.BLUE); */
        }
        return true;
    }

    public void reinicio(View v){
        text1.setVisibility(View.VISIBLE);
        text2.setVisibility(View.VISIBLE);
        text3.setVisibility(View.VISIBLE);
        text4.setVisibility(View.VISIBLE);
        text5.setVisibility(View.VISIBLE);
        text6.setVisibility(View.VISIBLE);
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

        text1 = (TextView)findViewById(R.id.text1);
        text2 = (TextView)findViewById(R.id.text2);
        text3 = (TextView)findViewById(R.id.text3);
        text4 = (TextView)findViewById(R.id.text4);
        text5 = (TextView)findViewById(R.id.text5);
        text6 = (TextView)findViewById(R.id.text6);
        text7 = (TextView)findViewById(R.id.text7);
        text8 = (TextView)findViewById(R.id.text8);

        //Setting touch and drag listeners
        text1.setOnTouchListener(this);
        text2.setOnTouchListener(this);
        text3.setOnTouchListener(this);
        text4.setOnTouchListener(this);
        text5.setOnTouchListener(this);
        text6.setOnTouchListener(this);
        text7.setOnDragListener(this);
        text8.setOnDragListener(this);
    }
}

