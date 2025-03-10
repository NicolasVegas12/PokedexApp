package com.nvegas.navigation.ui.components

import android.content.res.Configuration
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.nvegas.core.navigation.destinations.Destination
import com.nvegas.core.navigation.destinations.HomeDestination
import com.nvegas.core.theme.AppTheme
import com.nvegas.navigation.ui.components.BottomNavItemsProvider.BOTTOM_NAV_ITEMS

@Composable
fun BottomNavigationBar(
    route: String?,
    navigate: (Destination) -> Unit,
    enabled: Boolean
) {
    AnimatedVisibility(enabled) {

        NavigationBar(
            containerColor = MaterialTheme.colorScheme.primaryContainer,
            modifier = Modifier
                .padding(horizontal = 20.dp, vertical = 40.dp)
                .clip(RoundedCornerShape(20.dp))
                .height(50.dp),
            windowInsets = WindowInsets(0)
        ) {

            BOTTOM_NAV_ITEMS.map { item ->
                AddItem(screen = item,
                    selected = (item.route::class.qualifiedName == route),
                    onClick = { next ->

                        navigate.invoke(next)

                    })
            }

        }
    }
}

@Composable
fun RowScope.AddItem(
    screen: BottomNavItem,
    selected: Boolean,
    onClick: (Destination) -> Unit,
) {

    NavigationBarItem(
        selected = selected,
        modifier = Modifier.align(Alignment.CenterVertically),
        alwaysShowLabel = false,
        onClick = {
            onClick.invoke(screen.route)
        },
        icon = {
            val color = if (selected) MaterialTheme.colorScheme.onBackground else Color.Gray
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
            ) {

                Icon(
                    painter = painterResource(screen.icon),
                    contentDescription = screen.name,
                    modifier = Modifier.size(24.dp),
                    tint = color
                )

                if (selected) {
                    HorizontalDivider(
                        modifier = Modifier.fillMaxWidth(0.5f), thickness = 2.dp,
                        color = color
                    )
                }
            }
        })

}

@Preview(name = "BottomNavigationBar", apiLevel = 30)
@Preview(name = "BottomNavigationBar", apiLevel = 30, uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
private fun PreviewBottomNavigationBar() {
    AppTheme {
        BottomNavigationBar(HomeDestination.HomePrincipalRoute::class.qualifiedName, {}, true)
    }
}