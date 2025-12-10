package com.kw.rotinadeestudoscompose.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [Atividade::class], version = 1)
abstract class RotinaDatabase : RoomDatabase() {

    abstract fun atividadeDao(): AtividadeDAO

    companion object {
        @Volatile private var INSTANCE: RotinaDatabase? = null

        fun getDatabase(context: Context): RotinaDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    RotinaDatabase::class.java,
                    "rotina_db"
                ).build()
                INSTANCE = instance
                instance
            }
        }
    }
}
