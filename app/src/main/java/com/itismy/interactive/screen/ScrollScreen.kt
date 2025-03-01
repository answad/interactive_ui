package com.itismy.interactive.screen

import android.util.Log
import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.FastOutSlowInEasing
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.PageSize
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.unit.dp
import com.itismy.interactive.ui.theme.transparentBlue
import com.itismy.interactive.ui.theme.transparentPurple

@Composable
fun ScrollScreen(
    modifier: Modifier = Modifier,
) {
    val scrollState = rememberScrollState()
    val isExpend = scrollState.value > 200
    LaunchedEffect(scrollState.value) {
        Log.d("scrollState", scrollState.value.toString())
    }
    val configuration = LocalConfiguration.current
    val widthWeight = animateFloatAsState(
        if (isExpend) 1f else 0.8f, animationSpec = tween(
            durationMillis = 1000,
            easing = FastOutSlowInEasing
        )
    )
    val horizontalContentPadding = (configuration.screenWidthDp * (1F - widthWeight.value) / 2).dp

    Column(
        modifier = modifier
            .fillMaxSize()
            .verticalScroll(scrollState)
            .background(transparentPurple),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
    ) {
        HorizontalPager(
            modifier = modifier.fillMaxSize(),
            state = rememberPagerState { 5 },
            userScrollEnabled = !isExpend,
            pageSpacing = 50.dp,
            contentPadding = PaddingValues(horizontal = horizontalContentPadding),
        ) { page ->
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.Center,
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(2000.dp)
                        .background(
                            color = transparentBlue,
                            shape = RoundedCornerShape(size = 6.dp),
                        ),
                ) {
                    Text("ugyhbgjkj")
                    Text("ugyhbgjkj")
                    Text("ugyhbgjkj")
                    Text("ugyhbgjkj")
                    Text("ugyhbgjkj")
                    Text("ugyhbgjkj")
                    Text("ugyhbgjkj")
                    Text("ugyhbgjkj")
                    Text("ugyhbgjkj")
                    Text("ugyhbgjkj")
                    Text("ugyhbgjkj")
                    Text("ugyhbgjkj")
                    Text("ugyhbgjkj")
                    Text("ugyhbgjkj")
                    Text("ugyhbgjkj")
                    Text("ugyhbgjkj")
                    Text("ugyhbgjkj")
                    Text("ugyhbgjkj")
                }
            }
        }
    }
}
