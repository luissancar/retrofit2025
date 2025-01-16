package com.example.retrofitclase2025

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.retrofitclase2025.model.Movie
import com.example.retrofitclase2025.ui.theme.Retrofitclase2025Theme
import com.example.retrofitclase2025.view.MovieItem
import com.example.retrofitclase2025.viewmodel.MovieViewModel

class MainActivity : ComponentActivity() {

    val movieViewModel by viewModels<MovieViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Retrofitclase2025Theme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Greeting(
                        name = "Android",
                        modifier = Modifier.padding(innerPadding),
                        movielist = movieViewModel


                    )
                }
            }
        }
    }
}


@Composable
fun MovieList(movieList: List<Movie>, error: Boolean) {
    if (error) {
        Box(Modifier.fillMaxSize()) {
            Text(
                text = "Error de conexión",
                modifier = Modifier.align(Alignment.Center),
                fontSize = 30.sp
            )
        }
    } else {
        LazyColumn {
            itemsIndexed(items = movieList) { index, item ->
                MovieItem(movie = item)
            }
        }
    }

}


@Composable
fun Greeting(name: String, modifier: Modifier = Modifier, movielist: MovieViewModel) {
    MovieList(movieList = movielist.movieListResponse, error = movielist.getErrorCon())
    movielist.getMovieList()

}
