package com.jordydev.ads_android_technical_test_jordy_etienne.view.components



import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row

import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


@Composable
fun TileViewComponent(
    modifier: Modifier,
    lines: List<String>,
    onFabClick: () -> Unit,
) {
    val content = remember(lines) { lines.filter { it.isNotBlank() } }
    Row(
        modifier = modifier,
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.Top
    )
    {
        //left column with the timestamp
        Column(
            modifier = Modifier,
        ) {
            println(lines)
            if (content.isNotEmpty()) {
                content.forEachIndexed { i, s ->
                    Text(
                        text = "${i + 1} - $s",
                        fontSize = 8.sp,
                        color = Color.Black
                    )
                }
            }

        }

        //right column with the Fab
        Column(
            modifier = Modifier
            ){
            FloatingActionButton(
                onClick = onFabClick,
                shape = CircleShape,
                containerColor = Color.Red,
                modifier = Modifier
                    .size(42.dp)

            ) {
                Icon(
                    imageVector = Icons.Filled.Check,
                    contentDescription = "Add",
                    tint = Color.Black,

                )
            }
        }

    }
}