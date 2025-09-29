package com.jordydev.ads_android_technical_test_jordy_etienne.data

import com.jordydev.ads_android_technical_test_jordy_etienne.domain.TimeStampEvent
import jakarta.inject.Inject
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Singleton


@Singleton
//class repository to implement member of the TimeStampEvent interface
class TimeStampRepository @Inject constructor(): TimeStampEvent {

    //flow to hold the latest timestamp
    private val _timestamp = MutableStateFlow<String>("")
    private val _events = MutableSharedFlow<Long>(replay = 1, extraBufferCapacity = 64)

    //expose the flow to the viewmodels
    override val timestamp: StateFlow<String>
        get() = _timestamp
    override val event: SharedFlow<Long?>
        get() = _events

    //publish the timestamp to the flow
    override fun publishTimeStamp(timestamp: String) {
        _timestamp.value = timestamp
        _events.tryEmit(timestamp.toLong())
    }
}