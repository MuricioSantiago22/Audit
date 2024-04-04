package com.auditorias.data.remote.mapper

import com.auditorias.data.local.entities.AuditEntity
import com.auditorias.data.remote.entities.dto.AuditDto
import com.auditorias.domain.entities.Audit


fun AuditDto.toDomain()= Audit(
    audit = this.audit?:"",
    branch =this.branch?:"",
    startDate= this.startDate?:""
)
fun Audit.toEntity()= AuditEntity(
    id= 0,
    audit = this.audit ,
    branch= this.branch,
    startDate = this.startDate
)
