package state_management

import androidx.compose.runtime.*

data class GameTableStateKeeper(
    val whoTurn: MutableState<String>,
    val gameTableGrid: MutableList<MutableList<Pair<String, String>>>
)

@Composable
fun InitGameTableStates(): GameTableStateKeeper {
    val gameTableStateKeeper = GameTableStateKeeper(whoTurn = remember { mutableStateOf("O") },
        gameTableGrid = remember {
            mutableStateListOf(
                mutableStateListOf(
                    Pair("", "bottomRight"), Pair("", "bottom"), Pair("", "bottomLeft")
                ), mutableStateListOf(
                    Pair("", "right"), Pair("", ""), Pair("", "left")
                ), mutableStateListOf(
                    Pair("", "upperRight"), Pair("", "upper"), Pair("", "upperLeft")
                )
            )
        })

    return gameTableStateKeeper
}