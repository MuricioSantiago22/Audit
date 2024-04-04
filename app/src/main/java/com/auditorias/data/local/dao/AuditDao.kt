package com.auditorias.data.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.auditorias.data.local.entities.AuditEntity


@Dao
interface AuditDao {




    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertListData(list:List<AuditEntity>)

    @Query("SELECT *  FROM audit_table ")
    suspend fun getListData(): List<AuditEntity>

    @Query("DELETE FROM audit_table")
    suspend fun deleteListData()

    @Update
    suspend fun updateImage(image:MutableList<AuditEntity>)
}