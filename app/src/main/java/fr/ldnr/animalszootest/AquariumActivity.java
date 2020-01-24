package fr.ldnr.animalszootest;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.RectF;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Toast;

import androidx.annotation.Nullable;

public class AquariumActivity extends Activity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(new MapView(this));
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        if(event.getActionMasked()== MotionEvent.ACTION_DOWN){
            Intent i = new Intent(this, PopCornActivity.class);
//            i.putExtra("message",getString(R.string.warning_eat) );

            startActivityForResult(i,0);
//            Xplace = (int) event.getX();
//            Yplace = (int) event.getY();
            Log.e ("x = ", String.valueOf(event.getX()));
            Log.e ("y = ", String.valueOf(event.getY()));


        }

        return true;
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
//        super.onActivityResult(requestCode, resultCode, data);
        Toast.makeText(this,data.getStringExtra("info"),Toast.LENGTH_SHORT).show();

    }

    public class MapView extends View{

            public MapView(Context context) {
                super(context);
            }



        @Override
        protected void onDraw(Canvas canvas) {
            super.onDraw(canvas);
             int n = (int)(Math.random() * 4);


            int width = this.getResources().getDisplayMetrics().widthPixels;
            int height = this.getResources().getDisplayMetrics().heightPixels;
            Log.e("width  = " , String.valueOf(width));
            Log.e("height  = " , String.valueOf(height));
            Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.aquarium);
            canvas.drawBitmap(bitmap, null, new RectF(0, 0, width, height), null);

        }
    }
}
