package com.kw.rotinadeestudoscompose.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.kw.rotinadeestudoscompose.data.RotinaRepository
import com.kw.rotinadeestudoscompose.data.Atividade
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch

class RotinaViewModel(private val repository: RotinaRepository) : ViewModel() {

    fun atividadesPorDia(dia: String): Flow<List<Atividade>> =
        repository.getAtividadesPorDia(dia)

    fun addAtividade(dia: String, desc: String) {
        viewModelScope.launch {
            repository.addAtividade(dia, desc)
        }
    }

    fun deletar(atividade: Atividade) {
        viewModelScope.launch {
            repository.deletarAtividade(atividade)
        }
    }

    fun editar(atividade: Atividade) {
        viewModelScope.launch {
            repository.editarAtividade(atividade)
        }
    }

    val resumo: Flow<Map<String, Int>> =
        repository.getResumo().map { lista ->
            lista.groupBy { it.dia }.mapValues { it.value.size }
        }
}
