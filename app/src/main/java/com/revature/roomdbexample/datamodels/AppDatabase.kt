package com.revature.roomdbexample.datamodels

import android.content.Context
import androidx.room.*

@Database(version = 1, entities = [Customer::class], exportSchema = false)
abstract class AppDatabase: RoomDatabase(){

    companion object{

        @Volatile
        private var INSTANCE:AppDatabase? = null

        fun getDatabase(context:Context):AppDatabase{

            val tempInstance = INSTANCE
            if (tempInstance != null) {
                return tempInstance
            }
            synchronized(lock = this) {
                var instance = Room.databaseBuilder(context.applicationContext,
                AppDatabase::class.java,"ExampleDatabase").build()

                INSTANCE = instance

                return instance
            }
        }
    }
}