package com.auditorias.data.remote.entities.result

import com.auditorias.data.remote.entities.dto.AuditDto
import com.google.gson.annotations.SerializedName

data class AuditResult(
    @SerializedName("ObtenerMisAuditoriasPorFechaResult")
    val result : List<AuditDto?> = listOf()
)
