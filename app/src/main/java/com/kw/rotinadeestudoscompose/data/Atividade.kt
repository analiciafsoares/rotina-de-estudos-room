package com.kw.rotinadeestudoscompose.data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "atividades")
data class Atividade(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val dia: String,
    val descricao: String
)
