package com.itismy.interactive.screen

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.PageSize
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.unit.dp
import com.itismy.interactive.ui.theme.transparentBlue
import com.itismy.interactive.ui.theme.transparentPurple

@Composable
fun ScrollScreen(
    modifier: Modifier = Modifier,
) {
    val scrollState = rememberScrollState()
    LaunchedEffect(scrollState.value) {
        Log.d("scrollState", scrollState.value.toString())
    }
    val configuration = LocalConfiguration.current
    val widthWeight = 0.9F
    val pageSize = PageSize.Fixed(pageSize = (configuration.screenWidthDp * widthWeight).dp)
    val horizontalContentPadding = (configuration.screenWidthDp * (1F - widthWeight) / 2).dp

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
            pageSize = pageSize,
            userScrollEnabled = scrollState.value < 200,
            contentPadding = PaddingValues(horizontal = horizontalContentPadding),
            verticalAlignment = Alignment.CenterVertically,
        ) { page ->
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(2000.dp)
                    .background(transparentBlue),
            ) {

            }
        }
    }
}
