package com.auditorias.data.local.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "audit_table")
data class AuditEntity(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id") var id: Int,
    @ColumnInfo(name = "audit") var audit: String,
    @ColumnInfo(name= "branch") var branch: String,
    @ColumnInfo(name= "start_date") var startDate: String
)
