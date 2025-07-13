package com.kotlearn.minesweeperk.feature.settings

import com.kotlearn.minesweeperk.domain.settings.domainSettingsModule
import org.koin.dsl.module

val featureSettingsModule = module {
    domainSettingsModule
}