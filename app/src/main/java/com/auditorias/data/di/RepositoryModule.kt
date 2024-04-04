package com.auditorias.data.di

import com.auditorias.data.repository.AuditListRepositoryImpl
import com.auditorias.domain.repository.AuditListRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent


@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    @Binds
    abstract fun provideAuditListRepository(
        auditListRepositoryImpl: AuditListRepositoryImpl
    ): AuditListRepository
}