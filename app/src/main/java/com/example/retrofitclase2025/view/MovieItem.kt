package com.example.retrofitclase2025.view

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import coil.transform.CircleCropTransformation
import com.example.retrofitclase2025.model.Movie

@Composable
fun MovieItem(movie: Movie) {
    Card(
        modifier= Modifier
            .padding(8.dp, 4.dp)
            .fillMaxWidth()
            .height(110.dp)
    )
    {
        Surface (){
            Row(
                modifier = Modifier
                    .padding(4.dp)
                    .fillMaxSize()
            ){
                AsyncImage(
                    model = ImageRequest.Builder(LocalContext.current)
                        .data(movie.imageUrl)
                        .transformations(CircleCropTransformation())
                        .build(),
                    modifier = Modifier
                        .fillMaxHeight()
                        .weight(0.2f),
                    contentDescription = movie.desc
                )
            }
        }
    }
}
