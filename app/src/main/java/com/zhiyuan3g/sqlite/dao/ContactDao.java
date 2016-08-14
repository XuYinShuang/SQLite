package com.zhiyuan3g.sqlite.dao;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.zhiyuan3g.sqlite.entity.Contact;
import com.zhiyuan3g.sqlite.utils.MYDBOpenHelper;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2016/6/28.
 */
public class ContactDao {

    private MYDBOpenHelper helper;
    private SQLiteDatabase db;

    public ContactDao(Context context) {
        //参数：绑定页面，数据库名称，工厂，版本号
        helper = new MYDBOpenHelper(context, "MYSQL", null, 1);
        //获取可读可写操作
        db = helper.getReadableDatabase();
    }

    //添加数据操作
    public boolean insertData(Contact contact) {
        boolean result = false;
        //插入数据的SQL语句
        String sql = "insert into Contact values(null,?,?,?,?,?)";
        //往数据库中插入数据
        String[] values = {contact.getName(), contact.getQQ(), contact.getMsn(), contact.getPhone(), String.valueOf(contact.getFace())};

        try {
            //执行插入数据操作
            db.execSQL(sql, values);
            result = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;

    }

    //删除数据
    public boolean deleteDataByName(String name) {
        boolean result = false;
        //删除数据条件
        String sql = "delete from Contact where name=?";
        //删除的数据
        String[] values = {name};
        try {
            //执行删除数据的操作
            db.execSQL(sql, values);
            result = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    //修改数据
    public boolean upDataById(Contact contact) {
        boolean result = false;
        String sql = "update Contact set name=?,QQ=?,msn=?,phone=?,face=? where id=?";
        String[] values = {contact.getName(), contact.getQQ(), contact.getMsn(), contact.getPhone(), String.valueOf(contact.getFace()), String.valueOf(contact.getId())};

        try {
            db.execSQL(sql, values);
            result = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    //单查

    //全查
    public List<Contact> getAllContact() {
        //添加联系人集合
        List<Contact> contacts = null;
        String sql = "select * from Contact";
        Cursor cursor;
        try {
            cursor = db.rawQuery(sql, null);
            //实例化联系人对象
            contacts = new ArrayList<>();
            //循环获取数据库中的数据
            while (cursor.moveToNext()) {
                //封装创建联系人对象
                Contact contact = new Contact(cursor.getInt(cursor.getColumnIndex("id")),
                        cursor.getString(cursor.getColumnIndex("name")),
                        cursor.getString(cursor.getColumnIndex("QQ")),
                        cursor.getString(cursor.getColumnIndex("msn")),
                        cursor.getString(cursor.getColumnIndex("phone")),
                        cursor.getInt(cursor.getColumnIndex("face")));
                contacts.add(contact);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return contacts;
    }
}
