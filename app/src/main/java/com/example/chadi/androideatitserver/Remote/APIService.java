package com.example.chadi.androideatitserver.Remote;

import com.example.chadi.androideatitserver.Model.MyResponse;
import com.example.chadi.androideatitserver.Model.Sender;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Headers;
import retrofit2.http.POST;

public interface APIService {
    @Headers(
            {
                    "Content-Type:application/json",
                    "Authorization:key=AAAAzhLXvaA:APA91bEZXJv36kNdoBDVI3wNw2y1bzpN6yKWnRr2CG2wjAisafyNcytPZiCGXDxmn-BYeG2yhw2l2aCRjslwEijm0pr5BTGJGlwMgHf7nKo9Vgd8CBSxyN1LzhjfFqYpXMJOrYJ2-LMT"

            }
    )
    @POST("fcm/send")
    Call<MyResponse> sendNotification(@Body Sender body);


}

