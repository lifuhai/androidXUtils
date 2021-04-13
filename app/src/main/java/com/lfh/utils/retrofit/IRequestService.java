package com.lfh.utils.retrofit;

import java.util.Map;

import io.reactivex.Observable;
import retrofit2.http.Body;
import retrofit2.http.POST;

/**
 * @author lfh
 */
public interface IRequestService {

    /**
     *@param request
     * @return
     */
    @POST("ssss")
    Observable<Object> updateUMDeviceToken(@Body Map<String, String> request);


}
