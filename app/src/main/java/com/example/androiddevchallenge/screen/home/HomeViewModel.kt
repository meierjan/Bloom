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

    fun onDesignItemSelectionChanged(item: PlantTypeModel, isSelected: Boolean) {
        val newList = _plants.value?.map {
            if (item.id == it.id) {
                it.copy(selected = isSelected)
            } else {
                it
            }
        }

        _plants.value = newList
    }
}

data class DecorationThemeModel(
    val id: Long,
    val title: String,
    @DrawableRes val image: Int
)

val decorationThemes = listOf(
    DecorationThemeModel(
        id = 1,
        title = "Desert chic",
        image = R.drawable.desert_chic
    ),
    DecorationThemeModel(
        id = 2,
        title = "Tiny Terrariums",
        image = R.drawable.little_terrariums
    ),
    DecorationThemeModel(
        id = 3,
        title = "Jungle vibes",
        image = R.drawable.jungle_vibes
    ),
    DecorationThemeModel(
        id = 4,
        title = "Easy care",
        image = R.drawable.easy_care
    ),
    DecorationThemeModel(
        id = 5,
        title = "Statements",
        image = R.drawable.statements
    )
)

data class PlantTypeModel(
    val id: Long,
    val title: String,
    @DrawableRes val image: Int,
    val description: String = "This is a description",
    val selected: Boolean = false
)

fun PlantTypeModel.matchesSearch(search: String): Boolean =
    title.contains(search, ignoreCase = true) or
            description.contains(search, ignoreCase = true)


val designs = listOf(
    PlantTypeModel(
        id = 1,
        title = "Monstera",
        image = R.drawable.monstera,
        selected = true
    ),
    PlantTypeModel(
        id = 2,
        title = "Aglaonema",
        image = R.drawable.agloaonema
    ),
    PlantTypeModel(
        id = 3,
        title = "Peace lily",
        image = R.drawable.peace_lily
    ),
    PlantTypeModel(
        id = 4,
        title = "Fiddle leaf tree",
        image = R.drawable.fiddle_leaf
    ),
    PlantTypeModel(
        id = 5,
        title = "Easy care",
        image = R.drawable.easy_care
    ),
    PlantTypeModel(
        id = 6,
        title = "Statements",
        image = R.drawable.statements
    ),
)
