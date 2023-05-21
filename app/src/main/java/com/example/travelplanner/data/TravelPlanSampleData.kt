package com.example.travelplanner.data

import com.example.travelplanner.model.TravelPlan
import java.time.LocalDate
import java.time.LocalDateTime
import java.util.Calendar
import java.util.Date

val sampleTravelData = listOf<TravelPlan>(
    TravelPlan(
        name = "1",
        description = "Testing hello",
        destination = "Penang",
        travelDetails = emptyList(),
        endDate = LocalDateTime.now(),
        startDate = LocalDateTime.now()
    ),
    TravelPlan(
        name = "2",
        description = "Testing hello",
        destination = "Penang",
        travelDetails = emptyList(),
        endDate = LocalDateTime.now(),
        startDate = LocalDateTime.now()
    ),
    TravelPlan(
        name = "3",
        description = "Testing hello",
        destination = "Penang",
        travelDetails = emptyList(),
        endDate = LocalDateTime.now(),
        startDate = LocalDateTime.now()
    ),
    TravelPlan(
        name = "4",
        description = "Testing hello",
        destination = "Penang",
        travelDetails = emptyList(),
        endDate = LocalDateTime.now(),
        startDate = LocalDateTime.now()
    )


)