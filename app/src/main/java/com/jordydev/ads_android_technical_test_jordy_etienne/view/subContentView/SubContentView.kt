package com.jordydev.ads_android_technical_test_jordy_etienne.view.subContentView

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable

import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.jordydev.ads_android_technical_test_jordy_etienne.view.components.TileViewComponent

@Composable
fun SubContentView(
    viewModel: SubContentViewModel = hiltViewModel()

) {
    val state = viewModel.uiState.collectAsStateWithLifecycle().value.events
    TileViewComponent(
        modifier = Modifier
                .fillMaxSize()
            .background(
                color = Color.Cyan
            ),
        lines = state,
        onFabClick = viewModel::onFabClick
    )
}