package com.noor.mymoviesapp

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    var currentPage:Int = 2
    lateinit var adp:MAdapter
    lateinit var lLM: LinearLayoutManager
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        adp=MAdapter(mutableListOf(),this)
        lLM= LinearLayoutManager(
            applicationContext,
            LinearLayoutManager.VERTICAL,
            false)
        rv.adapter = adp
        rv.layoutManager=lLM

        getPopMovies()
        scrollList()

    }

    fun getPopMovies() {
        MovieClient.fetchMovies(page = currentPage, onSuccess = ::onSuccessed,onerror = ::onError)
    }
    fun onSuccessed(list: MutableList<Movie>) {
        Log.d("Nour tag", "onResponse: ${list} ")
        adp.append(list)
        scrollList()
    }
    fun onError(){
        Toast.makeText(this@MainActivity, "failed to connect", Toast.LENGTH_SHORT).show()
    }
    fun scrollList(){
        rv.addOnScrollListener(object :RecyclerView.OnScrollListener(){
            override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
                var totalP:Int = lLM.itemCount
                var itemViewed:Int = lLM.childCount
                var firstItemV:Int = lLM.findFirstVisibleItemPosition()

                if(itemViewed + firstItemV >= totalP){
                    rv.removeOnScrollListener(this)
                    currentPage++
                    getPopMovies()
                }
            }
        })
    }





}





