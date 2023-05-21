package com.example.travelplanner.utils

import java.time.Instant
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import java.util.TimeZone

const val dateFormatPattern = "dd/MM/yyyy"

/*
* From date to formatted string used to show in the text field or whatever
*/
fun LocalDateTime.toFormattedString(): String {
    return DateTimeFormatter.ofPattern(dateFormatPattern).format(this)
}

/*
* From LocalDateTime object to string
*/
fun String.toLocalDateTime(): LocalDateTime {
    val formatter = DateTimeFormatter.ofPattern(dateFormatPattern)
    return LocalDateTime.parse(this, formatter)
}


/*
From Long to Local Date Time
*/
fun Long.toLocalDateTime(): LocalDateTime {
    return LocalDateTime.ofInstant(Instant.ofEpochMilli(this), TimeZone.getDefault().toZoneId())
}

