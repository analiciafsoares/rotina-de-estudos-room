package com.kw.rotinadeestudoscompose.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

// Declara o banco Room, indicando as entidades e a versão.
@Database(entities = [Atividade::class], version = 1)
abstract class RotinaDatabase : RoomDatabase() {

    // Expõe o DAO para o app poder acessar os métodos.
    abstract fun atividadeDao(): AtividadeDAO

    companion object {
        // Instância única do banco (Singleton).
        @Volatile private var INSTANCE: RotinaDatabase? = null

        // Metodo que cria ou retorna a instancia do banco
        fun getDatabase(context: Context): RotinaDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    // Usa o contexto da aplicação para evitar memory leaks.
                    context.applicationContext,
                    RotinaDatabase::class.java,
                    // Nome do arquivo físico do banco.
                    "rotina_db"
                ).build()

                // Guarda a instância criada.
                INSTANCE = instance
                instance
            }
        }
    }
}
