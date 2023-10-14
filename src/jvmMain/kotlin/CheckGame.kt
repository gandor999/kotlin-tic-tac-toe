import androidx.compose.runtime.Composable
import state_management.GameTableStateKeeper

fun <T, R> isAllInThese(someArray: List<T>, someItem: R): Boolean {
    for (item in someArray) {
        if (item != someItem) {
            return false
        }
    }

    return true
}

@Composable
fun CheckGame(gameTableStateKeeper: GameTableStateKeeper) {
    val gameTableGrid = gameTableStateKeeper.gameTableGrid

    if (isAllInThese(
            listOf(
                gameTableGrid[0][0].first, gameTableGrid[0][1].first, gameTableGrid[0][2].first
            ), "O"
        ) || isAllInThese(
            listOf(
                gameTableGrid[1][0].first, gameTableGrid[1][1].first, gameTableGrid[1][2].first
            ), "O"
        ) || isAllInThese(
            listOf(
                gameTableGrid[2][0].first, gameTableGrid[2][1].first, gameTableGrid[2][2].first
            ), "O"
        ) || isAllInThese(
            listOf(
                gameTableGrid[0][0].first, gameTableGrid[1][0].first, gameTableGrid[2][0].first
            ), "O"
        ) || isAllInThese(
            listOf(
                gameTableGrid[0][2].first, gameTableGrid[1][2].first, gameTableGrid[2][2].first
            ), "O"
        ) || isAllInThese(
            listOf(
                gameTableGrid[0][1].first, gameTableGrid[1][1].first, gameTableGrid[2][1].first
            ), "O"
        ) || isAllInThese(
            listOf(
                gameTableGrid[0][0].first, gameTableGrid[1][1].first, gameTableGrid[2][2].first
            ), "O"
        ) || isAllInThese(
            listOf(
                gameTableGrid[0][2].first, gameTableGrid[1][1].first, gameTableGrid[2][0].first
            ), "O"
        )
    ) {
        println("O wins!")
    }

    if (isAllInThese(
            listOf(
                gameTableGrid[0][0].first, gameTableGrid[0][1].first, gameTableGrid[0][2].first
            ), "X"
        ) || isAllInThese(
            listOf(
                gameTableGrid[1][0].first, gameTableGrid[1][1].first, gameTableGrid[1][2].first
            ), "X"
        ) || isAllInThese(
            listOf(
                gameTableGrid[2][0].first, gameTableGrid[2][1].first, gameTableGrid[2][2].first
            ), "X"
        ) || isAllInThese(
            listOf(
                gameTableGrid[0][0].first, gameTableGrid[1][0].first, gameTableGrid[2][0].first
            ), "X"
        ) || isAllInThese(
            listOf(
                gameTableGrid[0][2].first, gameTableGrid[1][2].first, gameTableGrid[2][2].first
            ), "X"
        ) || isAllInThese(
            listOf(
                gameTableGrid[0][1].first, gameTableGrid[1][1].first, gameTableGrid[2][1].first
            ), "X"
        ) || isAllInThese(
            listOf(
                gameTableGrid[0][0].first, gameTableGrid[1][1].first, gameTableGrid[2][2].first
            ), "X"
        ) || isAllInThese(
            listOf(
                gameTableGrid[0][2].first, gameTableGrid[1][1].first, gameTableGrid[2][0].first
            ), "X"
        )
    ) {
        println("X wins!")
    }
}