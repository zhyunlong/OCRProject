package com.example.yunlong.ocrproject;


import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by yunlong on 2019/5/5.
 */

public class NormalDao implements Dao {
    public NormalDao(Context context) {
        super();
        this.context = context;
    }

    private Context context;
    private MyDatabaseHelper myDatabaseHelper ;
    @Override
    public List<Event> findAllEvent() {
        List<Event> list = new ArrayList<Event>();
        myDatabaseHelper = new MyDatabaseHelper(context,"MyEvent.db",null,2);
        SQLiteDatabase database = myDatabaseHelper.getReadableDatabase();
        Cursor cursor = database.query("EventTable",null,null,null,null,null,null);
        String info = "";
        String title = "";
        String content = "";
        String time = "";
        int id;
        String label="";
        if(cursor.moveToFirst()){
            do{
                id = cursor.getInt(cursor.getColumnIndex("id"));
                title = cursor.getString(cursor.getColumnIndex("title"));
                content = cursor.getString(cursor.getColumnIndex("content"));
                label = cursor.getString(cursor.getColumnIndex("label"));
                time = cursor.getString(cursor.getColumnIndex("time"));
                Event event = new NormalEvent();
                event.setId(id);
                event.setTitle(title);
                event.setContent(content);
                event.setLabel(label);
                list.add(event);
                info+=id;
                info+="  ";
                info+=title;
                info+="  ";
                info+=content;
                info+="  ";
                info+=label;
                info+="  ";
                info+=time;
                info+="\n";
            }while (cursor.moveToNext());
        }
        cursor.close();
        Log.i("DB",info);
        return list;
    }


    @Override
    public Boolean deleteEvent(int id) {
        myDatabaseHelper = new MyDatabaseHelper(context,"MyEvent.db",null,2);
        SQLiteDatabase database = myDatabaseHelper.getWritableDatabase();
        database.delete("EventTable","id=?",new String[]{String.valueOf(id)});
        return true;
    }

    @Override
    public Boolean addEvent(Event event) {
        myDatabaseHelper = new MyDatabaseHelper(context,"MyEvent.db",null,2);
        SQLiteDatabase database = myDatabaseHelper.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("title",event.getTitle());
        values.put("content",event.getContent());
        values.put("time",event.getTime());
        values.put("label",event.getLabel());
        database.insert("EventTable",null,values);
        values.clear();
        return true;
    }

    @Override
    public Boolean updateEvent(int id, String title, String content, String label, String time) {
        myDatabaseHelper = new MyDatabaseHelper(context,"MyEvent.db",null,2);
        SQLiteDatabase database = myDatabaseHelper.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("content",content);
        values.put("title",title);
        values.put("label",label);
        values.put("time",time);
        database.update("EventTable",values,"id=?",new String[]{String.valueOf(id)});
        values.clear();
        return true;
    }
}
