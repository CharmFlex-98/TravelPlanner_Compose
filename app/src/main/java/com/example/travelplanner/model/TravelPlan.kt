package com.example.travelplanner.model

import java.util.Date

/**
Travel plan data class
 */
data class TravelPlan(
    val name: String,
    val destination: String,
    val startDate: Date,
    val endDate: Date,
    val description: String,
    val travelDetails: List<TravelDetail>
)


/*
 * data class for plan detail
 */
abstract class TravelDetail(
    val startTime: Date,
    val endTime: Date
) {
//    More in the future
}