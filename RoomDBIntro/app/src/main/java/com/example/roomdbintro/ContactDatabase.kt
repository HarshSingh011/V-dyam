package com.example.roomdbintro

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import java.util.concurrent.locks.ReentrantLock

@Database(entities = [Contact::class], version = 1)
abstract class ContactDatabase : RoomDatabase() {
    abstract fun contactDAO(): ContactDAO

    companion object {
        @Voloatile
        private var INSTANCE: ContactDatabase? = null
        private val lock = ReentrantLock()

        fun getDatabase(context: Context): ContactDatabase {
            lock.lock()
            try {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(
                        context.applicationContext,
                        ContactDatabase::class.java,
                        "contact.db"
                    ).build()
                }
            } finally {
                lock.unlock()
            }
            return INSTANCE!!
        }
    }
}