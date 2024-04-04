package com.auditorias.data.repository

import com.auditorias.data.local.dao.AuditDao
import com.auditorias.data.local.entities.AuditEntity
import com.auditorias.data.local.mapper.toDomain
import com.auditorias.data.remote.mapper.toDomain
import com.auditorias.data.remote.network.AuditApiClient
import com.auditorias.domain.entities.Audit
import com.auditorias.domain.repository.AuditListRepository
import javax.inject.Inject

class AuditListRepositoryImpl @Inject constructor(
    private val client : AuditApiClient,
    private val auditDataDao: AuditDao
):AuditListRepository {

    companion object {
        const val API_KEY = "PG0XUep8sk7H6Ve4bK63Bg=="
    }

    override suspend fun getAuditDataFromApi(): List<Audit> {
        val response= client.getAuditForDate(API_KEY)
        return response.body()?.result?.map { it!!.toDomain()}?: listOf()
    }

    override suspend fun getAuditDataFromDB(): List<Audit> {
        val response:List<AuditEntity> = auditDataDao.getListData()
        return  response.map { it.toDomain() }
    }

    override suspend fun insertAuditData(list: List<AuditEntity>) {
        auditDataDao.insertListData(list)
    }

    override suspend fun clearDataBase() {
        auditDataDao.deleteListData()
    }
}