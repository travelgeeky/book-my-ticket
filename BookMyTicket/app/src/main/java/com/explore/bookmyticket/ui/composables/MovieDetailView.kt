package com.explore.bookmyticket.ui.composables

import android.app.Activity
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.explore.bookmyticket.data.pojo.MovieDetails
import com.explore.bookmyticket.data.utils.Constants
import com.explore.bookmyticket.ui.utils.SeatSelectionUtils

@Composable
fun MovieDetailsLayout(
    modifier: Modifier, movieDetails: MovieDetails?, maxTicketLimit: Int
) {
    val activity = (LocalContext.current as? Activity)

    movieDetails?.let {
        Column(
            modifier = modifier
                .background(Color.Red)
                .fillMaxWidth()
        ) {
            Row(
                modifier = modifier
                    .padding(top = 16.dp, start = 8.dp, end = 4.dp)
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically)
            {
                Row(
                    verticalAlignment = Alignment.CenterVertically) {
                    Text(text = it.movieName ?: Constants.EMPTY_STRING)
                    OutlinedButton(
                        modifier = Modifier
                            .padding(start = 4.dp, bottom = 8.dp)
                            .size(24.dp)
                            .align(Alignment.Top),
                        onClick = {},
                        border = BorderStroke(width = 1.dp, color = Color.White),
                        contentPadding = PaddingValues(all = 1.dp)
                    ) {
                        Text(
                            modifier = Modifier.align(Alignment.CenterVertically),
                            text = movieDetails.movieTag.toString(),
                            fontSize = 8.sp,
                            color = Color.White
                        )
                    }
                }
                    IconButton(
                        onClick = { activity?.finish() }, modifier = Modifier.padding(2.dp)) {
                            Icon(imageVector = Icons.Default.Close, contentDescription = null)
                        }
            }
            Row(
                modifier
                    .fillMaxWidth()
                    .padding(start = 8.dp, end = 4.dp, bottom = 16.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween)
            {
                Text(
                    modifier = Modifier.padding(end = 6.dp),
                    text = SeatSelectionUtils.getTheatreAndMovieDetail(movieDetails),
                    fontSize = 14.sp
                )
                OutlinedButton(
                    modifier = Modifier,
                    onClick = {},
                    shape = RoundedCornerShape(8.dp),
                    border = BorderStroke(1.dp, Color.White),
                    contentPadding = PaddingValues(
                        start = 2.dp, end = 2.dp, top = 4.dp, bottom = 4.dp
                    ),
                    content = {
                        Text(
                            modifier = modifier.padding(start = 4.dp, end = 4.dp),
                            text = "$maxTicketLimit Tickets",
                            color = Color.White,
                            maxLines = 1
                        )
                        Icon(
                            modifier = modifier.padding(all = 2.dp),
                            imageVector = Icons.Default.Edit,
                            contentDescription = null,
                            tint = Color.White
                        )
                    }
                )
            }
        }
    }
}
