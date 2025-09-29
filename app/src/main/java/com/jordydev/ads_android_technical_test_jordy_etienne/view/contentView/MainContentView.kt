package com.jordydev.ads_android_technical_test_jordy_etienne.view.contentView

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.VerticalDivider
import androidx.compose.runtime.Composable

import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.jordydev.ads_android_technical_test_jordy_etienne.ui.theme.Orange

import com.jordydev.ads_android_technical_test_jordy_etienne.view.components.TileViewComponent

    //ContentView key word is already in use so I changed it to MainContentView
@SuppressLint("SuspiciousIndentation")
@Composable
fun MainContentView(
    viewModel: ContentViewModel = hiltViewModel()
) {
    val state = viewModel.uiState.collectAsStateWithLifecycle().value.events

        Row(
            modifier = Modifier
        ) {
            TileViewComponent(
                modifier = Modifier
                    .background(
                        Orange
                    )
                    .fillMaxHeight(0.35f)
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
                        Orange
                    )
                    .fillMaxHeight(0.35f)
                    .fillMaxWidth(1f),
                lines = state,
                onFabClick = viewModel::onFabClick
            )
        }

}