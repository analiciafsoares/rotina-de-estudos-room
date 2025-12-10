package com.kw.rotinadeestudoscompose.data

import androidx.room.Entity
import androidx.room.PrimaryKey

// Marca esta classe como uma entidade do Room, que será uma tabela no banco de dados.
// O nome da tabela será "atividades".
@Entity(tableName = "atividades")
data class Atividade(
    // Chave primária da tabela. "autoGenerate = true" faz o Room gerar IDs automaticamente.
    @PrimaryKey(autoGenerate = true) val id: Int = 0,

    // Coluna "dia": indica o dia da semana (segunda, terça etc.)
    val dia: String,

    // Coluna "descricao": descreve a atividade (ex: "Estudar matemática")
    val descricao: String
)
