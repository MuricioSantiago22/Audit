package com.auditorias.presentation.di

import com.auditorias.domain.useCase.GetAuditDataUseCase
import com.auditorias.presentation.di.CoroutineScopeModule.provideIOCoroutineContext
import com.auditorias.presentation.viewModel.AuditViewModel
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent

@Module
@InstallIn(ActivityComponent::class)
object ViewModelModule {

    @Provides
    fun providerAuditViewModel(
        getAuditDataUseCase: GetAuditDataUseCase
    ): AuditViewModel{
        return AuditViewModel(getAuditDataUseCase, provideIOCoroutineContext())
    }
}