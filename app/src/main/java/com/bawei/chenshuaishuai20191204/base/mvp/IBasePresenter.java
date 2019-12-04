package com.bawei.chenshuaishuai20191204.base.mvp;

import java.lang.ref.WeakReference;

public abstract class IBasePresenter<M extends IBaseModel,V extends IBaseview> {
    protected M model;
    private WeakReference<V> weakReference;
    public IBasePresenter(){
        model=initModel();
    }

    public void attach(V v){
        weakReference=new WeakReference(v);
    }

    protected abstract M initModel();

    public void detach(){
        if (weakReference!=null){
            weakReference.clear();
            weakReference=null;
        }
    }
    public V getview(){
        return weakReference.get();
    }
}
