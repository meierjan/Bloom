package com.example.androiddevchallenge.screen.register

import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.androiddevchallenge.Navigator
import com.example.androiddevchallenge.Screen
import com.example.androiddevchallenge.ui.theme.MyTheme

@Composable
fun SignUp(navigator: Navigator) {

    val onLoginClicked = {
        navigator.navigate(Screen.Home)
    }

    val viewModel = viewModel(SignUpViewModel::class.java)

    // we should consider not storing the password for security reasons
    var password by remember { mutableStateOf("") }
    var emailInputState by remember { mutableStateOf("") }


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
            color = MaterialTheme.colors.onBackground,
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(
            modifier = Modifier
                .fillMaxWidth()
                .height(8.dp)
        )
        OutlinedTextField(
            value = emailInputState,
            placeholder = {
                Text("Email address", style = MaterialTheme.typography.body1)
            },
            textStyle = MaterialTheme.typography.body1,
            singleLine = true,
            onValueChange = { emailInputState = it },
            modifier = Modifier
                .height(56.dp)
                .fillMaxWidth()
        )

        OutlinedTextField(
            value = password,
            textStyle = MaterialTheme.typography.body1,
            placeholder = {
                Text(
                    "Password (8+ characters)",
                    style = MaterialTheme.typography.body1,
                    modifier = Modifier.fillMaxSize()
                )
            },
            singleLine = true,
            onValueChange = { password = it },

            modifier = Modifier
                .height(56.dp)
                .fillMaxWidth()
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
            color = MaterialTheme.colors.onPrimary,
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(
            modifier = Modifier
                .fillMaxWidth()
                .height(8.dp)
        )

        Button(
            shape = MaterialTheme.shapes.medium,
            onClick = onLoginClicked,
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
        val navigator = object : Navigator {
            override fun navigate(screen: Screen) {}
        }
        SignUp(navigator)
    }
}

@Preview("Dark Theme", widthDp = 360, heightDp = 640)
@Composable
fun DarkPreviewSignUp() {
    MyTheme(darkTheme = true) {
        val navigator = object : Navigator {
            override fun navigate(screen: Screen) {}
        }
        SignUp(navigator)
    }
}