package com.example.androiddevchallenge.screen

import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.androiddevchallenge.ui.theme.MyTheme

@Composable
fun SignUp() {

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp, 0.dp)
    ) {
        Spacer(
            modifier = Modifier
                .fillMaxWidth()
                .height(184.dp)
        )
        Text(
            text = "Log in with email",
            textAlign = TextAlign.Center,
            style = MaterialTheme.typography.h1,
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(
            modifier = Modifier
                .fillMaxWidth()
                .height(8.dp)
        )
        TextField(
            "",
//            label = "Email address",
            onValueChange = { /*TODO*/ },
            modifier = Modifier
                .fillMaxWidth()
                .height(56.dp)
        )

        TextField(
            value = "",
            onValueChange = {},
            modifier = Modifier
                .fillMaxWidth()
                .padding(PaddingValues(top = 8.dp))
                .height(56.dp)
        )

        Spacer(
            modifier = Modifier
                .fillMaxWidth()
                .height(8.dp)
        )

        Text(
            text = "By clicking below, you agree to our Terms of Use and consent to our Privacy Policy.",
            style = MaterialTheme.typography.body2,
            textAlign = TextAlign.Center,
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(
            modifier = Modifier
                .fillMaxWidth()
                .height(8.dp)
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
        ) {
            Text(text = "Log in")
        }
    }

}

@Preview("Light Theme", widthDp = 360, heightDp = 640)
@Composable
fun LightPreviewSignUp() {
    MyTheme {
        SignUp()
    }
}

@Preview("Dark Theme", widthDp = 360, heightDp = 640)
@Composable
fun DarkPreviewSignUp() {
    MyTheme(darkTheme = true) {
        SignUp()
    }
}