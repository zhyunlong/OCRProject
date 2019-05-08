package com.example.yunlong.ocrproject;

import android.content.Context;

import java.util.List;
import java.util.Map;

/**
 * Created by yunlong on 2019/5/5.
 */

public interface Dao {
    List<Event> findAllEvent();
    Boolean addEvent(Event event);
    Boolean deleteEvent(int id);
    Boolean updateEvent(int id, String title, String content, String label, String time);
}
