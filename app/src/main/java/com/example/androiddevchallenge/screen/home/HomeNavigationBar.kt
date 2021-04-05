package com.example.androiddevchallenge.screen.home

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import com.example.androiddevchallenge.R

@Composable
fun HomeNavigationBar() {
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