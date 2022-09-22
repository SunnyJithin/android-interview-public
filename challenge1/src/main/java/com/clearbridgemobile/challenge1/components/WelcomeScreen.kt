package com.clearbridgemobile.challenge1.components

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.clearbridgemobile.challenge1.R
import com.clearbridgemobile.challenge1.util.Screen

@OptIn(ExperimentalAnimationApi::class)
@Composable
fun WelcomeScreen(
    navController: NavController
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(colorResource(id = R.color.teal_200)),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,

        ) {
        Text(
            text = stringResource(R.string.welcome),
            style = MaterialTheme.typography.body1
        )
        Spacer(modifier = Modifier.height(8.dp))
        Text(
            text = stringResource(R.string.welcome_instructions),
            style = MaterialTheme.typography.body1
        )
        Spacer(modifier = Modifier.height(8.dp))
        Button(colors = ButtonDefaults.buttonColors(
            backgroundColor = colorResource(id = R.color.purple_500),
            contentColor = colorResource(id = R.color.white)
        ),
            onClick = {
                navController.navigate(Screen.HomeScreen.route){
                    popUpTo(Screen.WelcomeScreen.route) {
                        inclusive = true
                    }
                }
            }) {
            Text(text = stringResource(R.string.ok))
        }
    }
}