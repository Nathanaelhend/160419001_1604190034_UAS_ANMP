package com.example.a160419034_ubayakost.model

import androidx.room.*

@Dao
interface MessageDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(vararg message: Message)

    @Query("SELECT * FROM message ORDER BY id ASC")
    suspend fun selectAllMessage(): List<Message>

    @Query("SELECT * FROM message WHERE id = :id")
    suspend fun selectMessage(id:Int): Message
}