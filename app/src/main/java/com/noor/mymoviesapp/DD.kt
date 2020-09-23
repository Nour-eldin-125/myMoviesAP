package com.noor.mymoviesapp

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.activity_d_d.*

class DD : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_d_d)

        name.text=intent.getStringExtra("name")
        year.text=intent.getStringExtra("year")
        description.text=intent.getStringExtra("des")
        rate.text="(${intent.getStringExtra("rate")})"
        Glide.with(imageView).load("https://image.tmdb.org/t/p/w500${intent.getStringExtra("path")}").into(imageView)



        Log.d("tag", "onCreate: ${intent.getStringExtra("name")}")


    }

}
