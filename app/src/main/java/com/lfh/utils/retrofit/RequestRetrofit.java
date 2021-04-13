package com.lfh.utils.retrofit;



import com.lfh.frame.client.HttpClientHelper;
import com.lfh.utils.BuildConfig;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by lfh
 */

public class RequestRetrofit {
    private static IRequestService requestService;

    static {

         Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BuildConfig.HTTP_HOST)//设置全局的baseUrl
                .client(HttpClientHelper.getOkHttpClient())
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
        requestService = retrofit.create(IRequestService.class);
    }



    public static IRequestService getInstance() {
        return requestService;
    }
}
