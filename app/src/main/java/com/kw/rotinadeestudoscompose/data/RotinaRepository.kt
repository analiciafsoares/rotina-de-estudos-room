package com.kw.rotinadeestudoscompose.data

import kotlinx.coroutines.flow.Flow

class RotinaRepository(private val dao: AtividadeDAO) {

    fun getAtividadesPorDia(dia: String): Flow<List<Atividade>> =
        dao.getAtividadesPorDia(dia)

    suspend fun addAtividade(dia: String, descricao: String) {
        dao.inserir(Atividade(dia = dia, descricao = descricao))
    }

    suspend fun deletarAtividade(atividade: Atividade) {
        dao.deletar(atividade)
    }

    suspend fun editarAtividade(atividade: Atividade) {
        dao.atualizar(atividade)
    }

    fun getResumo(): Flow<List<Atividade>> = dao.getTodas()
}
