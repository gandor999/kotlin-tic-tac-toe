// Copyright 2000-2021 JetBrains s.r.o. and contributors. Use of this source code is governed by the Apache 2.0 license that can be found in the LICENSE file.
import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import god_functions.ResetGame
import state_management.GameTableStateKeeper
import state_management.InitGameTableStates

val constants = Constants()

@Composable
fun TableCell(
    text: String,
    modifier: Modifier = Modifier,
    borderCorner: String = "",
    cellSize: Dp = 0.dp,
    cellBorderSize: Dp = 0.dp
) {
    val borderSize = with(LocalDensity.current) { cellBorderSize.toPx() }

    val pxTableCellSizeHeight = with(LocalDensity.current) { cellSize.toPx() }
    val pxTableCellSizeWidth = with(LocalDensity.current) { cellSize.toPx() }

    Box(
        modifier = modifier
    ) {
        Box(contentAlignment = Alignment.Center,
            modifier = Modifier.clip(shape = RectangleShape).size(cellSize).drawBehind {
                drawBorderController(
                    borderCorner = borderCorner,
                    CommonArgsForBorderDrawing = CommonArgsForBorderDrawing(
                        this, borderSize, pxTableCellSizeHeight, pxTableCellSizeWidth, Color.Black
                    )
                )
            }) {
            Text(
                text = text,
                textAlign = TextAlign.Center,
                fontSize = 40.sp,
                color = if (text == "O") Color(
                    red = 34, green = 174, blue = 209
                ) else Color(red = 249, green = 87, blue = 56),
            )
        }
    }
}

@Composable
fun GameTable(
    modifier: Modifier = Modifier,
    verticalArrangement: Arrangement.Vertical = Arrangement.Top,
    horizontalAlignment: Alignment.Horizontal = Alignment.Start,
    cellSize: Dp = 0.dp,
    cellBorderSize: Dp = 8.dp,
    gameTableStateKeeper: GameTableStateKeeper
) {
    val (whoTurn, gameTableGrid) = gameTableStateKeeper

    Column(
        modifier = modifier,
        verticalArrangement = verticalArrangement,
        horizontalAlignment = horizontalAlignment
    ) {
        for ((i, gameTableRow) in gameTableGrid.withIndex()) {
            Row(
                horizontalArrangement = Arrangement.Center,
            ) {
                for ((j, gameTableCell) in gameTableRow.withIndex()) {
                    val (insignia, borderCorner) = gameTableCell
                    TableCell(
                        text = insignia,
                        modifier = constants.modifyPointerToHandOnHover.clickable {
                            if (insignia == "") {
                                gameTableGrid[i][j] = Pair(
                                    if (gameTableStateKeeper.whoTurn.value == "O") "O" else "X",
                                    borderCorner
                                )
                                whoTurn.value = if (whoTurn.value == "O") "X" else "O"
                            }
                        },
                        borderCorner = borderCorner,
                        cellSize = cellSize,
                        cellBorderSize = cellBorderSize
                    )
                }
            }
        }
    }
}


@Composable
@Preview
fun App() { //TODO: make a coin toss next time to determine who goes first
    //TODO: let the coin toss be in another page
    //TODO: go to a new page when a the game ends the round then let the loser be new one to first make move or not
    //TODO: let the loser decide what they want to be next
    //TODO: have more than one round
    //TODO: make a menu where the players can put their names in and configure how many rounds

    val gameTableStateKeeper = InitGameTableStates()

    MaterialTheme {
        Column(
            modifier = Modifier.fillMaxSize().padding(20.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            GameTable(
                modifier = Modifier.padding(20.dp).size(300.dp),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally,
                cellSize = 80.dp,
                cellBorderSize = 8.dp,
                gameTableStateKeeper = gameTableStateKeeper
            )

            Button(
                onClick = {
                    gameTableStateKeeper.resetButtonIsClicked.value = !gameTableStateKeeper.resetButtonIsClicked.value
                }, modifier = constants.modifyPointerToHandOnHover
            ) {
                Text(
                    text = "Reset"
                )
            }
        }
    }

    if (gameTableStateKeeper.resetButtonIsClicked.value) {
        ResetGame(gameTableStateKeeper)
    }

    CheckGame(gameTableStateKeeper)
}

fun main() = application {
    Window(onCloseRequest = ::exitApplication) {
        App()
    }
}
