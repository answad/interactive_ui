package com.itismy.interactive.ui.theme

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun InteractionTopBar(
    modifier: Modifier = Modifier,
    startIcon: @Composable () -> Unit,
    betweenText: @Composable () -> Unit = { Spacer(modifier = Modifier.size(24.dp)) },
    endIcon: @Composable () -> Unit = { Spacer(modifier = Modifier.size(24.dp)) }
) {
    Row(
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically,
        modifier = modifier.fillMaxWidth()
    ) {
        startIcon()
        betweenText()
        endIcon()
    }
}