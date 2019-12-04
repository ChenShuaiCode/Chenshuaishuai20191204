package com.bawei.chenshuaishuai20191204.view;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.bawei.chenshuaishuai20191204.R;
import com.bawei.chenshuaishuai20191204.base.BaseActivity;
import com.bawei.chenshuaishuai20191204.base.entity.Bean;
import com.bawei.chenshuaishuai20191204.contract.IUserContract;
import com.bawei.chenshuaishuai20191204.network.VolleyUtils;
import com.bawei.chenshuaishuai20191204.presenter.user.IUserPresenter;

import java.util.HashMap;
import java.util.Map;

public class MainActivity extends BaseActivity<IUserPresenter> implements IUserContract.IView {

    @Override
    protected void initdata() {

    }

    @Override
    protected void initview() {

    }

    @Override
    protected IUserPresenter initPresenter() {
        return new IUserPresenter();
    }

    @Override
    protected int layoutid() {
        return R.layout.activity_main;
    }

    @Override
    public void success(Bean bean) {
        showToast(bean.message);

    }

    @Override
    public void showLoding() {

    }

    @Override
    public void hideLoding() {

    }

    @Override
    public void failure(Throwable error) {

    }

    public void zhu(View view) {
        Map<String,String> params=new HashMap<>();
        params.put("phone","15654564565");
        params.put("pwd","111111");
        if (presenter!=null){
            presenter.reg(params);
        }
    }

    public void deng(View view) {
        Map<String,String> params=new HashMap<>();
        params.put("keyword","1");
        params.put("page","1");
        params.put("count","10");
        VolleyUtils.getInstance().doGet(params, "http://172.17.8.100/small/commodity/v1/findCommodityByKeyword", new VolleyUtils.VolleyCallback() {
            @Override
            public void success(String response) {
                showToast(response);
            }

            @Override
            public void failure(Throwable error) {

            }
        });



    }
}