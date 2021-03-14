/*
 * Copyright 2021 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.example.androiddevchallenge.ui.theme

import androidx.compose.material.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.example.androiddevchallenge.R


private val nunitoFOntFamily = FontFamily(
    fonts = listOf(
        Font(
            resId = R.font.nunitosans_light,
            weight = FontWeight.W200,
            style = FontStyle.Normal
        ),
        Font(
            resId = R.font.nunitosans_regular,
            weight = FontWeight.W400,
            style = FontStyle.Normal
        ),
        Font(
            resId = R.font.nunitosans_semibold,
            weight = FontWeight.W600,
            style = FontStyle.Normal
        ),
        Font(
            resId = R.font.nunitosans_bold,
            weight = FontWeight.W800,
            style = FontStyle.Normal
        ),
    )
)

// Set of Material typography styles to start with
val typography = Typography(
    h1 = TextStyle(
        fontFamily = nunitoFOntFamily,
        fontWeight = FontWeight.Bold,
        fontSize = 18.sp
    ),
    h2 = TextStyle(
        fontFamily = nunitoFOntFamily,
        fontWeight = FontWeight.Bold,
        fontSize = 14.sp
    ),
    subtitle1 = TextStyle(
        fontFamily = nunitoFOntFamily,
        fontWeight = FontWeight.Light,
        fontSize = 16.sp
    ),
    body1 = TextStyle(
        fontFamily = nunitoFOntFamily,
        fontWeight = FontWeight.Light,
        fontSize = 14.sp
    ),
    body2 = TextStyle(
        fontFamily = nunitoFOntFamily,
        fontSize = 12.sp,
        fontWeight = FontWeight.Light
    ),
    button = TextStyle(
        fontFamily = nunitoFOntFamily,
        fontWeight = FontWeight.SemiBold,
        letterSpacing = 1.sp,
        fontSize = 14.sp
    ),
    caption = TextStyle(
        fontFamily = nunitoFOntFamily,
        fontWeight = FontWeight.SemiBold,
        fontSize = 12.sp
    )

)
