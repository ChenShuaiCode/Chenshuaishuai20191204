package com.bawei.chenshuaishuai20191204.contract;

import com.bawei.chenshuaishuai20191204.base.entity.Bean;
import com.bawei.chenshuaishuai20191204.base.mvp.IBaseModel;
import com.bawei.chenshuaishuai20191204.base.mvp.IBaseview;

import java.util.Map;

public interface IUserContract {
   // interface
    interface Imodel extends IBaseModel{
        void reg(Map<String,String> params,ModelCallback modelCallback);
        interface ModelCallback{
            void success(Bean bean);
            void failure(Throwable throwable);
        }
   }
   interface IView extends IBaseview {
        void success(Bean bean);
        void failure(Throwable throwable);
   }
   interface IPresenter{
        void reg(Map<String,String> params);
   }
}
