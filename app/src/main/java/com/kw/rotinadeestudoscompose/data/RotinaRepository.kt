package com.kw.rotinadeestudoscompose.data

import kotlinx.coroutines.flow.Flow

// Repository: faz a ponte entre o DAO e o resto do app.
// Ele esconde os detalhes do banco e simplifica o acesso aos dados.
class RotinaRepository(private val dao: AtividadeDAO) {

    // Obtém atividades filtradas por dia.
    fun getAtividadesPorDia(dia: String): Flow<List<Atividade>> =
        dao.getAtividadesPorDia(dia)

    // Insere uma nova atividade.
    suspend fun addAtividade(dia: String, descricao: String) {
        dao.inserir(Atividade(dia = dia, descricao = descricao))
    }

    // Apaga uma atividade.
    suspend fun deletarAtividade(atividade: Atividade) {
        dao.deletar(atividade)
    }

    // Atualiza uma atividade.
    suspend fun editarAtividade(atividade: Atividade) {
        dao.atualizar(atividade)
    }

    // Retorna todas as atividades cadastradas.
    fun getResumo(): Flow<List<Atividade>> = dao.getTodas()
}
