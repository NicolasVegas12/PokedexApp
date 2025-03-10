package com.nvegas.core.ui.buttons

import android.content.res.Configuration
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.nvegas.core.theme.AppTheme

@Composable
fun ButtonComponent(
    text: String,
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    backgroundColor: Color = MaterialTheme.colorScheme.onBackground,
    textColor: Color = MaterialTheme.colorScheme.background,
    onClick: () -> Unit
) {
    var isClicked by remember { mutableStateOf(false) }

    LaunchedEffect(isClicked) {
        if (isClicked) {
            onClick.invoke()
            isClicked = false
        }
    }
    Box(modifier = modifier) {
        Button(
            onClick = { isClicked = true },
            enabled = enabled,
            shape = RoundedCornerShape(20.dp),
            contentPadding = PaddingValues(vertical = 17.dp),
            modifier = Modifier
                .fillMaxWidth()
                .border(
                    1.dp,
                    color = if (enabled) MaterialTheme.colorScheme.onBackground else MaterialTheme.colorScheme.onBackground.copy(
                        alpha = 0.5f
                    ),
                    RoundedCornerShape(20.dp)
                ),
            colors = ButtonDefaults.buttonColors(
                containerColor = backgroundColor,
                disabledContainerColor = backgroundColor.copy(alpha = 0.5f)
            )

        ) {
            Text(
                text = text.uppercase(),
                color = textColor,
                style = MaterialTheme.typography.bodyMedium.copy(fontWeight = FontWeight.Bold)
            )
        }
    }


}


@Preview(name = "Light Mode")
@Preview(name = "Dark Mode", uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
private fun PreviewButtonComponent() {
    AppTheme {
        ButtonComponent(text = "Button Component", enabled = true) {

        }
    }
}