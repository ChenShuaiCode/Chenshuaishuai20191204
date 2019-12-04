package com.bawei.chenshuaishuai20191204.model.user;

import com.bawei.chenshuaishuai20191204.api.UserApi;
import com.bawei.chenshuaishuai20191204.base.entity.Bean;
import com.bawei.chenshuaishuai20191204.contract.IUserContract;
import com.bawei.chenshuaishuai20191204.network.VolleyUtils;
import com.google.gson.Gson;

import java.util.Map;

public class IUserModel implements IUserContract.Imodel {
    @Override
    public void reg( final Map<String, String> params, final ModelCallback modelCallback) {
        VolleyUtils.getInstance().doPost(params, UserApi.LOGIN_API, new VolleyUtils.VolleyCallback() {
            @Override
            public void success(String response) {
                if (modelCallback!=null){
                    Bean bean=new Gson().fromJson(response,Bean.class);
                    modelCallback.success(bean);
                }
            }
            @Override
            public void failure(Throwable error) {
                modelCallback.failure(error);
            }
        });

    }
}
