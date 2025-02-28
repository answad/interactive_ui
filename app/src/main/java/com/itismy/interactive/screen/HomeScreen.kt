package com.itismy.interactive.screen

import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.FastOutSlowInEasing
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.zIndex
import com.itismy.interactive.circlePager.LiabilitiesPager
import com.itismy.interactive.pagerIndicator.TopPagerIndicator
import com.itismy.interactive.ui.theme.*
import kotlinx.collections.immutable.persistentListOf

@Composable
fun HomeScreen(
    modifier: Modifier = Modifier,
    navigateToScroll: () -> Unit,
) {
    val colorList = persistentListOf(
        transparentPurple,
        transparentBlue,
        transparentGreen,
        transparentRed,
        transparentOrange,
        transparentLightBlue,
        transparentYellow,
        transparentLightGreen,
        transparentTeal,
        transparentIndigo,
        transparentGrey,
        transparentBlack,
    )
    val navigateFunList = persistentListOf(
        navigateToScroll,
        {},
        {},
        {},
        {},
        {},
        {},
        {},
        {},
        {},
        {},
        {},
    )
    val pagerState = rememberPagerState(pageCount = { colorList.size - 1 })
    val currentAnimatedColor by animateColorAsState(
        colorList[pagerState.currentPage],
        animationSpec = tween(
            durationMillis = 1200,
            easing = FastOutSlowInEasing
        ),
        label = "color",
    )
    val exAnimatedColor by animateColorAsState(
        colorList[pagerState.currentPage + 1],
        animationSpec = tween(
            durationMillis = 400,
            easing = FastOutSlowInEasing
        ),
        label = "color",
    )
    val gradient = Brush.linearGradient(
        colors = listOf(
            currentAnimatedColor,
            exAnimatedColor,
        ),
        end = Offset(800f, 300f),
        start = Offset(300f, 1000f),
    )
    Box(contentAlignment = Alignment.Center) {
        TopPagerIndicator(
            modifier = Modifier.zIndex(1f),
            progress = pagerState.currentPage + 1,
            numberOfDots = colorList.size - 1
        )
        Column(
            modifier = modifier
                .fillMaxSize()
                .background(gradient),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {

            LiabilitiesPager(
                modifier = modifier.fillMaxSize(),
                pagerState = pagerState,
                colorList = colorList,
                navigateFunList = navigateFunList,
            )
        }
    }
}