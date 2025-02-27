package com.itismy.interactive.screen

import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.FastOutSlowInEasing
import androidx.compose.animation.core.tween
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import com.itismy.interactive.circlePager.LiabilitiesPager
import com.itismy.interactive.ui.theme.transparentBlack
import com.itismy.interactive.ui.theme.transparentBlue
import com.itismy.interactive.ui.theme.transparentGreen
import com.itismy.interactive.ui.theme.transparentGrey
import com.itismy.interactive.ui.theme.transparentIndigo
import com.itismy.interactive.ui.theme.transparentLightBlue
import com.itismy.interactive.ui.theme.transparentLightGreen
import com.itismy.interactive.ui.theme.transparentOrange
import com.itismy.interactive.ui.theme.transparentPurple
import com.itismy.interactive.ui.theme.transparentRed
import com.itismy.interactive.ui.theme.transparentTeal
import com.itismy.interactive.ui.theme.transparentWhite
import com.itismy.interactive.ui.theme.transparentYellow
import kotlinx.collections.immutable.persistentListOf

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun HomeScreen(modifier: Modifier = Modifier) {
    val colorList = persistentListOf(
        transparentWhite,
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

    val pagerState = rememberPagerState(pageCount = { colorList.size - 1 })

    val currentAnimatedColor by animateColorAsState(
        colorList[pagerState.currentPage],
        animationSpec = tween(
            durationMillis = 700,
            easing = FastOutSlowInEasing
        ),
        label = "color",
    )
    val exAnimatedColor by animateColorAsState(
        colorList[pagerState.currentPage + 1],
        animationSpec = tween(
            durationMillis = 700,
            easing = FastOutSlowInEasing
        ),
        label = "color",
    )
    val gradient = Brush.linearGradient(
        colors = listOf(
            currentAnimatedColor,
            exAnimatedColor,
        ),
        end = Offset (800f, 300f),
        start = Offset(300f, 1000f),
    )
    Column(
        modifier = modifier
            .fillMaxSize()
            .background(gradient),
        verticalArrangement = Arrangement.Center
    ) {
        LiabilitiesPager(
            modifier = modifier,
            pagerState = pagerState
        )
    }
}

