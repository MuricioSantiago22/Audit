package com.auditorias.data.local.mapper

import com.auditorias.data.local.entities.AuditEntity
import com.auditorias.domain.entities.Audit

fun AuditEntity.toDomain()= Audit(
    audit = this.audit,
    branch= this.branch,
    startDate = this.startDate
)