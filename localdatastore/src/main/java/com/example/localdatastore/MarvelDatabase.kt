package com.example.localdatastore

import android.arch.persistence.room.Database
import android.arch.persistence.room.Room
import android.arch.persistence.room.RoomDatabase
import android.content.Context
import com.example.localdatastore.hero.Favorite
import com.example.localdatastore.hero.FavoriteDao

@Database(entities = [Favorite::class], version = 1)
abstract class MarvelDatabase : RoomDatabase() {

    abstract fun getFavoriteDao(): FavoriteDao

    companion object {

        @Volatile
        private var INSTANCE: MarvelDatabase? = null

        fun getInstance(context: Context): MarvelDatabase =
            INSTANCE ?: synchronized(this) {
                INSTANCE
                    ?: buildDatabase(context).also { INSTANCE = it }
            }

        private fun buildDatabase(context: Context) =
            Room.databaseBuilder(
                context.applicationContext,
                MarvelDatabase::class.java, "Heroes.db"
            ).build()
    }

}