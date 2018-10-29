package com.defretes.myapputs;


import retrofit2.Call;
import retrofit2.http.GET;

public interface IntApi {

    public static String DB_API = "15575403e880a10267e00b5e4b9d1155";

    @GET("now_playing?api_key="+DB_API)
    Call<Filem> getNp();
}
