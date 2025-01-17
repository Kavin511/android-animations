package com.sp45.android_animations

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.sp45.android_animations.animations.AutoImageTransition
import com.sp45.android_animations.animations.BirthdayPopperAnimation
import com.sp45.android_animations.animations.BouncingBallAnimation
import com.sp45.android_animations.animations.ButtonToImage
import com.sp45.android_animations.animations.CardFlipping
import com.sp45.android_animations.animations.CarouselSlider
import com.sp45.android_animations.animations.ContentAnimation
import com.sp45.android_animations.animations.EmojiProgressBar
import com.sp45.android_animations.animations.ExpandableCardAnimation
import com.sp45.android_animations.animations.ExpandingRings
import com.sp45.android_animations.animations.FlipCard
import com.sp45.android_animations.animations.FloatingElements
import com.sp45.android_animations.animations.OrbitingObjects
import com.sp45.android_animations.animations.SlidingDoorAnimation
import com.sp45.android_animations.animations.SwipeToDeleteAnimation
import com.sp45.android_animations.animations.TextExplosion
import com.sp45.android_animations.animations.TypeWriterAnimation
import com.sp45.android_animations.animations.ValueSpringAnimation
import com.sp45.android_animations.animations.WaveLoadingBar
import com.sp45.android_animations.util.WebViewScreen
import java.net.URLDecoder
import java.net.URLEncoder
import java.nio.charset.StandardCharsets

@Composable
fun AppNavGraph(navController: NavHostController = rememberNavController()) {
    NavHost(
        navController = navController,
        startDestination = NavigationDestinations.MAIN
    ) {
        composable(NavigationDestinations.MAIN) {
            MainScreen(navController)
        }

        composable(NavigationDestinations.WEB_VIEW) {
            WebViewScreen()
        }

        composable(
            route = NavigationDestinations.ANIMATION,
            arguments = listOf(
                navArgument("animationName") {
                    type = NavType.StringType
                }
            )
        ) { backStackEntry ->
            val encodedAnimationName = backStackEntry.arguments?.getString("animationName") ?: ""
            val animationName =
                URLDecoder.decode(encodedAnimationName, StandardCharsets.UTF_8.toString())

            when (animationName) {
                "Swipe To Delete Animation" -> SwipeToDeleteAnimation()
                "Bouncing Ball Animation" -> BouncingBallAnimation()
                "Value Spring Animation" -> ValueSpringAnimation()
                "Content Animation" -> ContentAnimation()
                "Expandable Card Animation" -> ExpandableCardAnimation()
                "Wave Loading Bar" -> WaveLoadingBar()
                "Confetti Animation" -> BirthdayPopperAnimation()
                "Carousel Slider" -> CarouselSlider()
                "Flip Card" -> FlipCard()
                "Floating Elements" -> FloatingElements()
                "Type Writer Animation" -> TypeWriterAnimation()
                "Emoji Progress Bar" -> EmojiProgressBar()
                "Card Flipping" -> CardFlipping()
                "Button to Image" -> ButtonToImage()
                "Image Transition" -> AutoImageTransition()
                "Sliding Door" -> SlidingDoorAnimation()
                "Expanding Rings" -> ExpandingRings()
                "Orbiting Objects" -> OrbitingObjects()
                "Text Explosion" -> TextExplosion()
                else -> MainScreen(navController)
            }
        }
    }
}

object NavigationDestinations {
    const val MAIN = "main"
    const val ANIMATION = "animation/{animationName}"
    const val WEB_VIEW = "webView"

    fun createAnimationRoute(animationName: String): String {
        val encodedName = URLEncoder.encode(animationName, StandardCharsets.UTF_8.toString())
        return "animation/$encodedName"
    }
}