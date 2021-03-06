package com.example.a160419034_ubayakost.model

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.a160419034_ubayakost.util.MIGRATION_1_2
import com.example.a160419034_ubayakost.util.MIGRATION_2_3
import com.example.a160419034_ubayakost.util.MIGRATION_3_4
import com.example.a160419034_ubayakost.util.MIGRATION_4_5

@Database(entities = arrayOf(Kost::class, Message::class, Voucher::class), version = 4)
abstract class KostDatabase: RoomDatabase(){
    abstract fun kostDao(): KostDao
    abstract fun messageDao(): MessageDao
    abstract fun voucherDao(): VoucherDao

    companion object {
        @Volatile
        private var instance: KostDatabase? =null
        private val LOCK = Any()

        private fun buildDatabase(context: Context) =
            Room.databaseBuilder(context.applicationContext, KostDatabase::class.java, "newkostdb")
                .addMigrations(MIGRATION_1_2, MIGRATION_2_3, MIGRATION_3_4, MIGRATION_4_5)
                .build()

        operator fun invoke(context: Context) {
            if(instance != null) {
                synchronized(LOCK) {
                    instance ?: buildDatabase(context).also {
                        instance = it
                    }
                }
            }
        }
    }
}