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
package com.example.androiddevchallenge

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.navigate
import androidx.navigation.compose.rememberNavController
import com.example.androiddevchallenge.screen.Welcome
import com.example.androiddevchallenge.screen.home.Home
import com.example.androiddevchallenge.screen.register.SignUp
import com.example.androiddevchallenge.ui.theme.MyTheme


sealed class Screen(val route: String) {
    object Welcome : Screen("onboarding")
    object Home : Screen("home")
    object SignUp : Screen("sign-up")
}

interface Navigator {
    fun navigate(screen: Screen)
}

class NavigatorImp(private val navController: NavController) : Navigator {
    override fun navigate(screen: Screen) = navController.navigate(screen.route)
}

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        setContent {
//            WindowCompat.setDecorFitsSystemWindows(window, false)

            val navController = rememberNavController()

            val navigator: Navigator = NavigatorImp(navController)

            MyTheme {
                NavHost(navController, startDestination = Screen.Welcome.route) {

                    composable(Screen.Welcome.route) { Welcome(navigator) }
                    composable(Screen.Home.route) { Home(navigator) }
                    composable(Screen.SignUp.route) { SignUp(navigator) }

                }

            }
        }
    }
}





