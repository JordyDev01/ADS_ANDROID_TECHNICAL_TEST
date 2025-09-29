package com.jordydev.ads_android_technical_test_jordy_etienne.view.mainView

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.VerticalDivider
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.jordydev.ads_android_technical_test_jordy_etienne.view.components.TileViewComponent

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.jordydev.ads_android_technical_test_jordy_etienne.ui.theme.Purple40


@Composable
fun MainView(
    viewModel: MainViewModel = hiltViewModel()
) {
    val state = viewModel.uiState.collectAsStateWithLifecycle().value.events

    Row(
        modifier = Modifier
    )
    {
        TileViewComponent(
            modifier = Modifier
                .background(
                    Purple40
                )
                .fillMaxHeight(0.25f)
                .fillMaxWidth(0.5f),
            lines = state,
            onFabClick = viewModel::onFabClick
        )
        VerticalDivider(
            color = Color.Black,
            thickness = 2.dp,
            modifier = Modifier
                .height(
                    200.dp
                )
        )
        TileViewComponent(
            modifier = Modifier
                .background(
                    Purple40
                )
                .fillMaxHeight(0.25f)
                .fillMaxWidth(1f),
            lines = state,
            onFabClick = viewModel::onFabClick
        )
    }

}