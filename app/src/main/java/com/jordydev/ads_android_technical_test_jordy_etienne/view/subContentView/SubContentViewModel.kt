package com.jordydev.ads_android_technical_test_jordy_etienne.view.subContentView

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.jordydev.ads_android_technical_test_jordy_etienne.domain.TimeStampEvent
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

//data class to represent the latest list of events
data class HomeUiState(val events: List<String> = emptyList())

@HiltViewModel
class SubContentViewModel @Inject constructor(
    private val timeStampEvent: TimeStampEvent
): ViewModel() {

    //flow to hold the latest lastTimestamp state
    private val _uiState = MutableStateFlow(HomeUiState())
    val uiState: StateFlow<HomeUiState> = _uiState


    //collect the latest value from the flow and update the UI on initialization
    init {
        viewModelScope.launch {
            timeStampEvent.timestamp.collectLatest { ts ->
                _uiState.update { it.copy(events = it.events + ts) }
            }
        }
    }


    //function to handle the FAB click event to send a new timeStamp to the flow
    fun onFabClick() {
        timeStampEvent.publishTimeStamp()
    }
}