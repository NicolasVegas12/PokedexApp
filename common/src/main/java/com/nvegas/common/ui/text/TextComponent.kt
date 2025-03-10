package com.nvegas.common.ui.text

import android.content.res.Configuration
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import com.nvegas.common.theme.AppTheme

@Composable
fun TextComponent(
    text: String,
    style: TextStyle = MaterialTheme.typography.bodyMedium,
    color: Color = MaterialTheme.colorScheme.onBackground,
    modifier: Modifier = Modifier
) {
    Text(
        text = text,
        color = color,
        style = style,
        modifier = modifier
    )
}

@Preview(name = "Light Mode")
@Preview("Dark Mode", uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
private fun PreviewTextComponent() {
    AppTheme {
        TextComponent(
            "Try Text"
        )
    }
}