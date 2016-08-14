package com.zhiyuan3g.sqlite.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.zhiyuan3g.sqlite.R;
import com.zhiyuan3g.sqlite.dao.ContactDao;
import com.zhiyuan3g.sqlite.entity.Contact;

public class UpdateActivity extends AppCompatActivity {
    private int[] edtID = {R.id.update, R.id.name,R.id.QQ,R.id.MSN,R.id.phone,R.id.face};
    private EditText[] edtText = new EditText[edtID.length];
    Button btnSure;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update);
        btnSure = (Button) findViewById(R.id.btnSure);
        btnSure.setOnClickListener(btnSureListener);
        initView();
    }

    View.OnClickListener btnSureListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            //定义数组，用于存储文本框中输入的数据
            String[] values=new String[edtText.length];
            //获取文本框中输入的数据，并存储在数组中
            for (int i=0;i<edtText.length;i++){
                values[i]=edtText[i].getText().toString();
            }
            //封装数据成联系人对象
            Contact contact=new Contact(Integer.valueOf(values[0]),values[1],values[2],values[3],values[4],Integer.valueOf(values[5]));
            ContactDao dao=new ContactDao(getApplicationContext());
            //执行修改操作
            boolean result=dao.upDataById(contact);
            if (result){
                Toast.makeText(UpdateActivity.this, "修改数据成功", Toast.LENGTH_SHORT).show();
            }else {
                Toast.makeText(UpdateActivity.this, "修改数据失败", Toast.LENGTH_SHORT).show();
            }
        }
    };

    private void initView() {
        for (int i = 0; i < edtText.length; i++) {
            edtText[i] = (EditText) findViewById(edtID[i]);
        }
    }
}
