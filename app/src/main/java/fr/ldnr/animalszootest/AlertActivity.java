package fr.ldnr.animalszootest;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;

import androidx.annotation.Nullable;

public class AlertActivity extends Activity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.alert);

//    LinearLayout rl = (LinearLayout) findViewById(R.id.alert_layout);
//    rl.setBackgroundColor(Color.RED);
    }

    public void send(View view) {
        try {
            ZooHelper zh = new ZooHelper(this);
            String title = ((EditText)findViewById(R.id.alert_title)).getText().toString();
            String place = ((EditText)findViewById(R.id.alert_place)).getText().toString();
            String message = ((EditText)findViewById(R.id.alert_message)).getText().toString();
            zh.insert(title,place,message);
            Log.i("retourDB", "ça marche");
        }catch (Exception e){
            Log.e("alert", "Error",e);
        }
        Toast.makeText(this,((EditText)findViewById(R.id.alert_title)).getText() + " envoyé",Toast.LENGTH_SHORT).show();
        finish();
    }
}
