package com.auditorias.domain.useCase

import com.auditorias.data.remote.mapper.toEntity
import com.auditorias.domain.entities.Audit
import com.auditorias.domain.repository.AuditListRepository
import javax.inject.Inject

class GetAuditDataUseCase @Inject constructor(
    private val auditListRepository: AuditListRepository
) {
    suspend operator fun invoke():List<Audit>{
        val response = auditListRepository.getAuditDataFromApi()
        return if(response.isNotEmpty()){
            auditListRepository.clearDataBase()
            auditListRepository.insertAuditData(response.map { it.toEntity() })
            response
        }else{
            auditListRepository.getAuditDataFromDB()
        }
    }
}