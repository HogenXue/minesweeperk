package com.kotlearn.minesweeperk.feature.play

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.test.ExperimentalTestApi
import androidx.compose.ui.test.assertCountEquals
import androidx.compose.ui.test.onAllNodesWithTag
import androidx.compose.ui.test.runComposeUiTest
import kotlin.math.abs
import kotlin.random.Random
import kotlin.test.Test
import kotlin.test.assertTrue

class MinesweeperBoardTest {


    @OptIn(ExperimentalTestApi::class)
    @Test
    fun correctNumberOfTilesAreShown() = runComposeUiTest {
        val random = Random(1)

        val testCases = listOf(
            Pair(getRandomTileState(with = 0, height = 0, random = random), 0),
            Pair(getRandomTileState(with = 10, height = 10, random = random), 10 * 10),
            Pair(getRandomTileState(with = 30, height = 16, random = random), 30 * 16),
        )

        var tileStates: List<List<TileState>> by mutableStateOf(emptyList())

        setContent {
            MinesweeperBoard(
                tileStates = tileStates,
                modifier = Modifier.fillMaxSize()
            )
        }

        for (testCase in testCases) {
            tileStates = testCase.first
            waitForIdle()
            onAllNodesWithTag("tile").assertCountEquals(testCase.second)
        }
    }

    @OptIn(ExperimentalTestApi::class)
    @Test
    fun allTilesAreRoughlySquare() = runComposeUiTest {
        val random = Random(1)
        val firstTitleState = getRandomTileState(with = 10, height = 10, random = random)
        val secondTileState = getRandomTileState(with = 30, height = 16, random = random)
        var tileStates: List<List<TileState>> by mutableStateOf(firstTitleState)

        setContent {
            MinesweeperBoard(
                tileStates = tileStates,
                modifier = Modifier.fillMaxSize()
            )
        }

        fun testTileSizesAreEqual() {
            val tileSemanticsNode = onAllNodesWithTag("tile").fetchSemanticsNodes()
            tileSemanticsNode.forEach {
                assertTrue(message = "${it.size.width} width does not equal ${it.size.height} height") {
                    abs(it.size.width - it.size.height) <= 1
                }
            }
            testTileSizesAreEqual()
            tileStates = secondTileState
            waitForIdle()
            testTileSizesAreEqual()
        }
    }

    private fun getRandomTileState(with: Int, height: Int, random: Random): List<List<TileState>> {
        val allTitleStates = getAllPossibleTileStates()
        return buildList {
            for (x in 0 until with) {
                add(
                    buildList {
                        for (y in 0 until height) {
                            add(allTitleStates.random(random))
                        }
                    }
                )
            }
        }
    }

    private fun getAllPossibleTileStates() = setOf(
        TileState.Hidden(flagged = false),
        TileState.Hidden(flagged = true),
        TileState.Revealed.Mine,
        TileState.Revealed.Number(value = null),
        TileState.Revealed.Number(value = 1),
        TileState.Revealed.Number(value = 2),
        TileState.Revealed.Number(value = 3),
        TileState.Revealed.Number(value = 4),
        TileState.Revealed.Number(value = 5),
        TileState.Revealed.Number(value = 6),
        TileState.Revealed.Number(value = 7),
        TileState.Revealed.Number(value = 8),
    )
}