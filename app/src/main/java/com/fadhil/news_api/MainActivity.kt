package com.fadhil.news_api

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import com.fadhil.news_api.adapter.beritaAdapter
import com.fadhil.news_api.databinding.ActivityMainBinding
import com.fadhil.news_api.model.Berita
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : AppCompatActivity() {

    var binding : ActivityMainBinding? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding?.root)

//        konfigurasi retrogitnya(2)
        val retrofit = Retrofit.Builder()
            .baseUrl("https://newsapi.org/v2/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        val service = retrofit.create(BeritaService::class.java)

//        request
        service.getBerita().enqueue(object : Callback<Berita>{
            override fun onResponse(call: Call<Berita>, response: Response<Berita>) {

                Log.d("RESPONSE SERVER", "onResponse: ${response.message()}")
                val code =response.body()?.status

                if(code == "ok"){
                    //get data
                    val articles = response.body()?.articles

                    binding?.ListBerita?.adapter = articles?.let { beritaAdapter(it)}
                    binding?.ListBerita?.layoutManager = LinearLayoutManager(this@MainActivity)
                }
            }

            override fun onFailure(call: Call<Berita>, t: Throwable) {
                Log.d("RESPONSE ERROR", t.localizedMessage)
            }

        })




    }
}