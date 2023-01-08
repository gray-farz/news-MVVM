package com.example.mvvmshownews.Viewmodel;

import android.util.Log;

import com.example.mvvmshownews.Util.webservice;
import com.example.mvvmshownews.model.Datamodel;
import java.util.List;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import io.reactivex.Scheduler;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.observers.DisposableSingleObserver;
import io.reactivex.schedulers.Schedulers;

public class Viewmodel_Listpost extends ViewModel
{
    public static final String TAG="aaa";

    private MutableLiveData<List<Datamodel>> listMutableLiveData=new MutableLiveData<>();
    public MutableLiveData<Boolean> liveData_looging=new MutableLiveData<>();
    private CompositeDisposable compositeDisposable=new CompositeDisposable();
    public MutableLiveData<List<Datamodel>> mutableLiveData()
    {
        liveData_looging.setValue(true);
        webservice web=new webservice();
        compositeDisposable.add(web.listSingle()
        .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(new DisposableSingleObserver<List<Datamodel>>() {
                    @Override
                    public void onSuccess(List<Datamodel> datamodels) {
                        Log.d(TAG, "onSuccess: ");
                        liveData_looging.setValue(false);
                        listMutableLiveData.setValue(datamodels);
                    }
                    @Override
                    public void onError(Throwable e) {
                        Log.d(TAG, "onError: "+e.toString());
                        liveData_looging.setValue(false);
                    }
                })
        );
        return listMutableLiveData;
    }

    @Override
    protected void onCleared()
    {
        compositeDisposable.clear();
        super.onCleared();
    }
}
