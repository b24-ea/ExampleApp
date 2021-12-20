package com.aldanmaz.skymovie

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.activity.viewModels
import androidx.lifecycle.MutableLiveData
import androidx.recyclerview.widget.LinearLayoutManager
import com.aldanmaz.skymovie.adapter.MovieAdapter
import com.aldanmaz.skymovie.databinding.ActivityMainBinding
import com.aldanmaz.skymovie.models.Movie
import com.aldanmaz.skymovie.viewmodel.MovieViewModel
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

   private lateinit var binding: ActivityMainBinding
    private val viewModel: MovieViewModel by viewModels()
    private lateinit var movieAdapter: MovieAdapter

    val movies = MutableLiveData<List<Movie>>()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        supportActionBar?.hide()

        setUpRv()


    }
    private fun setUpRv() {
        movieAdapter = MovieAdapter()

      binding.movieRecycler.apply {
            adapter = movieAdapter
            layoutManager = LinearLayoutManager(
                this@MainActivity, LinearLayoutManager.HORIZONTAL, false
            )
            setHasFixedSize(true)
        }


        viewModel.responseMovie.observe(this, {movies ->

        movieAdapter.movies = movies

      })
    }
}