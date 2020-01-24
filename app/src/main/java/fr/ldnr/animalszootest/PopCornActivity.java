package fr.ldnr.animalszootest;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.RectF;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Toast;

import androidx.annotation.Nullable;

public class PopCornActivity extends Activity {

    public long test;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(new MapView(this));
        test = System.currentTimeMillis();
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        if(event.getActionMasked()== MotionEvent.ACTION_DOWN){
            Intent i = new Intent(this, MapActivity.class);
            i.putExtra("message", getString(R.string.warning_eat));
//            i.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            Intent i2 = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.les-calories.com/calorie-13656-calories-pop-corn.html"));
            startActivityForResult(i2,0);
//            Xplace = (int) event.getX();
//            Yplace = (int) event.getY();
            Log.e ("x = ", String.valueOf(event.getX()));
            Log.e ("y = ", String.valueOf(event.getY()));


        }

        return true;
    }

    @Override
    public void onBackPressed() {
        Intent i= new Intent();
        int lg_warning = (getResources().getStringArray(R.array.aquarium_warnig).length);
        int n = (int) (Math.random()*lg_warning);

        long deltaTime = System.currentTimeMillis()-test;
        Log.e("deltaTime", String.valueOf(deltaTime));
//        i.putExtra("info",String.valueOf(deltaTime));
        i.putExtra("info",getResources().getStringArray(R.array.aquarium_warnig)[n]);
        setResult(0,i);
        super.onBackPressed();
    }

    private class MapView extends View {
        public MapView(Context context) {
            super(context);
        }
        @Override
        protected void onDraw(Canvas canvas) {
            super.onDraw(canvas);

            int width = this.getResources().getDisplayMetrics().widthPixels;
            int height = this.getResources().getDisplayMetrics().heightPixels;

            Log.e("width  = " , String.valueOf(width));
            Log.e("height  = " , String.valueOf(height));
            Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.popcorn);
//            canvas.drawBitmap(bitmap,0,0,null);
            canvas.drawBitmap(bitmap, null, new RectF(0, 0, width, height), null);

        }


    }
}
