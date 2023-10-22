import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.drawscope.DrawScope

data class CommonArgsForBorderDrawing(
    val drawScope: DrawScope,
    val borderSize: Float,
    val pxTableCellSizeHeight: Float,
    val pxTableCellSizeWidth: Float,
    val color: Color,
)

fun drawBottomBorder(
    CommonArgsForBorderDrawing: CommonArgsForBorderDrawing
) {
    val (drawScope, borderSize, pxTableCellSizeHeight, pxTableCellSizeWidth, color) = CommonArgsForBorderDrawing

    drawScope.drawLine(
        color = color,
        start = Offset(0f, pxTableCellSizeHeight),
        end = Offset(pxTableCellSizeWidth, pxTableCellSizeHeight),
        strokeWidth = borderSize
    )
}

fun drawRightBorder(
    CommonArgsForBorderDrawing: CommonArgsForBorderDrawing
) {
    val (drawScope, borderSize, pxTableCellSizeHeight, pxTableCellSizeWidth, color) = CommonArgsForBorderDrawing

    drawScope.drawLine(
        color = color,
        start = Offset(pxTableCellSizeWidth, 0f),
        end = Offset(pxTableCellSizeWidth, pxTableCellSizeHeight),
        strokeWidth = borderSize
    )
}

fun drawLeftBorder(
    CommonArgsForBorderDrawing: CommonArgsForBorderDrawing
) {
    val (drawScope, borderSize, pxTableCellSizeHeight, pxTableCellSizeWidth, color) = CommonArgsForBorderDrawing

    drawScope.drawLine(
        color = color,
        start = Offset(0f, 0f),
        end = Offset(0f, pxTableCellSizeHeight),
        strokeWidth = borderSize
    )
}

fun drawUpperBorder(
    CommonArgsForBorderDrawing: CommonArgsForBorderDrawing
) {
    val (drawScope, borderSize, pxTableCellSizeHeight, pxTableCellSizeWidth, color) = CommonArgsForBorderDrawing

    drawScope.drawLine(
        color = color,
        start = Offset(0f, 0f),
        end = Offset(pxTableCellSizeWidth, 0f),
        strokeWidth = borderSize
    )
}

data class DrawBorderControllerClass(
    val commonArgsForBorderDrawing: CommonArgsForBorderDrawing,
    val strategies: HashMap<String, () -> Unit> = hashMapOf(
        "bottomRight" to {
            drawBottomBorder(
                commonArgsForBorderDrawing
            )
            drawRightBorder(
                commonArgsForBorderDrawing
            )
        },

        "bottomLeft" to {
            drawBottomBorder(
                commonArgsForBorderDrawing
            )
            drawLeftBorder(
                commonArgsForBorderDrawing
            )
        },

        "upperRight" to {
            drawUpperBorder(
                commonArgsForBorderDrawing
            )
            drawRightBorder(
                commonArgsForBorderDrawing
            )
        },

        "upperLeft" to {
            drawUpperBorder(
                commonArgsForBorderDrawing
            )
            drawLeftBorder(
                commonArgsForBorderDrawing
            )
        },

        "upper" to {
            drawUpperBorder(
                commonArgsForBorderDrawing
            )
        },

        "bottom" to {
            drawBottomBorder(
                commonArgsForBorderDrawing
            )
        },

        "right" to {
            drawRightBorder(
                commonArgsForBorderDrawing
            )
        },

        "left" to {
            drawLeftBorder(
                commonArgsForBorderDrawing
            )
        },

        "allSides" to {
            val temp = listOf("bottom", "upper", "right", "left")
            temp.forEach {
                DrawBorderControllerClass(commonArgsForBorderDrawing = commonArgsForBorderDrawing).strategies[it]?.invoke()
            }
        },
    )
)