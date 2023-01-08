package com.example.mvvmshownews.Util;

import com.example.mvvmshownews.model.Datamodel;
import java.util.List;
import io.reactivex.Single;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class webservice {

//    String baseurl="http://192.168.1.35/shop/";
    String baseurl="https://www.rezaeianengineer.com/newsMVVM/";
    Api api;
    public webservice(){
        Retrofit retrofit=new Retrofit.Builder()
                .baseUrl(baseurl)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
       api= retrofit.create(Api.class);
    }

    public Single<List<Datamodel>> listSingle(){
        return api.Listdatamodel();
    }



}
