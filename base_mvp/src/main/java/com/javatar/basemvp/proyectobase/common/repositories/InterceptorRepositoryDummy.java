package com.javatar.basemvp.proyectobase.common.repositories;

import android.util.Log;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.MediaType;
import okhttp3.Protocol;
import okhttp3.Response;
import okhttp3.ResponseBody;

/**
 * Created by Tadeo Gonzalez on 01/03/2018.
 */

public class InterceptorRepositoryDummy implements Interceptor {

    private String content;
    private int codeHttp;

    public InterceptorRepositoryDummy(String content, int codeHttp){
        this.content = content;
        this.codeHttp = codeHttp;
    }

    public InterceptorRepositoryDummy(String content){
        this(content,200);
    }

    @Override
    public Response intercept(Chain chain) throws IOException {
        Log.e("InterceptorDummy","requestBody: "+chain.request().url());
        Log.e("InterceptorDummy","responseBody: "+content);
        Response response = new Response.Builder()
                .code(codeHttp)
                .message(content)
                .request(chain.request())
                .protocol(Protocol.HTTP_1_0)
                .body(ResponseBody.create(MediaType.parse("application/json"), content.getBytes()))
                .addHeader("content-type", "application/json")
                .build();


        return response;
    }
}