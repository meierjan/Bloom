package com.example.androiddevchallenge.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*

import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.androiddevchallenge.R
import com.example.androiddevchallenge.ui.theme.MyTheme

@Composable
fun Welcome() {

    Box(
        Modifier
            .background(color = MaterialTheme.colors.primary)
            .fillMaxWidth()
    ) {
        Image(
            imageVector = ImageVector.vectorResource(id = R.drawable.welcome_bg),
            contentDescription = "Background Image",
            modifier = Modifier.fillMaxSize()
        )

        Column(
            Modifier
                .fillMaxHeight()
        ) {

            Image(
                imageVector = ImageVector.vectorResource(id = R.drawable.welcome_illos),
                contentDescription = "Background-Leaf",
                modifier = Modifier
                    .padding(top = 72.dp, bottom = 48.dp)
                    .offset(88.dp)
            )

            Image(
                imageVector = ImageVector.vectorResource(id = R.drawable.logo),
                contentDescription = "Bloom-Logo",
                modifier = Modifier.fillMaxWidth()
            )

            Text(
                text = "Beautiful home garden solutions",
                modifier = Modifier.fillMaxWidth(),
                textAlign = TextAlign.Center,
                style = MaterialTheme.typography.subtitle1,
                color = MaterialTheme.colors.onPrimary
            )

            Spacer(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(40.dp)
            )

            Button(
                shape = MaterialTheme.shapes.medium,
                onClick = { /*TODO*/ },
                colors = ButtonDefaults.buttonColors(
                    backgroundColor = MaterialTheme.colors.secondary,
                    contentColor = MaterialTheme.colors.onSecondary
                ),
                modifier = Modifier
                    .fillMaxWidth()
                    .height(48.dp)
                    .padding(16.dp, 0.dp)
            ) {
                Text(text = "Create Account", style = MaterialTheme.typography.button)
            }

            Spacer(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(16.dp)
            )

            TextButton(
                onClick = {},
                modifier = Modifier
                    .padding(16.dp, 0.dp)
                    .fillMaxWidth()
            ) {
                Text(
                    text = "Log in", style = MaterialTheme.typography.button,
                    color = MaterialTheme.colors.onPrimary,
                    textAlign = TextAlign.Center
                )
            }
        }
    }
}

@Preview("Light Theme", widthDp = 360, heightDp = 640)
@Composable
fun LightPreviewLogin() {
    MyTheme {
        Welcome()
    }
}

@Preview("Dark Theme", widthDp = 360, heightDp = 640)
@Composable
fun DarkPreviewLogin() {
    MyTheme(darkTheme = true) {
        Welcome()
    }
}