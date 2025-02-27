package com.itismy.interactive.circlePager

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.PageSize
import androidx.compose.foundation.pager.PagerState
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.unit.dp
import kotlin.math.absoluteValue
import kotlin.math.sin

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun LiabilitiesPager(
    modifier: Modifier = Modifier,
    pagerState: PagerState,
) {
    val pageSpacing = 75.dp
    val rotateDegree = 15F
    val configuration = LocalConfiguration.current
    val widthWeight = 0.6F
    val pageSize = PageSize.Fixed(pageSize = (configuration.screenWidthDp * widthWeight).dp)
    val horizontalContentPadding = (configuration.screenWidthDp * (1F - widthWeight) / 2).dp

    HorizontalPager(
        modifier = modifier,
        state = pagerState,
        pageSize = pageSize,
        pageSpacing = pageSpacing,
        contentPadding = PaddingValues(horizontal = horizontalContentPadding),
    ) { page ->
        Card(
            onClick = { },
            colors = CardDefaults.cardColors(Color.Black),
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight(0.5f)
                .graphicsLayer {
                    val pageOffset =
                        (pagerState.currentPageOffsetFraction + (pagerState.currentPage - page))
                    val distance = (configuration.screenWidthDp.dp / 2) - pageSpacing
                    val height = sin(Math.toRadians(rotateDegree.toDouble())) * distance.toPx()

                    translationY = (height * pageOffset.absoluteValue).toFloat()
                    rotationZ = -rotateDegree * pageOffset
                    alpha = 0.7F + (0.3F * (1F - pageOffset.absoluteValue.coerceIn(0F, 1F)))
                }
        ) {

        }
    }
}