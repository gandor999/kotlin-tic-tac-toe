package god_functions

import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import state_management.GameTableStateKeeper

@Composable
fun ResetGame(
    gameTableStateKeeper: GameTableStateKeeper
) {
    gameTableStateKeeper.gameTableGrid[0] = mutableStateListOf(
        Pair("", "bottomRight"), Pair("", "bottom"), Pair("", "bottomLeft")
    )
    gameTableStateKeeper.gameTableGrid[1] = mutableStateListOf(
        Pair("", "right"), Pair("", ""), Pair("", "left")
    )
    gameTableStateKeeper.gameTableGrid[2] = mutableStateListOf(
        Pair("", "upperRight"), Pair("", "upper"), Pair("", "upperLeft")
    )

    gameTableStateKeeper.resetButtonIsClicked.value = !gameTableStateKeeper.resetButtonIsClicked.value
}