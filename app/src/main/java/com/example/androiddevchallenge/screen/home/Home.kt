package com.example.androiddevchallenge.screen.home

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.androiddevchallenge.Navigator
import com.example.androiddevchallenge.Screen
import com.example.androiddevchallenge.ui.theme.MyTheme


@Composable
fun Home(navigator: Navigator) {

    val viewModel = viewModel(HomeViewModel::class.java)

    Scaffold(
        topBar = { HomeTopSearchbar() },
        bottomBar = { HomeNavigationBar() },
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 40.dp)
    ) {
        Column(
            modifier = Modifier
                .verticalScroll(rememberScrollState())
                .fillMaxWidth()
        ) {
            ThemeSection(viewModel)
            DesignsSection(viewModel)
        }
    }
}


@Preview("Light Theme", widthDp = 360, heightDp = 640)
@Composable
fun DarkPreviewHome() {
    MyTheme(darkTheme = true) {
        val navigator = object : Navigator {
            override fun navigate(screen: Screen) {}
        }
        Home(navigator)
    }
}

@Preview("Dark Theme", widthDp = 360, heightDp = 640)
@Composable
fun LightPreviewHome() {
    MyTheme(darkTheme = false) {
        val navigator = object : Navigator {
            override fun navigate(screen: Screen) {}
        }
        Home(navigator)
    }
}