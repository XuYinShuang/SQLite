package com.zhiyuan3g.sqlite.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.zhiyuan3g.sqlite.R;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btnDelete:
                Intent intent = new Intent(MainActivity.this, DeleteActivity.class);
                startActivity(intent);
                break;
            case R.id.btnInsert:
                Intent intent1 = new Intent(MainActivity.this, InsertActivity.class);
                startActivity(intent1);
                break;
            case R.id.btnSelect:
                Intent intent2 = new Intent(MainActivity.this, SeleteActivity.class);
                startActivity(intent2);
                break;
            case R.id.btnUpdate:
                Intent intent3 = new Intent(MainActivity.this, UpdateActivity.class);
                startActivity(intent3);
                break;

        }
    }
}
