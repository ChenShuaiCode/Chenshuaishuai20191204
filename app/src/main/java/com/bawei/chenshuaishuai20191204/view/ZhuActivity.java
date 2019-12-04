package com.bawei.chenshuaishuai20191204.view;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.bawei.chenshuaishuai20191204.R;

public class ZhuActivity extends AppCompatActivity {

    private Button zhu_btn;
    private EditText zhu_ed_1;
    private EditText zhu_ed_2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_zhu);
        zhu_btn = (Button) findViewById(R.id.zhu_btn);
        zhu_ed_1 = (EditText) findViewById(R.id.zhu_ed_1);
        zhu_ed_2 = (EditText) findViewById(R.id.zhu_ed_2);

        zhu_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (zhu_ed_1!=null&&zhu_ed_2!=null){
                    Toast.makeText(ZhuActivity.this,"注册成功,请登录",Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(ZhuActivity.this, MainActivity.class);
                    startActivity(intent);
                    finish();
                }else {
                    Toast.makeText(ZhuActivity.this,"手机号或密码不能为空",Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
