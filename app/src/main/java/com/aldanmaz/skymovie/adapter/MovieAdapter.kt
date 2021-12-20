package com.aldanmaz.skymovie.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.aldanmaz.skymovie.databinding.MovieItemBinding
import com.aldanmaz.skymovie.models.Movie
import com.aldanmaz.skymovie.models.MovieResponse


class MovieAdapter : RecyclerView.Adapter<MovieAdapter.MovieViewHolder> () {

    inner class MovieViewHolder(val binding: MovieItemBinding) :
        RecyclerView.ViewHolder(binding.root)

    private val diffCallback = object : DiffUtil.ItemCallback<Movie>() {
        override fun areItemsTheSame(oldItem: Movie, newItem: Movie): Boolean {
           return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: Movie, newItem: Movie): Boolean {
            return newItem == oldItem
        }

    }

    private val differ = AsyncListDiffer(this,diffCallback)
    var movies: List<Movie>
    get() = differ.currentList
    set(value) {
        differ.submitList(value)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        return MovieViewHolder(
            MovieItemBinding.inflate(
            LayoutInflater.from(parent.context),parent,false
        ))
    }

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        val currentMovie = movies[position]

        holder.binding.apply{
            movieTitle.text = currentMovie.title
            movieYear.text = currentMovie.year
            movieGenre.text = currentMovie.genre
            moviePoster.load(currentMovie.poster) {
                crossfade(true)
                crossfade(1000)
            }
        }
    }

    override fun getItemCount() = movies.size
}
