package com.example.travelplanner.ui.travel_plans

import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.travelplanner.data.SampleRepo
import com.example.travelplanner.model.TravelPlan
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn

data class TravelPlansUIState(
    val items: List<TravelPlan> = emptyList(),
    val isLoading: Boolean = true
)

class TravelPlansViewModel(private val _repo: SampleRepo = SampleRepo.ref()) : ViewModel() {
    // Filtered travel plan list
    private val _filteredTravelPlanList = _repo.travelPlanList

    // The UI state of Travel Plans Screen
    val uiState: StateFlow<TravelPlansUIState> = _filteredTravelPlanList.map {
        TravelPlansUIState(items = it, isLoading = false)
    }.stateIn(
        scope = viewModelScope,
        started = SharingStarted.WhileSubscribed(),
        initialValue = TravelPlansUIState(isLoading = false)
    )
}