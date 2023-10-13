package com.explore.bookmyticket.ui.composables

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import com.explore.bookmyticket.R
import com.explore.bookmyticket.data.pojo.ApiException
import com.explore.bookmyticket.ui.utils.ErrorMessageUtils

@Composable
fun ErrorLayout(modifier: Modifier,
                apiException: ApiException,
                onRetry: ()->Unit) {

    Column(
        modifier = modifier.padding(8.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        val context = LocalContext.current
        Text(
            modifier = modifier.padding(top = 36.dp, bottom = 8.dp),
            text = ErrorMessageUtils.getErrorMessage(apiException, context = context)
        )
        OutlinedButton(
            onClick = { onRetry() },
            border = BorderStroke(width = 1.dp, color = Color.Red)
        ) {
            Text(
                modifier = modifier.padding(all = 8.dp),
                text = context.getString(R.string.retry_btn_label))
        }
    }


}