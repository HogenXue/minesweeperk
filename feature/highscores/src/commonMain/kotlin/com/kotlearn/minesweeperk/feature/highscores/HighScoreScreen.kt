package com.kotlearn.minesweeperk.feature.highscores

import androidx.compose.foundation.layout.Box
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier

@Composable
fun HighScoreScreen(
    modifier: Modifier,
    viewModel: HighscoresViewModel

){
    Box(
        modifier = modifier,
        contentAlignment = Alignment.Center
    ){
        Text(text = viewModel.title)
    }
}