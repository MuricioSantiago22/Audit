package com.auditorias.domain.repository

import com.auditorias.data.local.entities.AuditEntity
import com.auditorias.domain.entities.Audit

interface AuditListRepository {

    suspend fun getAuditDataFromApi():List<Audit>

    suspend fun getAuditDataFromDB():List<Audit>

    suspend fun  insertAuditData(list:List<AuditEntity>)

    suspend fun  clearDataBase()

}