package com.example.androiddevchallenge.screen.home

import androidx.annotation.DrawableRes
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.androiddevchallenge.R


class HomeViewModel : ViewModel() {

    private val _themes = MutableLiveData(decorationThemes)
    val themes: LiveData<List<DecorationThemeModel>> = _themes

    private val _plants = MutableLiveData(designs)
    val plants: LiveData<List<PlantTypeModel>> = _plants

    private val _searchInput = MutableLiveData("")
    val searchInput: LiveData<String> = _searchInput

    fun searchInputChanged(it: String) {
        _searchInput.value = it
    }
}

data class DecorationThemeModel(
    val title: String,
    @DrawableRes val image: Int
)

val decorationThemes = listOf(
    DecorationThemeModel(
        title = "Desert chic",
        image = R.drawable.desert_chic
    ),
    DecorationThemeModel(
        title = "Tiny Terrariums",
        image = R.drawable.little_terrariums
    ),
    DecorationThemeModel(
        title = "Jungle vibes",
        image = R.drawable.jungle_vibes
    ),
    DecorationThemeModel(
        title = "Easy care",
        image = R.drawable.easy_care
    ),
    DecorationThemeModel(
        title = "Statements",
        image = R.drawable.statements
    )
)

data class PlantTypeModel(
    val title: String,
    @DrawableRes val image: Int,
    val selected: Boolean = false
)

val designs = listOf(
    PlantTypeModel(
        title = "Monstera",
        image = R.drawable.monstera,
        selected = true
    ),
    PlantTypeModel(
        title = "Aglaonema",
        image = R.drawable.agloaonema
    ),
    PlantTypeModel(
        title = "Peace lily",
        image = R.drawable.peace_lily
    ),
    PlantTypeModel(
        title = "Fiddle leaf tree",
        image = R.drawable.fiddle_leaf
    ),
    PlantTypeModel(
        title = "Easy care",
        image = R.drawable.easy_care
    ),
    PlantTypeModel(
        title = "Statements",
        image = R.drawable.statements
    ),
)
