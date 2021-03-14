package com.example.androiddevchallenge.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.androiddevchallenge.R
import com.example.androiddevchallenge.ui.theme.MyTheme

@Composable
fun Home() {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp, 0.dp)
    ) {
        Spacer(
            modifier = Modifier
                .fillMaxWidth()
                .height(40.dp)
        )

        OutlinedTextField(
            value = "",
            textStyle = MaterialTheme.typography.body1,
            leadingIcon = {

            },
            placeholder = {
                Text(
                    "Search",
                    style = MaterialTheme.typography.body1,
                    modifier = Modifier.fillMaxWidth()
                )
            },
            singleLine = true,
            onValueChange = {},

            modifier = Modifier
                .height(56.dp)
                .fillMaxWidth()
        )

        Text(
            text = "Browse themes",
            style = MaterialTheme.typography.h1,
            color = MaterialTheme.colors.onBackground,
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 24.dp, bottom = 16.dp)
        )

        Row(modifier = Modifier.fillMaxWidth()) {
            PlantThemeTab(
                title = "Desert chic",
                thumbnail = painterResource(id = R.drawable.desert_chic)
            )
            Spacer(
                modifier = Modifier
                    .width(8.dp)
                    .height(64.dp)
            )
            PlantThemeTab(
                title = "Tiny Terrariums",
                thumbnail = painterResource(id = R.drawable.little_terrariums)
            )
            Spacer(
                modifier = Modifier
                    .width(8.dp)
                    .height(64.dp)
            )
            PlantThemeTab(
                title = "Jungle vibes",
                thumbnail = painterResource(id = R.drawable.jungle_vibes)
            )
            Spacer(
                modifier = Modifier
                    .width(8.dp)
                    .height(64.dp)
            )
            PlantThemeTab(
                title = "Easy care",
                thumbnail = painterResource(id = R.drawable.easy_care)
            )
            Spacer(
                modifier = Modifier
                    .width(8.dp)
                    .height(64.dp)
            )
            PlantThemeTab(
                title = "Statements",
                thumbnail = painterResource(id = R.drawable.statements)
            )
            Spacer(
                modifier = Modifier
                    .width(8.dp)
                    .height(64.dp)
            )
        }

        Text(
            text = "Design your home garden",
            style = MaterialTheme.typography.h1,
            color = MaterialTheme.colors.onBackground,
            modifier = Modifier.padding(top = 24.dp, bottom = 16.dp)
        )


        PlanListItem(
            title = "Monstera",
            thumbnail = painterResource(id = R.drawable.monstera),
            isSelected = true
        )

        Spacer(modifier = Modifier.width(8.dp))

        PlanListItem(
            title = "Aglaonema",
            thumbnail = painterResource(id = R.drawable.agloaonema)
        )

        Spacer(modifier = Modifier.width(8.dp))

        PlanListItem(
            title = "Peace lily",
            thumbnail = painterResource(id = R.drawable.peace_lily)
        )

        Spacer(modifier = Modifier.width(8.dp))

        PlanListItem(
            title = "Fiddle leaf tree",
            thumbnail = painterResource(id = R.drawable.fiddle_leaf)
        )

    }
}

@Composable
fun PlantThemeTab(
    title: String,
    thumbnail: Painter
) {
    Card(
        elevation = 1.dp,
        shape = MaterialTheme.shapes.small,
        modifier = Modifier
            .width(160.dp)
            .height(136.dp)
    ) {
        Column {
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
                color = MaterialTheme.colors.onBackground,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 16.dp, top = 8.dp, bottom = 8.dp, end = 16.dp)
                    .height(40.dp)
            )
        }
    }
}

@Composable
fun PlanListItem(
    title: String,
    description: String = "This is a description",
    thumbnail: Painter,
    isSelected: Boolean = false
) {

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(64.dp)
    ) {
        Image(
            painter = thumbnail,
            contentDescription = title,
            modifier = Modifier
                .width(64.dp)
                .height(64.dp)
                .clip(MaterialTheme.shapes.small)
        )

        Column(
            modifier = Modifier
                .padding(start = 16.dp)
                .height(64.dp)
                .fillMaxWidth()
        ) {
            Text(
                text = title,
                style = MaterialTheme.typography.h2,
                color = MaterialTheme.colors.onBackground,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 8.dp)
            )
            Text(
                text = description,
                style = MaterialTheme.typography.body1,
                color = MaterialTheme.colors.onBackground,
                modifier = Modifier.fillMaxWidth()
            )
        }

    }
    Spacer(
        modifier = Modifier
            .fillMaxWidth()
            .height(8.dp)
    )

}

@Preview("Dark Theme", widthDp = 360, heightDp = 640)
@Composable
fun LightPreviewHome() {
    MyTheme(darkTheme = false) {
        Home()
    }
}

@Preview("Light Theme", widthDp = 360, heightDp = 640)
@Composable
fun DarkPreviewHome() {
    MyTheme(darkTheme = true) {
        Home()
    }
}