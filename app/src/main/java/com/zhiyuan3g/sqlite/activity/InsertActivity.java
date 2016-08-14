package com.zhiyuan3g.sqlite.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.zhiyuan3g.sqlite.R;
import com.zhiyuan3g.sqlite.dao.ContactDao;
import com.zhiyuan3g.sqlite.entity.Contact;

public class InsertActivity extends AppCompatActivity {

    private int[] edtID = {R.id.name, R.id.QQ, R.id.phone, R.id.MSN, R.id.face};
    private EditText[] editTexts = new EditText[edtID.length];
    Button btnSure;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_insert);
        initView();
        btnSure = (Button) findViewById(R.id.btnSure);
        btnSure.setOnClickListener(btnSureListener);
    }

    private void initView() {
        //循环绑定控件
        for (int i = 0; i < editTexts.length; i++) {
            editTexts[i] = (EditText) findViewById(edtID[i]);
        }
    }

    View.OnClickListener btnSureListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            //定义数组的长度
            String[] values = new String[editTexts.length];
            for (int i = 0; i < editTexts.length; i++) {
                values[i] = editTexts[i].getText().toString();
            }
            //将获取的数据进行封装成Contact对象
            Contact contact = new Contact(values[0], values[1], values[2], values[3], Integer.valueOf(values[4]));
            //关联数据库
            ContactDao dao=new ContactDao(getApplicationContext());
            //调用添加数据方法
            boolean result=dao.insertData(contact);
            if (result){
                Toast.makeText(InsertActivity.this, "成功添加数据", Toast.LENGTH_SHORT).show();
            }else{
                Toast.makeText(InsertActivity.this, "添加数据失败", Toast.LENGTH_SHORT).show();
            }
        }
    };
}
