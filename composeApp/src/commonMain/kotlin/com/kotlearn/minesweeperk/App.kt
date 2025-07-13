package com.kotlearn.minesweeperk


import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.kotlearn.minesweeperk.feature.menu.MenuScreen
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.ui.tooling.preview.Preview

@Composable
@Preview
fun App() {
    MaterialTheme {
        MenuScreen(
            goToPlay = {},
            goToSettings = {},
            goToHighScores = {},
            modifier = Modifier.fillMaxSize()
        )
    }
}