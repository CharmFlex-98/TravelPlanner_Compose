package com.example.travelplanner.ui.new_edit_travel_plan

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.travelplanner.data.SampleRepo
import com.example.travelplanner.model.TravelPlan
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import java.time.LocalDateTime
import java.util.Date

data class NewEditUIState(
    val tripName: String = "",
    val destination: String = "",
    val startDate: LocalDateTime? = null,
    val endDate: LocalDateTime? = null,
    val description: String = "",
    val message: String? = null,
    val updateCompleted: Boolean = false
)

class NewEditTravelPlanViewModel(private val _repo: SampleRepo = SampleRepo.ref()) : ViewModel() {

    private val _uiState = MutableStateFlow<NewEditUIState>(NewEditUIState())
    val uiState: StateFlow<NewEditUIState> = _uiState

    /*
    * Update trip name
    */
    fun updateTripName(tripName: String) {
        _uiState.update {
            it.copy(
                tripName = tripName
            )
        }
    }

    /*
    * Update destination
    */
    fun updateDestination(destination: String) {
        _uiState.update {
            it.copy(
                destination = destination
            )
        }
    }

    /*
    * Update start day of the trip
    */
    fun updateStartDate(startDate: LocalDateTime) {
        _uiState.update {
            it.copy(
                startDate = startDate
            )
        }
    }

    /*
    * Update end day of the trip
    */
    fun updateEndDate(endDate: LocalDateTime) {
        _uiState.update {
            it.copy(
                endDate = endDate
            )
        }
    }

    /*
    * Update description of the trip
    */
    fun updateDescription(description: String) {
        _uiState.update {
            it.copy(
                description = description
            )
        }
    }


    /*
    * Add new plan
    */
    fun createNewPlan() {
        if (validInputs()) {
            val inputs = _uiState.value
            val newPlan = TravelPlan(
                startDate = inputs.startDate!!,
                endDate = inputs.endDate!!,
                destination = inputs.destination,
                description = inputs.description,
                name = inputs.tripName,
            )
            _repo.addTravelPlan(newPlan)
            updateCompleted()
        } else {
            createUserMessage()
        }

    }


    /*
    * Create message to user
    */
    private fun createUserMessage() {
        println("creating user message for showing")
        _uiState.update {
            it.copy(
                message = "Cannot create new task!"
            )
        }
    }


    /*
    * Clear user message
    */
    fun clearUserMessage() {
        _uiState.update {
            it.copy(
                message = null
            )
        }
    }


    /*
    * Are all the imputs valid?
    */
    private fun validInputs(): Boolean {
        val inputState = _uiState.value
        return (inputState.tripName.isNotEmpty() && inputState.description.isNotBlank() && inputState.startDate != null && inputState.endDate != null)
    }


    /*
    * Update new plan completed
    */
    private fun updateCompleted() {
        _uiState.update {
            it.copy(
                updateCompleted = true
            )
        }
    }
}