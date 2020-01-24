package fr.ldnr.animalszootest;


import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class ZooHelper extends SQLiteOpenHelper {
    private SQLiteDatabase db;

    public ZooHelper(Context context) {
        super(context, "zoodb", null, 1);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE ALERTS(ID INT PRIMARY KEY, title TEXT, place TEXT, message TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public void insert(String title, String place, String message){
        SQLiteDatabase db = getWritableDatabase();
        db.execSQL("INSERT INTO alerts(title,place,message)VALUES(?,?,?)", new Object[]{title,place,message});
    }

    public void find(String test){
        SQLiteDatabase db = getReadableDatabase();
        db.execSQL("SELECT * FROM alert");
    }
}
