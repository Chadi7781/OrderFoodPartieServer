package com.example.chadi.androideatitserver.Remote;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface IGeoCoordinates {

    @GET("maps/api/gcode/json")
    Call<String> getGeoCode(@Query("address")String address);

    @GET("maps/api/directions/json")
    Call<String>getDirections(@Query("origin")String origine , @Query("destination")String destination);
}
