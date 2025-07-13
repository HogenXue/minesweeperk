package com.kotlearn.minesweeperk

import com.kotlearn.minesweeperk.feature.highscores.featureHighScoreModule
import com.kotlearn.minesweeperk.feature.menu.featureMenuModule
import com.kotlearn.minesweeperk.feature.play.featurePlayModule
import com.kotlearn.minesweeperk.feature.settings.featureSettingsModule
import org.koin.dsl.module

val appModule = module {
    includes(
        featureHighScoreModule,
        featureSettingsModule,
        featureMenuModule,
        featurePlayModule)
}