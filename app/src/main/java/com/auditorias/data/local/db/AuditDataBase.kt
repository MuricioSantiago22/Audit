package com.auditorias.data.local.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.auditorias.data.local.dao.AuditDao
import com.auditorias.data.local.entities.AuditEntity


@Database(entities = [AuditEntity::class], version = 1)
abstract class AuditDataBase : RoomDatabase(){

    abstract fun getAuditDataDao(): AuditDao
}