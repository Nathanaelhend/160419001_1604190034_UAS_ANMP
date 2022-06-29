package com.example.a160419034_ubayakost.model

import androidx.room.*

@Dao
interface UserDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(vararg user: User)

    @Query("SELECT * FROM user WHERE username=:username AND password=:password")
    suspend fun selectLogin(username: String,password:String): User
}