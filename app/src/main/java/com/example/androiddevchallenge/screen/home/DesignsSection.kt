package com.example.androiddevchallenge.screen.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.Dimension
import com.example.androiddevchallenge.R

@Composable
fun DesignsSection(viewModel: HomeViewModel, modifier: Modifier = Modifier) {

    val designsState = viewModel.plants.observeAsState(emptyList())
    val designs = designsState.value

    ConstraintLayout(
        modifier
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
            DesignSectionListItem(title = it.title, thumbnail = it.image, isSelected = it.selected)
            Spacer(modifier = Modifier.height(8.dp))
        }
    }
}

@Composable
fun DesignSectionListItem(
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