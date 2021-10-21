package com.fadhil.news_api

import com.fadhil.news_api.model.Berita
import retrofit2.http.GET
import retrofit2.Call
interface BeritaService  {

    @GET("everything?q=berita&from=2021-09-21&sortBy=publishedAt&apiKey=1fb0b676f40247499cb758648d795cce")
    fun getBerita(
    ):Call<Berita>
}