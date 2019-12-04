package com.bawei.chenshuaishuai20191204.base;

import android.os.Bundle;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.bawei.chenshuaishuai20191204.base.mvp.IBasePresenter;
import com.bawei.chenshuaishuai20191204.base.mvp.IBaseview;

public abstract class BaseActivity<P extends IBasePresenter> extends AppCompatActivity implements IBaseview {
    public P presenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(layoutid());
        presenter=initPresenter();
        if (presenter!=null){
            presenter.attach(this);
        }
        initview();
        initdata();
    }

    protected abstract void initdata();

    protected abstract void initview();

    protected abstract P initPresenter();

    protected abstract int layoutid();
    public void showToast(String msg){
        Toast.makeText(this,msg,Toast.LENGTH_SHORT).show();
    }
}
