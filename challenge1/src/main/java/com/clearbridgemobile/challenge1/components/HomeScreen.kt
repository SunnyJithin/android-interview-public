package com.clearbridgemobile.challenge1.components

import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.clearbridgemobile.challenge1.R
import java.text.SimpleDateFormat
import java.util.*

@Composable
fun HomeScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,

        ) {
        Text(
            text = stringResource(R.string.home_hi),
            style = MaterialTheme.typography.body1
        )
        Spacer(modifier = Modifier.height(8.dp))
        val dateFormat =
            SimpleDateFormat("EEE MMM dd HH:mm:ss z yyyy", Locale.getDefault())
        val currentDateAndTime = dateFormat.format(Calendar.getInstance().time)
        Text(
            text = stringResource(R.string.home_time, currentDateAndTime),
            style = MaterialTheme.typography.body1
        )
    }
}