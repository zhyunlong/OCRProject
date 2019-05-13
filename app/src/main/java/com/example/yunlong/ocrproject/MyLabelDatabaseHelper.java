package com.example.yunlong.ocrproject;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

/**
 * Created by yunlong on 2019/5/13.
 */

public class MyLabelDatabaseHelper extends SQLiteOpenHelper {
    public static final String CREATE_LABEL = "create table LabelTable(id integer primary key autoincrement, labelname text)";
    private Context mContext;
    public MyLabelDatabaseHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int verison){
        super(context,name,factory,verison);
        mContext = context;
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(CREATE_LABEL);
        Toast.makeText(mContext,"created",Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("drop table if exists LabelTable");
        onCreate(sqLiteDatabase);
    }
}
