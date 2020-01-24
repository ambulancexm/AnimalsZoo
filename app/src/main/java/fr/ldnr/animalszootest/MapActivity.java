package fr.ldnr.animalszootest;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.RectF;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Toast;

import androidx.annotation.Nullable;

public class MapActivity extends Activity {

    int Xplace;
    int Yplace;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(new MapView(this));
        Toast.makeText(this, "debut", Toast.LENGTH_LONG).show();
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        if(event.getActionMasked()== MotionEvent.ACTION_DOWN){
            Intent i = new Intent(this, AquariumActivity.class);
            startActivity(i);
            i.putExtra("message", "pas de popcorn pour les poissons");
//            Xplace = (int) event.getX();
//            Yplace = (int) event.getY();
            Log.e ("x = ", String.valueOf(event.getX()));
            Log.e ("y = ", String.valueOf(event.getY()));


        }

        return true;
    }

    public class MapView extends View {

        public MapView(Context context) {
            super(context);

        }


        @Override
        protected void onDraw(Canvas canvas) {
            super.onDraw(canvas);

            int n = (int)(Math.random() * 6);

            int width = this.getResources().getDisplayMetrics().widthPixels;
            int height = this.getResources().getDisplayMetrics().heightPixels;

            Log.e("width  = ", String.valueOf(width));
            Log.e("height  = ", String.valueOf(height));
           Toast.makeText(getContext(), "aujourd'hui " + getResources().getStringArray(R.array.week)[n], Toast.LENGTH_LONG).show();

            Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.map);
//            canvas.drawBitmap(bitmap,0,0,null);
            canvas.drawBitmap(bitmap, null, new RectF(0, 0, width, height), null);

        }
    }
}
