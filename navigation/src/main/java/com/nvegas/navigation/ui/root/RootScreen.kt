package com.nvegas.navigation.ui.root

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeDrawingPadding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.nvegas.navigation.ui.components.BottomNavItemsProvider.BOTTOM_NAV_ITEMS
import com.nvegas.navigation.ui.components.BottomNavigationBar

@Composable
fun RootScreen() {
    val navController = rememberNavController()
    val navControllerEntry by navController.currentBackStackEntryAsState()
    val currentDestination = navControllerEntry?.destination
    val viewModel = hiltViewModel<RootViewModel>()
    Scaffold(
        modifier = Modifier.fillMaxSize(),
        bottomBar = {

            BottomNavigationBar(
                route = currentDestination?.route,
                navigate = viewModel::bottomBarNavigation,
                enabled = BOTTOM_NAV_ITEMS.any { it.route::class.qualifiedName == currentDestination?.route }
            )
        }
    ) { paddingValue ->

        Box(modifier = Modifier
            .safeDrawingPadding()
            .padding(paddingValue)) {
            RootNavGraph(
                navController = navController,
                viewModel = viewModel
            )
        }
    }
}

@Preview(name = "RootScreen")
@Composable
private fun PreviewRootScreen() {
    RootScreen()
}