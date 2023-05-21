package com.example.travelplanner.model

import java.time.LocalDateTime
import java.util.Date

/**
Travel plan data class
 */
data class TravelPlan(
    val name: String,
    val destination: String,
    val startDate: LocalDateTime,
    val endDate: LocalDateTime,
    val description: String,
    val travelDetails: List<TravelDetail>? = null
)


/*
 * data class for plan detail
 */
abstract class TravelDetail(
    val startTime: LocalDateTime,
    val endTime: LocalDateTime
) {
//    More in the future
}