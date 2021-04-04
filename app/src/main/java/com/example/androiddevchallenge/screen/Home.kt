package com.example.androiddevchallenge.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
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
            icon = { Icon(ImageVector.vectorResource(R.drawable.home), "Home") },
            label = { Text("Home") },
            selected = true,
            onClick = {}

        )
        BottomNavigationItem(
            icon = { Icon(ImageVector.vectorResource(R.drawable.favorite_border), "Favorite") },
            label = { Text("Favorite") },
            selected = false,
            onClick = {}

        )
        BottomNavigationItem(
            icon = { Icon(ImageVector.vectorResource(R.drawable.account_circle), "Profile") },
            label = { Text("Profile") },
            selected = false,
            onClick = {}

        )
        BottomNavigationItem(
            icon = { Icon(ImageVector.vectorResource(R.drawable.shopping_cart), "Cart") },
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
        modifier = Modifier.fillMaxWidth()
    ) {
        Column(
            modifier = Modifier
                .verticalScroll(rememberScrollState())
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
                placeholder = {
                    Row(Modifier.fillMaxWidth()) {
                        Image(
                            imageVector = ImageVector.vectorResource(id = R.drawable.search),
                            contentDescription = "Search",
                            modifier = Modifier.size(18.dp),
                            colorFilter = ColorFilter.tint(MaterialTheme.colors.onBackground)
                        )
                        Text(
                            "Search",
                            style = MaterialTheme.typography.body1,
                            modifier = Modifier
                                .padding(start = 6.dp)
                                .fillMaxWidth()
                        )
                    }
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
                    PlantThemeTab(
                        title = item.title,
                        thumbnail = painterResource(id = item.image)
                    )
                }

            }

            ConstraintLayout(
                Modifier
                    .paddingFromBaseline(top = 32.dp, bottom = 16.dp)
                    .padding(start = 16.dp, end = 16.dp)
                    .fillMaxWidth()
            ) {

                val (textView, iconView) = createRefs()

                Text(
                    text = "Design your home garden",
                    style = MaterialTheme.typography.h1,
                    modifier = Modifier
                        .constrainAs(textView) {
                            start.linkTo(parent.start)
                            top.linkTo(parent.top)
                            bottom.linkTo(parent.bottom)
                            end.linkTo(iconView.start)
                            // bottom to parent.bottom
                            width = Dimension.fillToConstraints

                        }

                )
                Icon(
                    imageVector = ImageVector.vectorResource(id = R.drawable.filter_list),
                    contentDescription = "Filter",
                    modifier = Modifier
                        .size(24.dp)
                        .constrainAs(iconView) {
                            end.linkTo(parent.end)
                            top.linkTo(textView.top)
                            bottom.linkTo(textView.bottom)
                        }
                )
            }

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
            colors = CheckboxDefaults.colors(checkmarkColor = MaterialTheme.colors.background),
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

@Preview("Dark Theme")
@Composable
fun LightPreviewPlantThemeTab() {
    MyTheme(darkTheme = false) {
        PlantThemeTab("blah", painterResource(R.drawable.monstera))
    }
}

@Preview("Light Theme")
@Composable
fun DarkPreviewPlantThemeTab() {
    MyTheme(darkTheme = true) {
        PlantThemeTab("blah", painterResource(R.drawable.monstera))
    }
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