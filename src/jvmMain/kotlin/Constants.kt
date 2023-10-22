import androidx.compose.ui.Modifier
import androidx.compose.ui.input.pointer.PointerIcon
import androidx.compose.ui.input.pointer.pointerHoverIcon
import java.awt.Cursor

data class Constants(
    val modifyPointerToHandOnHover: Modifier = Modifier.pointerHoverIcon(
        icon = PointerIcon(
            cursor = Cursor.getPredefinedCursor(Cursor.HAND_CURSOR)
        )
    )
)