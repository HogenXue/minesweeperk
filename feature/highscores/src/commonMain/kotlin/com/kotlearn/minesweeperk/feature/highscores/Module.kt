package com.kotlearn.minesweeperk.feature.highscores

import com.kotlearn.minesweeperk.domain.game.domainGameModule
import org.koin.dsl.module

val featureHighScoreModule = module {
    includes(domainGameModule)
}