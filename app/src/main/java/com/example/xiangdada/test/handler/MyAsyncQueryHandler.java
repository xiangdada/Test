package com.example.xiangdada.test.handler;

import android.content.AsyncQueryHandler;
import android.content.ContentResolver;
import android.content.ContentValues;
import android.database.Cursor;
import android.net.Uri;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by xdd on 2019/3/10
 */
public class MyAsyncQueryHandler extends AsyncQueryHandler {
    public MyAsyncQueryHandler(ContentResolver cr) {
        super(cr);
    }

    @Override
    protected void onQueryComplete(int token, Object cookie, Cursor cursor) {
        if (cursor == null || !cursor.moveToFirst()) {
            return;
        }
        Log.i("测试", "---------------------------onQueryComplete-----------------------");
        while (cursor.moveToNext()) {
            Log.i("测试", cursor.getString(1)
                    + "  " + cursor.getString(2)
                    + "  " + cursor.getString(3));
        }

//        for(int i=0;i<cursor.getCount();i++){
//            cursor.moveToPosition(i);
//            Log.i("测试", cursor.getString(1)
//                    + "  " + cursor.getString(2)
//                    + "  " + cursor.getString(3));
//        }
    }

}
