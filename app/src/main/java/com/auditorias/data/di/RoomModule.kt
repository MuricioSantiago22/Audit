package com.auditorias.data.di

import android.content.Context
import androidx.room.Room
import com.auditorias.data.local.db.AuditDataBase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RoomModule {

    private const val AUDIT_DATABASE_NAME = "audit_database"

    @Singleton
    @Provides
    fun provideRoom(@ApplicationContext context: Context)=
        Room.databaseBuilder(context, AuditDataBase::class.java,AUDIT_DATABASE_NAME).build()

    @Singleton
    @Provides
    fun provideGetAuditData(db: AuditDataBase)= db.getAuditDataDao()
}