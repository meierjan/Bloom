package com.example.androiddevchallenge.screen.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.androiddevchallenge.R
import com.example.androiddevchallenge.ui.theme.MyTheme

@Composable
fun ThemeSection(viewModel: HomeViewModel, modifier: Modifier = Modifier) {

    val themesState = viewModel.themes.observeAsState(emptyList())
    val themes: List<DecorationThemeModel> = themesState.value

    Column(modifier.fillMaxWidth()) {
        Text(
            text = "Browse themes",
            style = MaterialTheme.typography.h1,
            modifier = Modifier
                .fillMaxWidth()
                .paddingFromBaseline(top = 32.dp, bottom = 16.dp)
                .padding(start = 16.dp)
        )

        LazyRow(
            contentPadding = PaddingValues(start = 16.dp, end = 16.dp),
            horizontalArrangement = Arrangement.spacedBy(8.dp),
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 8.dp)
        ) {
            items(themes) { item ->
                ThemeSectionListItem(
                    title = item.title,
                    thumbnail = painterResource(id = item.image)
                )
            }

        }
    }
}

@Composable
fun ThemeSectionListItem(
    title: String,
    thumbnail: Painter,
    modifier: Modifier = Modifier
) {
    Card(
        elevation = 1.dp,
        shape = MaterialTheme.shapes.small,
        modifier = modifier
            .size(144.dp)
            // I don't know a better way of making the shadow work then
            // adding the space here so it can be drawn
            // I subtracted the padding from baseline padding of the
            // element underneath
            .padding(bottom = 8.dp)

    ) {
        Column(
            modifier = Modifier
                // I am not sure why I have to add this background here
                // but if we don't do this there is a weired square inside
                // (only on the phone)
                .background(MaterialTheme.colors.surface)
                .size(136.dp)

        ) {
            Image(
                painter = thumbnail,
                contentDescription = title,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .height(96.dp)
                    .fillMaxWidth()
            )
            Text(
                text = title,
                style = MaterialTheme.typography.h2,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 16.dp, top = 8.dp, bottom = 8.dp, end = 16.dp)
                    .height(40.dp)
            )
        }
    }
}

@Preview("Light Theme")
@Composable
fun DarkPreviewThemeSectionListItem() {
    MyTheme(darkTheme = true) {
        ThemeSectionListItem("blah", painterResource(R.drawable.monstera))
    }
}

@Preview("Dark Theme")
@Composable
fun LightPreviewThemeSectionListItem() {
    MyTheme(darkTheme = false) {
        ThemeSectionListItem("blah", painterResource(R.drawable.monstera))
    }
}