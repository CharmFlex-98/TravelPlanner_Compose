package com.example.travelplanner.data

import com.example.travelplanner.model.TravelPlan
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update

var sampleRepo: SampleRepo? = null

class SampleRepo {

    companion object {
        fun ref(): SampleRepo {
            if (sampleRepo == null) sampleRepo = SampleRepo()
            return sampleRepo!!
        }
    }

    private val _travelPlanList = MutableStateFlow<List<TravelPlan>>(listOf())
    val travelPlanList: StateFlow<List<TravelPlan>> = _travelPlanList

    fun addTravelPlan(travelPlan: TravelPlan) {
        _travelPlanList.update {
        val currentList = it.toMutableList()
            currentList.add(travelPlan)
            currentList.toList()
        }
    }
}