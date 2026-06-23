package com.yasinmoridi.onlineshop.navigation

import androidx.compose.animation.ExperimentalSharedTransitionApi
import androidx.compose.animation.SharedTransitionLayout
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.toRoute
import com.yasinmoridi.onlineshop.ui.screen.category.CategoryScreen
import com.yasinmoridi.onlineshop.ui.screen.detail.ProductDetailScreen
import com.yasinmoridi.onlineshop.ui.screen.favorit.FavoriteScreen
import com.yasinmoridi.onlineshop.ui.screen.home.HomeScreen
import com.yasinmoridi.onlineshop.ui.screen.profile.EditProfileScreen
import com.yasinmoridi.onlineshop.ui.screen.profile.ProfileScreen
import com.yasinmoridi.onlineshop.ui.screen.shoping.ShoppingCartScreen
import com.yasinmoridi.onlineshop.viewModel.MainViewModel

@OptIn(ExperimentalSharedTransitionApi::class)
@Composable
fun NavGraph(
    modifier: Modifier,
    navHostController: NavHostController,
    mainViewModel: MainViewModel
) {
    SharedTransitionLayout(
        modifier = Modifier.fillMaxSize(),
    ) {
        NavHost(
            modifier = modifier,
            navController = navHostController,
            startDestination = Routes.HomeScreen
        ) {
            composable<Routes.HomeScreen> {
                HomeScreen(
                    navHostController = navHostController,
                    mainViewModel = mainViewModel,
                    sharedTransitionScope = this@SharedTransitionLayout,
                    animatedContentScope = this@composable
                )
            }
            composable<Routes.ProductDetailScreen> {
                val args = it.toRoute<Routes.ProductDetailScreen>()
                ProductDetailScreen(
                    navHostController = navHostController,
                    id =args.id,
                    image = args.image,
                    title = args.title,
                    price = args.price,
                    rating = args.rating,
                    discountPercent = args.discountPercent,
                    mainViewModel = mainViewModel,
                    sharedTransitionScope = this@SharedTransitionLayout,
                    animatedContentScope = this@composable
                )
            }
            composable<Routes.CategoryScreen> {
                val args =it.toRoute<Routes.CategoryScreen>()
                CategoryScreen(
                    navHostController = navHostController,
                    selectedTabIndex = args.selectedIndex,
                    mainViewModel = mainViewModel,
                    sharedTransitionScope = this@SharedTransitionLayout,
                    animatedContentScope = this@composable
                )
            }
            composable<Routes.ShoppingCartScreen> {
                ShoppingCartScreen(navHostController,mainViewModel)
            }
            composable<Routes.ProfileScreen> {
                ProfileScreen(navHostController,mainViewModel)
            }
            composable<Routes.EditProfileScreen> {
                EditProfileScreen(navHostController,mainViewModel)
            }
            composable<Routes.FavoriteScreen> {
                FavoriteScreen(mainViewModel)
            }

        }
    }

}