package app.superesenou.ru.example_neobis_translate.main.data



import android.support.annotation.StringRes
import app.superesenou.ru.example_neobis_translate.main.models.*


import retrofit2.Call
import retrofit2.http.*



interface ForumService {

    @GET("/posts")
    fun getDate(): Call<List<Contact>>

    @GET("/albums")
    fun getDateAlbums():Call<List<ContactAlbums>>

    @GET("/v1/current.json?key=775f00d9a2754b1e9c0130256182106&")
    fun getDateWeather(@Query("q") txt:String):Call<ContactWeather>

    @GET("/comments")

    fun getDateComments():Call<List<ContactComment>>

    @GET("/photos")

    fun getDatePhotos():Call<List<ContactPhotos>>


}