package com.kw.rotinadeestudoscompose.data

import androidx.room.*
import kotlinx.coroutines.flow.Flow

// DAO = Data Access Object.
// Aqui definimos todas as operações que serão feitas na tabela "atividades".
@Dao
interface AtividadeDAO {

    // Busca atividades filtradas por um dia específico.
    // Retorna um Flow, emitindo atualizações em tempo real.
    @Query("SELECT * FROM atividades WHERE dia = :dia")
    fun getAtividadesPorDia(dia: String): Flow<List<Atividade>>

    // Insere uma nova atividade. Substitui caso já exista (pelo ID).
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun inserir(atividade: Atividade)

    // Atualiza uma atividade existente.
    @Update(onConflict = OnConflictStrategy.REPLACE)
    suspend fun atualizar(atividade: Atividade)

    // Remove uma atividade do banco.
    @Delete
    suspend fun deletar(atividade: Atividade)

    // Retorna todas as atividades cadastradas.
    @Query("SELECT * FROM atividades")
    fun getTodas(): Flow<List<Atividade>>
}
