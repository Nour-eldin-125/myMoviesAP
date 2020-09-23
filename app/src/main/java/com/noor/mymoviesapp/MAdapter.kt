package com.noor.mymoviesapp

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.CenterCrop
import kotlinx.android.synthetic.main.card.view.*

class MAdapter (var moviesList:MutableList<Movie>, var mainActivity: MainActivity) :RecyclerView.Adapter<MAdapter.MyVH>() {

    class MyVH(itemView: View) : RecyclerView.ViewHolder(itemView) {


        fun onbind (movie: Movie){
           itemView.release_date.text = movie.year.toString()
           itemView.mName.text = movie.Name.toString()
           itemView.rate.text = "(${movie.rate.toString()})"

           // api key (ad61d2e15d680e25b0cb5e1449b90658)
           Glide.with(itemView).load("https://image.tmdb.org/t/p/w500${movie.posterPath}")
               .transform(
                   CenterCrop()
               ).into(itemView.img)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MAdapter.MyVH =
        MAdapter.MyVH(
            LayoutInflater.from(parent.context).inflate(
                R.layout.card,
                parent,
                false
            )
        )

    override fun getItemCount(): Int = moviesList.size

    override fun onBindViewHolder(holder: MyVH, position: Int) {
        holder.onbind(moviesList[position])

        holder.itemView.setOnClickListener{

            val intent= Intent(mainActivity,DD::class.java)

            val name:String=moviesList[position].Name.toString()
            val des:String=moviesList[position].overView.toString()
            val path:String=moviesList[position].posterPath.toString()
            val rate:String=moviesList[position].rate.toString()
            val year:String=moviesList[position].year.toString()

            intent.putExtra("name",name)
            intent.putExtra("path",path)
            intent.putExtra("des",des)
            intent.putExtra("rate",rate)
            intent.putExtra("year",year)

            mainActivity.startActivity(intent)
        }

    }
    public fun append(list: List<Movie>){
        this.moviesList.addAll(list)
        notifyItemRangeChanged(this.itemCount,moviesList.size-1)
    }


}