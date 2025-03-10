package com.nvegas.common.ui.inputs

import android.content.res.Configuration
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Email
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.nvegas.common.theme.AppTheme
import com.nvegas.common.ui.text.TextComponent

@Composable
fun TextInputComponent(
    text: String = "",
    label: String? = null,
    icon: ImageVector? = null,
    modifier: Modifier = Modifier,
    backgroundColor: Color = MaterialTheme.colorScheme.surfaceContainerLowest,
    shape: Shape = TextFieldDefaults.shape,
    visualTransformation: VisualTransformation = VisualTransformation.None,
    setText: (String) -> Unit,
) {
    TextField(
        value = text,
        onValueChange = setText,
        modifier = modifier.fillMaxWidth(),
        label = {
            label?.let {
                TextComponent(
                    it,
                    color = MaterialTheme.colorScheme.onBackground.copy(alpha = 0.5f),
                    style = if (text.isEmpty()) MaterialTheme.typography.bodyLarge else MaterialTheme.typography.bodySmall
                )
            }
        },
        trailingIcon = {
            icon?.let {
                Icon(
                    it, null,
                    modifier = Modifier.size(24.dp),
                    tint = MaterialTheme.colorScheme.onBackground.copy(alpha = 0.5f)
                )
            }
        },
        colors = TextFieldDefaults.colors(
            focusedTextColor = MaterialTheme.colorScheme.onBackground,
            unfocusedTextColor = MaterialTheme.colorScheme.onBackground,
            unfocusedContainerColor = backgroundColor,
            focusedContainerColor = backgroundColor,
            disabledContainerColor = backgroundColor,
            disabledTextColor = MaterialTheme.colorScheme.onBackground,
            focusedIndicatorColor = backgroundColor,
            unfocusedIndicatorColor = backgroundColor,
        ),
        shape = shape,
        visualTransformation = visualTransformation
    )
}

@Preview(name = "Light Mode")
@Preview(name = "Dark Mode", uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
private fun PreviewTextInputComponent() {
    AppTheme {
        TextInputComponent(
            label = "Email",
            icon = Icons.Outlined.Email,
        ) {}
    }
}