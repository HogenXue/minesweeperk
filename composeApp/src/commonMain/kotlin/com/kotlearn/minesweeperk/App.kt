package com.kotlearn.minesweeperk


import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import com.kotlearn.minesweeperk.feature.highscores.HighScoreScreen
import com.kotlearn.minesweeperk.feature.highscores.HighscoresViewModel
import com.kotlearn.minesweeperk.feature.highscores.highScoresRoute
import com.kotlearn.minesweeperk.feature.menu.Menu
import com.kotlearn.minesweeperk.feature.menu.menuRoutes
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.ui.tooling.preview.Preview
import org.koin.compose.KoinApplication
import org.koin.compose.viewmodel.koinViewModel
import org.koin.core.module.Module
import org.koin.dsl.koinApplication
import org.koin.dsl.module

@Composable
@Preview
fun App(platformModule: Module = Module()) {
    KoinApplication(
        application = {
            modules(appModule,platformModule)
        }
    ){
        MaterialTheme {
            val navController = rememberNavController()

            NavHost(
                navController = navController,
                startDestination = Menu,
            ){
                menuRoutes(
                    goToPlay = {},
                    goToSettings = {},
                    goToHighScores = {}
                )
                highScoresRoute()
//                playRoutes()
//                settingRoutes()
            }
        }
    }

}