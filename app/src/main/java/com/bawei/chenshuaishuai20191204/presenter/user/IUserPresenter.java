package com.bawei.chenshuaishuai20191204.presenter.user;

import com.bawei.chenshuaishuai20191204.base.entity.Bean;
import com.bawei.chenshuaishuai20191204.base.mvp.IBasePresenter;
import com.bawei.chenshuaishuai20191204.contract.IUserContract;
import com.bawei.chenshuaishuai20191204.model.user.IUserModel;

import java.util.Map;

public class IUserPresenter extends IBasePresenter<IUserModel, IUserContract.IView> {

    @Override
    protected IUserModel initModel() {
        return new IUserModel();
    }
    public void reg(Map<String,String> params){
        model.reg(params, new IUserContract.Imodel.ModelCallback() {
            @Override
            public void success(Bean bean) {
                getview().success(bean);
            }
            @Override
            public void failure(Throwable throwable) {
                getview().failure(throwable);
            }
        });

    }
}
