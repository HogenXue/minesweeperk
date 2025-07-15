package com.kotlearn.minesweeperk.feature.highscores

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import kotlinx.serialization.Serializable
import org.koin.compose.viewmodel.koinViewModel

@Serializable
data object HighScore

fun NavGraphBuilder.highScoresRoutes(){
    composable<HighScore> {
        HighScoreScreen(
            modifier = Modifier.fillMaxSize(),
            viewModel = koinViewModel()
        )
    }
}