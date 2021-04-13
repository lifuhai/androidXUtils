package com.lfh.frame.client;

import android.util.Log;

import androidx.annotation.NonNull;

import com.lfh.frame.BuildConfig;
import com.lfh.frame.utils.ToolUtil;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import okhttp3.FormBody;
import okhttp3.Interceptor;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;
import okhttp3.logging.HttpLoggingInterceptor;

/**
 * @author lfh
 */
public class HttpClientHelper {


    public static OkHttpClient getOkHttpClient() {
        //创建OkHttpClient，并添加拦截器和缓存代码
        OkHttpClient client = new OkHttpClient.Builder()
                .connectTimeout(30, TimeUnit.SECONDS)
                .readTimeout(60, TimeUnit.SECONDS)
                .writeTimeout(60, TimeUnit.SECONDS)
                .addInterceptor(new MyLoggingInterceptor()) //表单请求 打印日志
                .addInterceptor(getInterceptor())  //打印日志
                .addInterceptor(getHeaderInterceptor()) //添加header
                .build();
        return client;

    }
    /**
     * 请求日志拦截器（form表单提交参数）
     */
    public static class MyLoggingInterceptor implements Interceptor {

        @Override
        public Response intercept(Chain chain) throws IOException {

            Request request = chain.request();
            Response response = chain.proceed(chain.request());

            ResponseBody responseBody = response.body();
            if (responseBody == null) {
                return response;
            }
            MediaType mediaType = responseBody.contentType();
            String content = responseBody.string();
            String method = request.method();
            if ("POST".equals(method)) {
                Map<String, String> map = new HashMap<>();
                if (request.body() instanceof FormBody) {
                    FormBody body = (FormBody) request.body();
                    if (null != body) {
                        for (int i = 0; i < body.size(); i++) {
                            map.put(body.encodedName(i), body.encodedValue(i));
                        }
                    }
                    Log.i("Request", "请求参数:" + ToolUtil.mapToJson(map) + "");
                }
            }
            return response.newBuilder()
                    .body(ResponseBody.create(mediaType, content))
                    .build();
        }
    }


    /**
     * 设置拦截器
     *  打印日志
     * @return
     */
    public  static Interceptor getInterceptor() {

        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        //显示日志
        if (BuildConfig.DEBUG) {
            interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);//测试
        }
        return interceptor;
    }


    /**
     * 设置Header
     *
     * @return
     */
    private  static Interceptor getHeaderInterceptor() {
        return new Interceptor() {
            @Override
            public Response intercept(@NonNull Chain chain) throws IOException {
                Request original = chain.request();
                Request.Builder requestBuilder = original.newBuilder()
                        //添加Token
                        .header("Authori-zation", "Bearer " + "").header("deviceType", "ANDROID");
                Request request = requestBuilder.build();
                return chain.proceed(request);
            }
        };

    }
}
