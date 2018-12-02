package com.javatar.basemvp.proyectobase.common.repositories;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.javatar.basemvp.proyectobase.interfaces.callbacks.DataCallback;
import com.javatar.basemvp.proyectobase.interfaces.structures.IRepository;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import static com.javatar.basemvp.proyectobase.common.repositories.AbstractServiceRepository.Level.NONE;

/**
 * Created by Tadeo-developer on 24/09/17.
 */

public abstract class AbstractServiceRepository<TCallback extends DataCallback,TResponse> implements IRepository<TCallback> {

    public static final int CONNECT_TIMEOUT_= 2;
    public static final int READ_TIMEOUT = 2;
    public static final int WRITE_TIMEOUT = 2;

    /* public static final TimeUnit TIME_UNIT_CONNECT =
                .connectTimeout(2, TimeUnit.MINUTES)
                 .readTimeout(2,TimeUnit.MINUTES)
                 .writeTimeout(2,TimeUnit.MINUTES)
 */
    public enum Level {
        NONE,
        BASIC,
        HEADERS,
        BODY
    }

    public static Level LEVEL_LOG = NONE;

    private String baseUrl;

    public AbstractServiceRepository(String baseUrl) {
        this.baseUrl = baseUrl;
    }

    protected Retrofit getRetrofit(String baseUrl, OkHttpClient client, Gson gson) {
        return new Retrofit.Builder()
                .baseUrl(baseUrl)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .client(client)
                .build();
    }

    protected Retrofit getRetrofit(String baseUrl, Gson gson) {
        return getRetrofit(baseUrl,getRetrofitClient(),gson);
    }

    protected Retrofit getRetrofit(String baseUrl, OkHttpClient client) {
        return getRetrofit(baseUrl,client,new GsonBuilder().create());
    }

    protected Retrofit getRetrofit(String baseUrl, Level level) {

        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.valueOf(level.name()));

        OkHttpClient client = new OkHttpClient.Builder()
                .connectTimeout(CONNECT_TIMEOUT_, TimeUnit.MINUTES)
                .readTimeout(READ_TIMEOUT,TimeUnit.MINUTES)
                .writeTimeout(WRITE_TIMEOUT,TimeUnit.MINUTES)
                .addInterceptor(interceptor).build();

        return getRetrofit(baseUrl,client);
    }

    protected Retrofit getRetrofit(String baseUrl) {
        return getRetrofit(baseUrl, LEVEL_LOG);
    }

    protected OkHttpClient getRetrofitClient(Level level){
        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.valueOf(level.name()));

        return new OkHttpClient.Builder()
                .connectTimeout(CONNECT_TIMEOUT_, TimeUnit.MINUTES)
                .readTimeout(READ_TIMEOUT,TimeUnit.MINUTES)
                .writeTimeout(WRITE_TIMEOUT,TimeUnit.MINUTES)
                .addInterceptor(interceptor).build();
    }

    protected OkHttpClient getRetrofitClient(){
        return getRetrofitClient(LEVEL_LOG);
    }

    protected Callback createCallBack(final TCallback dataCallBack) {

        Callback<TResponse> callbackResponse = new Callback<TResponse>() {
            @Override
            public void onResponse(Call<TResponse> call, Response<TResponse> response) {

                if(response.isSuccessful()){

                    TResponse reponse = response.body();
                    if(reponse!=null){
                        getResponse(dataCallBack,response.body(),response.code());
                    }else{
                        dataCallBack.onError("Sin información de respuesta");
                    }

                }else{

                    try {
                        String jsonError = response.errorBody().string();
                        /*Type typeSuper = AbstractServiceRepository.this.getClass().getGenericSuperclass();
                        Type clazz = ((ParameterizedType)typeSuper).getActualTypeArguments()[0];*/

                        dataCallBack.onError(new Gson().fromJson(jsonError, com.javatar.basemvp.proyectobase.models.data.Response.class));
                    } catch (Exception e) {

                        JSONObject jsonObject = new JSONObject();
                        try {
                            jsonObject.accumulate("code","ERROR");
                            jsonObject.accumulate("resultadoOperacion",-1);
                            jsonObject.accumulate("descripcion",e.getMessage());
                            dataCallBack.onError(new Gson().fromJson(jsonObject.toString(),com.javatar.basemvp.proyectobase.models.data.Response.class));
                        } catch (JSONException e2) {
                            e.printStackTrace();
                            dataCallBack.onError(e2.getMessage());
                        }

                    }
                }


            }

            @Override
            public void onFailure(Call<TResponse> call, Throwable t) {

                JSONObject jsonObject = new JSONObject();
                try {
                    jsonObject.accumulate("code","FAILURE");
                    jsonObject.accumulate("resultadoOperacion",-1);
                    jsonObject.accumulate("descripcion",t.getMessage());
                    dataCallBack.onError(new Gson().fromJson(jsonObject.toString(),com.javatar.basemvp.proyectobase.models.data.Response.class));
                } catch (JSONException e) {
                    e.printStackTrace();
                    dataCallBack.onError(e.getMessage());
                }


            }
        };

        return callbackResponse;

    }

    protected abstract void getResponse(TCallback dataCallBack, TResponse response, int codeHttp);

    public String getBaseUrl() {
        return baseUrl;
    }

    public void setBaseUrl(String baseUrl) {
        this.baseUrl = baseUrl;
    }
}
