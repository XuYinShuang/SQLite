package com.zhiyuan3g.sqlite.entity;

/**
 * Created by Administrator on 2016/6/28.
 */

public class Contact  {

    private int id;
    private String name;
    private String QQ;
    private String msn;
    private String phone;
    private int face;

    public Contact(String name, String QQ, String msn, String phone, int face) {
        this.name = name;
        this.QQ = QQ;
        this.msn = msn;
        this.phone = phone;
        this.face = face;
    }

    public Contact(int id, String name, String QQ, String msn, String phone, int face) {
        this.id = id;
        this.name = name;
        this.QQ = QQ;
        this.msn = msn;
        this.phone = phone;
        this.face = face;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getQQ() {
        return QQ;
    }

    public void setQQ(String QQ) {
        this.QQ = QQ;
    }

    public String getMsn() {
        return msn;
    }

    public void setMsn(String msn) {
        this.msn = msn;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public int getFace() {
        return face;
    }

    public void setFace(int face) {
        this.face = face;
    }
}
