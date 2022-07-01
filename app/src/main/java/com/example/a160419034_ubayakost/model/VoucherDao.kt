package com.example.a160419034_ubayakost.model

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface VoucherDao {
    @Query("SELECT * FROM voucher ORDER BY id ASC")
    suspend fun selectAllVoucher(): List<Voucher>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(vararg voucher: Voucher)
}