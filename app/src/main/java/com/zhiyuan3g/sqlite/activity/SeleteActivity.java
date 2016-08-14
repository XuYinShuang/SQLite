package com.zhiyuan3g.sqlite.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import com.zhiyuan3g.sqlite.R;
import com.zhiyuan3g.sqlite.adapter.SelecteAdapter;
import com.zhiyuan3g.sqlite.dao.ContactDao;
import com.zhiyuan3g.sqlite.entity.Contact;

import java.util.List;

public class SeleteActivity extends AppCompatActivity {
    ListView lstView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_selete);

        lstView = (ListView) findViewById(R.id.lstView);

        ContactDao dao = new ContactDao(getApplicationContext());

        final List<Contact> contacts = dao.getAllContact();

        SelecteAdapter adapter = new SelecteAdapter(contacts, this);

        lstView.setAdapter(adapter);
    }
}
