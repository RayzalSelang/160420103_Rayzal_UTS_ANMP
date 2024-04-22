package com.example.rayzal_160420103_hobbyapp.api



import retrofit2.Call
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST

interface ApiDb {

    @FormUrlEncoded
    @POST("login.php")
    fun login(
        @Field("username") username: String,
        @Field("password") password: String
    ): Call<LoginResponse>

    @FormUrlEncoded
    @POST("register.php")
    fun register(
        @Field("username") username: String,
        @Field("first_name") firstName: String,
        @Field("last_name") lastName: String,
        @Field("email") email: String,
        @Field("password") password: String
    ): Call<RegisterResponse>

    @FormUrlEncoded
    @POST("update_profile.php")
    fun updateProfile(
        @Field("user_id") userId: Int,
        @Field("first_name") firstName: String,
        @Field("last_name") lastName: String,
        @Field("password") password: String
    ): Call<UpdateProfileResponse>


}