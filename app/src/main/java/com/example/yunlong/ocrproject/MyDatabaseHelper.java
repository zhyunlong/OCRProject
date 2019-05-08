package com.example.yunlong.ocrproject;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

/**
 * Created by yunlong on 2019/4/1.
 */

public class MyDatabaseHelper extends SQLiteOpenHelper {
    public static final String CREATE_EVENT = "create table EventTable(id integer primary key autoincrement, label text,"+
            "title text,content text,notification int, time datetime)";
    private Context mContext;
    public MyDatabaseHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int verison){
        super(context,name,factory,verison);
        mContext = context;
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(CREATE_EVENT);
        Toast.makeText(mContext,"created",Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("drop table if exists EventTable");
        onCreate(sqLiteDatabase);
    }
}
