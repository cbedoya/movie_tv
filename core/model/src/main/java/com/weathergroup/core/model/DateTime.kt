package com.weathergroup.core.model

import kotlinx.datetime.Instant
import kotlinx.datetime.TimeZone
import kotlinx.datetime.toLocalDateTime

fun Instant.getYear() = this.toLocalDateTime(TimeZone.currentSystemDefault()).year