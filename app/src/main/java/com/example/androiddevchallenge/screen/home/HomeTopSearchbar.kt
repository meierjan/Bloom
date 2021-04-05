package com.example.androiddevchallenge.screen.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.unit.dp
import com.example.androiddevchallenge.R

@Composable
fun HomeTopSearchbar(viewModel: HomeViewModel, modifier: Modifier = Modifier) {

    val searchInputState = viewModel.searchInput
        .observeAsState("")

    OutlinedTextField(
        value = searchInputState.value,
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
        onValueChange = { viewModel.searchInputChanged(it)  },
        modifier = modifier
            .height(56.dp)
            .padding(16.dp, 0.dp)
            .fillMaxWidth()
    )

}