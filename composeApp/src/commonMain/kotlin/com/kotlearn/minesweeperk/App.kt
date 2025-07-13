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
import org.koin.compose.KoinApplication
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
            MenuScreen(
                goToPlay = {},
                goToSettings = {},
                goToHighScores = {},
                modifier = Modifier.fillMaxSize()
            )
        }
    }

}