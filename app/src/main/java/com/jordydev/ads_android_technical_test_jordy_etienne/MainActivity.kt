package com.jordydev.ads_android_technical_test_jordy_etienne

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import com.jordydev.ads_android_technical_test_jordy_etienne.ui.theme.ADS_android_technical_test_jordy_EtienneTheme
import com.jordydev.ads_android_technical_test_jordy_etienne.view.contentView.MainContentView
import com.jordydev.ads_android_technical_test_jordy_etienne.view.drawerView.DrawerView
import com.jordydev.ads_android_technical_test_jordy_etienne.view.mainView.MainView
import com.jordydev.ads_android_technical_test_jordy_etienne.view.subContentView.SubContentView
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ADS_android_technical_test_jordy_EtienneTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Row(
                        modifier = Modifier
                            .padding(innerPadding)
                            .fillMaxSize(),
                    ) {

                        Column(
                            modifier = Modifier
                                .weight(0.4f)
                        ) {
                            SubContentView()
                        }
//                        VerticalDivider(
//                            modifier = Modifier
//                                .weight(0.05f),
//                            color = Color.Green
//                        )
                        Column(
                            modifier = Modifier
                                .weight(1f)
                        ) {
                            MainView()
                            MainContentView()
                            DrawerView()
                        }

                    }
                }
            }
        }
    }
}

