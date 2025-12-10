package com.kw.rotinadeestudoscompose.data

import androidx.room.*
import kotlinx.coroutines.flow.Flow

@Dao
interface AtividadeDAO {

    @Query("SELECT * FROM atividades WHERE dia = :dia")
    fun getAtividadesPorDia(dia: String): Flow<List<Atividade>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun inserir(atividade: Atividade)

    @Update(onConflict = OnConflictStrategy.REPLACE)
    suspend fun atualizar(atividade: Atividade)

    @Delete
    suspend fun deletar(atividade: Atividade)

    @Query("SELECT * FROM atividades")
    fun getTodas(): Flow<List<Atividade>>
}
