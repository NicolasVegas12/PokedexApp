package com.nvegas.common.ui.buttons

import android.content.res.Configuration
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Checkbox

import androidx.compose.material3.CheckboxDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.nvegas.common.theme.AppTheme

@Composable
fun CheckBoxButtonComponent(
    checked:Boolean,
    modifier: Modifier = Modifier,
    onCheckedChange: (Boolean) -> Unit
) {
   Checkbox(
       checked = checked,
       onCheckedChange = onCheckedChange,
       modifier = modifier,

       colors = CheckboxDefaults.colors(
           uncheckedColor = MaterialTheme.colorScheme.onBackground,
           checkedColor = MaterialTheme.colorScheme.onBackground
       )
   )
}

@Preview(name = "light mode")
@Preview(name = "dark mode", uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
private fun PreviewCheckBoxButtonComponent() {
    AppTheme {
        CheckBoxButtonComponent(false, onCheckedChange = {}, modifier = Modifier.size(12.dp))
    }
}