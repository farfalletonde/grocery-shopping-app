package com.example.getirclone.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.getirclone.model.Product

@Database(entities = [Product::class], version = 1)
abstract class BasketDatabase : RoomDatabase() {

    abstract fun getProductDao(): BasketDatabaseDao

    companion object {
        @Volatile
        private var instance: BasketDatabase? = null
        private val LOCK = Any()

        operator fun invoke(context: Context) = instance ?: synchronized(LOCK) {
            instance ?: createDatabase(context).also { instance = it }
        }

        private fun createDatabase(context: Context) =
            Room.databaseBuilder(
                context.applicationContext,
                BasketDatabase::class.java,
                "basket_db.db"
            ).build()
    }
}