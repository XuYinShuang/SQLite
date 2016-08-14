package com.zhiyuan3g.sqlite.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.zhiyuan3g.sqlite.R;
import com.zhiyuan3g.sqlite.dao.ContactDao;

public class DeleteActivity extends AppCompatActivity {
    EditText delete;
    Button sure;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delete);
        delete = (EditText) findViewById(R.id.delete);
        sure = (Button) findViewById(R.id.sure);
        sure.setOnClickListener(sureListener);
    }

    View.OnClickListener sureListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            String name = delete.getText().toString();
            //关联数据库
            ContactDao dao = new ContactDao(getApplicationContext());
            //执行删除操作
            boolean result = dao.deleteDataByName(name);
            if (result) {
                Toast.makeText(DeleteActivity.this, "删除成功", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(DeleteActivity.this, "删除失败", Toast.LENGTH_SHORT).show();
            }
        }
    };
}
