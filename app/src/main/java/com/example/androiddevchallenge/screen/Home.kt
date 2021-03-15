package com.example.androiddevchallenge.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.ScrollState
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.Dimension
import com.example.androiddevchallenge.R
import com.example.androiddevchallenge.ui.theme.MyTheme

data class Theme(
    val title: String,
    val image: Int,
    val selected: Boolean = false
)

val themes = listOf(
    Theme(
        title = "Desert chic",
        image = R.drawable.desert_chic
    ),
    Theme(
        title = "Tiny Terrariums",
        image = R.drawable.little_terrariums
    ),
    Theme(
        title = "Jungle vibes",
        image = R.drawable.jungle_vibes
    ),
    Theme(
        title = "Easy care",
        image = R.drawable.easy_care
    ),
    Theme(
        title = "Statements",
        image = R.drawable.statements
    )
)


val designs = listOf(
    Theme(
        title = "Monstera",
        image = R.drawable.monstera,
        selected = true
    ),
    Theme(
        title = "Aglaonema",
        image = R.drawable.agloaonema
    ),
    Theme(
        title = "Peace lily",
        image = R.drawable.peace_lily
    ),
    Theme(
        title = "Fiddle leaf tree",
        image = R.drawable.fiddle_leaf
    ),
    Theme(
        title = "Easy care",
        image = R.drawable.easy_care
    ),
    Theme(
        title = "Statements",
        image = R.drawable.statements
    ),
)

@Composable
fun NavBar() {
    BottomNavigation(
        backgroundColor = MaterialTheme.colors.primary,
        modifier = Modifier.fillMaxWidth()
    ) {

        BottomNavigationItem(
            icon = {
                Icon(
                    imageVector = ImageVector.vectorResource(id = R.drawable.home),
                    contentDescription = ""
                )
            },
            label = { Text("Home") },
            selected = true,
            onClick = {}

        )
        BottomNavigationItem(
            icon = {
                Icon(
                    imageVector = ImageVector.vectorResource(id = R.drawable.favorite_border),
                    contentDescription = ""
                )
            },
            label = { Text("Favorite") },
            selected = false,
            onClick = {}

        )
        BottomNavigationItem(
            icon = {
                Icon(
                    imageVector = ImageVector.vectorResource(id = R.drawable.account_circle),
                    contentDescription = ""
                )
            },
            label = { Text("Profile") },
            selected = false,
            onClick = {}

        )
        BottomNavigationItem(
            icon = {
                Icon(
                    imageVector = ImageVector.vectorResource(id = R.drawable.shopping_cart),
                    contentDescription = ""
                )
            },
            label = { Text("Cart") },
            selected = false,
            onClick = {}

        )
    }

}

@Composable
fun Home() {
    Scaffold(
        bottomBar = {
            NavBar()
        },
    ) {
        Column(
            modifier = Modifier
                .verticalScroll(ScrollState(0))
                .fillMaxWidth()
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
                    Image(
                        imageVector = ImageVector.vectorResource(id = R.drawable.search),
                        contentDescription = "Search",
                        modifier = Modifier.size(18.dp),
                        colorFilter = ColorFilter.tint(MaterialTheme.colors.onBackground)
                    )
                },
                placeholder = {
                    Text(
                        "Search",
                        style = MaterialTheme.typography.body1,
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(18.dp)
                    )
                },
                singleLine = true,
                onValueChange = {},

                modifier = Modifier
                    .height(56.dp)
                    .padding(16.dp, 0.dp)
                    .fillMaxWidth()
            )

            Text(
                text = "Browse themes",
                style = MaterialTheme.typography.h1,
                color = MaterialTheme.colors.onBackground,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 16.dp, top = 24.dp, bottom = 16.dp)
            )

            LazyRow(
                contentPadding = PaddingValues(start = 16.dp, end = 16.dp),
                modifier = Modifier.fillMaxWidth()
            ) {
                items(themes) { item ->
                    PlantThemeTab(
                        title = item.title,
                        thumbnail = painterResource(id = item.image),
                        modifier = Modifier.padding(end = 8.dp)
                    )
                }

            }

            Text(
                text = "Design your home garden",
                style = MaterialTheme.typography.h1,
                color = MaterialTheme.colors.onBackground,
                modifier = Modifier.padding(start = 16.dp, top = 24.dp, bottom = 16.dp)
            )

            Column(
                Modifier
                    .fillMaxWidth()
                    .padding(16.dp, 0.dp)
            ) {
                designs.forEach {
                    PlanListItem(title = it.title, thumbnail = it.image, isSelected = it.selected)
                    Spacer(modifier = Modifier.height(8.dp))
                }
            }
        }
    }
}


@Composable
fun PlantThemeTab(
    title: String,
    thumbnail: Painter,
    modifier: Modifier = Modifier
) {
    Card(
        elevation = 1.dp,
        shape = MaterialTheme.shapes.small,
        modifier = modifier
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
    thumbnail: Int,
    isSelected: Boolean = false
) {

    ConstraintLayout(
        modifier = Modifier
            .fillMaxWidth()
            .height(64.dp)
    ) {

        val (imageView, titleView, descriptionView, checkboxView, dividerView) = createRefs()

        Image(
            painter = painterResource(thumbnail),
            contentDescription = title,
            modifier = Modifier
                .width(64.dp)
                .height(64.dp)
                .clip(MaterialTheme.shapes.small)
                .constrainAs(imageView) {
                    top.linkTo(parent.top)
                    start.linkTo(parent.start)
                }


        )

        Text(
            text = title,
            style = MaterialTheme.typography.h2,
            color = MaterialTheme.colors.onBackground,
            modifier = Modifier
                .paddingFromBaseline(top = 24.dp)
                .padding(start = 16.dp)
                .constrainAs(titleView) {
                    top.linkTo(parent.top)
                    start.linkTo(imageView.end)
                    end.linkTo(checkboxView.start)
                    width = Dimension.fillToConstraints
                }
        )
        Text(
            text = description,
            style = MaterialTheme.typography.body1,
            color = MaterialTheme.colors.onBackground,
            modifier = Modifier
                .padding(start = 16.dp)
                .constrainAs(descriptionView) {
                    top.linkTo(titleView.bottom)
                    end.linkTo(checkboxView.start)
                    start.linkTo(imageView.end)
                    width = Dimension.fillToConstraints
                }
        )

        Checkbox(
            checked = isSelected,
            onCheckedChange = { /*TODO*/ },
            modifier = Modifier
                .padding(bottom = 24.dp)
                .constrainAs(checkboxView) {
                    bottom.linkTo(parent.bottom)
                    end.linkTo(parent.end)
                })

        Divider(
            modifier = Modifier
                .height(1.dp)
                .padding(start = 8.dp)
                .fillMaxWidth()
                .constrainAs(dividerView) {
                    start.linkTo(imageView.end)
                    bottom.linkTo(parent.bottom)
                    width = Dimension.fillToConstraints
                }
        )

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