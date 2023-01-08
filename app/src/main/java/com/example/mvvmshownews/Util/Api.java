package com.example.mvvmshownews.Util;

import com.example.mvvmshownews.model.Datamodel;
import java.util.List;
import io.reactivex.Single;
import retrofit2.http.GET;

public interface Api {
//    @GET("index.php")
    @GET("select.php")
    Single<List<Datamodel>> Listdatamodel();
}
