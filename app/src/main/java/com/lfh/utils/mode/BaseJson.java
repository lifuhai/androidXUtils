package com.lfh.utils.mode;

import com.google.gson.Gson;

public class BaseJson {

    public String json(){

        Gson gson  = new Gson();
        return  gson.toJson(this);
    }
}
