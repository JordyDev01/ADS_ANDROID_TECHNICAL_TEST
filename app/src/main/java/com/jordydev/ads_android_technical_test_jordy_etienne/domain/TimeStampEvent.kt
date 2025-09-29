package com.jordydev.ads_android_technical_test_jordy_etienne.domain

import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Singleton

@Singleton
interface TimeStampEvent {
    val timestamp: StateFlow<String>
    val event: SharedFlow<Long?>
    fun publishTimeStamp(timestamp: String = System.currentTimeMillis().toString())
}