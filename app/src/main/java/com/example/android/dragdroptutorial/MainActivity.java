package com.example.android.dragdroptutorial;

import android.content.ClipData;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.DragEvent;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView text1,text2,text3,text4;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        text1 = (TextView) findViewById(R.id.text1);
        text2 = (TextView) findViewById(R.id.text2);
        text3 = (TextView) findViewById(R.id.text3);
        text4 = (TextView) findViewById(R.id.target);

        text1.setOnLongClickListener(longclickListener);
        text2.setOnLongClickListener(longclickListener);
        text3.setOnLongClickListener(longclickListener);

        text4.setOnDragListener(dragListener);
    }

    View.OnLongClickListener longclickListener = new View.OnLongClickListener(){
        @Override
        public boolean onLongClick(View v){
            ClipData data = ClipData.newPlainText("","");
            View.DragShadowBuilder myShadowBuilder = new View.DragShadowBuilder(v);
            v.startDrag(data,myShadowBuilder,v,0);
            return true;
        }
    };

     View.OnDragListener dragListener = new View.OnDragListener(){

         @Override
         public boolean onDrag(View v, DragEvent event) {

             int dragEvent = event.getAction();
             final View view = (View) event.getLocalState();
             switch(dragEvent){
                 case DragEvent.ACTION_DRAG_ENTERED:


                     if(view.getId() == R.id.text1) {
                         text4.setText("TextView1 Is Dragged");
                     }
                     else if(view.getId() == R.id.text2) {
                         text4.setText("TextView2 Is Dragged");
                     }
                     else if(view.getId() == R.id.text3) {
                         text4.setText("TextView3 Is Dragged");
                             }

                     break;
                 case DragEvent.ACTION_DRAG_EXITED:

                     if(view.getId() == R.id.text1) {
                         text4.setText("TextView1 is Exited");
                     }
                     else if(view.getId() == R.id.text2) {
                         text4.setText("TextView2 Is Exited");
                     }
                     else if(view.getId() == R.id.text3) {
                         text4.setText("TextView3 Is Exited");
                     }
                     break;
                 case DragEvent.ACTION_DROP:

                     if(view.getId() == R.id.text1) {
                         text4.setText("TextView1 is Droped");
                     }
                     else if(view.getId() == R.id.text2) {
                         text4.setText("TextView2 Is Droped");
                     }
                     else if(view.getId() == R.id.text3) {
                         text4.setText("TextView3 Is Droped");
                     }

                     view.animate()
                             .x(text4.getX())
                             .y(text4.getY())
                             .setDuration(700)
                             .start();
                     break;


             }
             return false;
         }
     };
}
