package com.nvegas.core.ui.dialogs


import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.ErrorOutline
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import com.nvegas.core.ui.buttons.ButtonComponent

@Composable
fun ErrorDialogComponent(
    message: String,
    modifier: Modifier = Modifier,

    icon: ImageVector = Icons.Outlined.ErrorOutline,
    onDismiss: () -> Unit
) {

    Dialog(onDismissRequest = onDismiss) {
        Box(
            modifier = modifier
                .width(324.dp)
                .clip(RoundedCornerShape(10))
                .background(MaterialTheme.colorScheme.background)
        ) {
            Column(
                modifier = Modifier
                    .padding(horizontal = 35.dp, vertical = 36.dp)
                    .align(Alignment.Center),
                verticalArrangement = Arrangement.spacedBy(32.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Icon(
                    imageVector = icon,
                    contentDescription = null,
                    tint = MaterialTheme.colorScheme.onBackground,
                    modifier = Modifier.size(40.dp)
                )
                Text(
                    text = message,
                    textAlign = TextAlign.Center,
                    color = MaterialTheme.colorScheme.onBackground,
                    style = MaterialTheme.typography.bodyLarge
                )
                ButtonComponent(
                    text = "Entendido",
                    onClick = onDismiss
                )

            }
        }
    }
}


@Preview(name = "ErrorDialogComponent")
@Composable
private fun PreviewErrorDialogComponent() {
    ErrorDialogComponent(
        message = "Se ha producido un error",
        onDismiss = {}
    )
}