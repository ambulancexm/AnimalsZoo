package fr.ldnr.animalszootest;

import android.Manifest;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.text.Layout;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Constraints;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import java.io.File;
import java.io.FileWriter;
import java.util.Calendar;

public class HomeActivity extends Activity {

        public static int cpt = 0;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home);
        Log.e("Test = ","Test" + cpt );
        String news = "News du\n" + Calendar.getInstance().getTime() +"\nrien";

        ConstraintLayout ly = (ConstraintLayout) findViewById(R.id.home_layout);
            ly.setBackgroundColor(Color.WHITE);

        TextView tvNews= findViewById(R.id.home_news);
        tvNews.setText(news);
//        getResources().getColor(R.color.orange, null);
        Button btMap = findViewById(R.id.home_map);
        btMap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(HomeActivity.this, MapActivity.class));
            }
        });

        Button btAlert =  findViewById(R.id.alert_btn);
        btAlert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                SharedPreferences sp = getSharedPreferences("ZOO",MODE_PRIVATE);
                int c =sp.getInt("c",0);
                try {
                    if(ContextCompat.checkSelfPermission(HomeActivity.this, Manifest.permission.WRITE_EXTERNAL_STORAGE)!=
                    PackageManager.PERMISSION_GRANTED){
                        ActivityCompat.requestPermissions(HomeActivity.this,new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE},0);
                    }

                    if (Environment.getExternalStorageState().equals(Environment.MEDIA_MOUNTED)){
                        File dir=Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS);
                        FileWriter fw = new FileWriter(new File(dir, "log"),true);
                        fw.write("compte: " + c+ "\n");
                        clone();
                    }

                }catch (Exception e){
                    Log.e ("Home", "error" + e);
                }
                Log.i("Home","Compte "+ c);
                c++;
                SharedPreferences.Editor e = sp.edit();
                e.putInt("c",c);
                e.commit();
                startActivity(new Intent(HomeActivity.this, AlertActivity.class));
            }
        });




    }
}
