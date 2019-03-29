package id.jhulang.restapi

import retrofit2.http.GET

interface IRetrofit {
    @GET("albums/1/photos")
    fun getPhotos() : io.reactivex.Observable<ArrayList<Model.photo>>
}