package com.auditorias.data.remote.network

import com.auditorias.data.remote.entities.result.AuditResult
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface AuditApiClient {

    @GET("ObtenerMisAuditoriasPorFecha")
    suspend fun getAuditForDate(
        @Query("LlaveMaestra") apiKey: String)
    : Response<AuditResult>
}