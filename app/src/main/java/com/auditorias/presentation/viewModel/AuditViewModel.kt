package com.auditorias.presentation.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.auditorias.domain.entities.Audit
import com.auditorias.domain.useCase.GetAuditDataUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject
import kotlin.coroutines.CoroutineContext


@HiltViewModel
class AuditViewModel@Inject constructor(
    private val getAuditDataUseCase: GetAuditDataUseCase,
    private val coroutineContext: CoroutineContext
):ViewModel() {

    private val _auditDataList : MutableLiveData<List<Audit>> = MutableLiveData()
    val auditDataList: LiveData<List<Audit>> get() = _auditDataList

    init {
        getAuditData()
    }

    private fun getAuditData(){
        viewModelScope.launch(coroutineContext){
            val response = getAuditDataUseCase()
            withContext(Dispatchers.Main){
                if(response.isNotEmpty()){
                    _auditDataList.value = response
                }
            }

        }
    }
}