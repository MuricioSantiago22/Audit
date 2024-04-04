package com.auditorias.data.remote.entities.dto

import com.google.gson.annotations.SerializedName

data class AuditDto(
    @SerializedName("auditoria")
    val audit: String? = null,
    @SerializedName("sucursal")
    val branch: String? = null,
    @SerializedName("fecha_inicio_plan")
    val startDate: String? = null
)
