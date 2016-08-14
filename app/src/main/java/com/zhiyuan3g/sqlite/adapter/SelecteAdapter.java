package com.zhiyuan3g.sqlite.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.zhiyuan3g.sqlite.R;
import com.zhiyuan3g.sqlite.entity.Contact;

import java.util.List;

/**
 * Created by Administrator on 2016/6/28.
 */
public class SelecteAdapter extends BaseAdapter {
    List<Contact> contacts;
    Context context;
    int[] face = {R.drawable.dg,R.drawable.ls,R.drawable.ly,R.drawable.mz,R.drawable.we,R.drawable.xg,R.drawable.zs};

    public SelecteAdapter(List<Contact> contacts, Context context) {
        this.contacts = contacts;
        this.context = context;
    }

    @Override
    public int getCount() {
        return contacts.size();
    }

    @Override
    public Object getItem(int position) {
        return position;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Holder holder = new Holder();
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.info, null);
            holder.face = (ImageView) convertView.findViewById(R.id.face);
            holder.name = (TextView) convertView.findViewById(R.id.name);
            holder.QQ = (TextView) convertView.findViewById(R.id.QQ);
            holder.MSN = (TextView) convertView.findViewById(R.id.MSN);
            holder.phone = (TextView) convertView.findViewById(R.id.phone);
            convertView.setTag(holder);
        } else {
            holder = (Holder) convertView.getTag();
        }
        Contact contact = contacts.get(position);
        holder.face.setImageResource(face[contact.getFace()]);
        holder.name.setText(contact.getName());
        holder.QQ.setText(contact.getQQ());
        holder.MSN.setText(contact.getMsn());
        holder.phone.setText(contact.getPhone());
        return convertView;
    }

    class Holder {
        TextView name, QQ, MSN, phone;
        ImageView face;
    }
}
