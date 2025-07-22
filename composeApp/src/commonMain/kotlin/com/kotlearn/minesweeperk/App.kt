package com.kotlearn.minesweeperk


import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import com.kotlearn.minesweeperk.feature.highscores.HighScore
import com.kotlearn.minesweeperk.feature.highscores.highScoresRoutes
import com.kotlearn.minesweeperk.feature.menu.Menu
import com.kotlearn.minesweeperk.feature.menu.menuRoutes
import com.kotlearn.minesweeperk.feature.settings.Settings
import com.kotlearn.minesweeperk.feature.settings.settingsRoutes
import com.kotlearn.minesweeperk.ui.core.Dimensions
import com.kotlearn.minesweeperk.ui.core.LocalDimensions
import com.kotlearn.minesweeperk.ui.core.LocalPadding
import com.kotlearn.minesweeperk.ui.core.Padding
import org.jetbrains.compose.ui.tooling.preview.Preview
import org.koin.compose.KoinApplication
import org.koin.core.module.Module

@Composable
@Preview
fun App(platformModule: Module = Module()) {
    KoinApplication(
        application = {
            modules(appModule,platformModule)
        }
    ){
        CompositionLocalProvider(
            LocalPadding provides Padding(
                normal = 0.dp
            ),
            LocalDimensions provides Dimensions(
                maxWidthSmall = 250.dp
            )
        ){
            MaterialTheme {
                val navController = rememberNavController()

                NavHost(
                    navController = navController,
                    startDestination = Menu,
                ){
                    menuRoutes(
                        goToPlay = {},
                        goToSettings = {
                            navController.navigate(Settings)
                        },
                        goToHighScores = {
                            navController.navigate(HighScore)
                        }
                    )
                    highScoresRoutes()
//                playRoutes()
                    settingsRoutes()
                }
            }
        }
    }

}