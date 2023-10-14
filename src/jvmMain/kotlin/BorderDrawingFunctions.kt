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


fun drawBorderController(
    borderCorner: String = "", CommonArgsForBorderDrawing: CommonArgsForBorderDrawing
) {
    when (borderCorner) {
        "bottomRight" -> {
            drawBottomBorder(
                CommonArgsForBorderDrawing
            )
            drawRightBorder(
                CommonArgsForBorderDrawing
            )
        }

        "bottomLeft" -> {
            drawBottomBorder(
                CommonArgsForBorderDrawing
            )
            drawLeftBorder(
                CommonArgsForBorderDrawing
            )
        }

        "upperRight" -> {
            drawUpperBorder(
                CommonArgsForBorderDrawing
            )
            drawRightBorder(
                CommonArgsForBorderDrawing
            )
        }

        "upperLeft" -> {
            drawUpperBorder(
                CommonArgsForBorderDrawing
            )
            drawLeftBorder(
                CommonArgsForBorderDrawing
            )
        }

        "upper" -> {
            drawUpperBorder(
                CommonArgsForBorderDrawing
            )
        }

        "bottom" -> {
            drawBottomBorder(
                CommonArgsForBorderDrawing
            )
        }

        "right" -> {
            drawRightBorder(
                CommonArgsForBorderDrawing
            )
        }

        "left" -> {
            drawLeftBorder(
                CommonArgsForBorderDrawing
            )
        }

        "allSides" -> {
            val temp = listOf("bottom", "upper", "right", "left")
            temp.forEach {
                drawBorderController(it, CommonArgsForBorderDrawing)
            }
        }
    }
}