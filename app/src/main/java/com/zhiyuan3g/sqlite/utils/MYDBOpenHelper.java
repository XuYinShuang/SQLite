package com.zhiyuan3g.sqlite.utils;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Administrator on 2016/6/28.
 */
public class MYDBOpenHelper extends SQLiteOpenHelper {
    //创建表的常量

    private static final String SQL_NAME="Create table Contact( id integer primary key autoincrement,name varchar(10),QQ varchar(11),msn varchar(50),phone varchar(12),face integer)";
    public MYDBOpenHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(SQL_NAME );
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
