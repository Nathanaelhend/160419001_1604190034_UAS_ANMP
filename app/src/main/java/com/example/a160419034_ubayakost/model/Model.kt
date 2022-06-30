package com.example.a160419034_ubayakost.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity
data class Kost(
    @SerializedName("nama")
    var nama:String?,
    @ColumnInfo(name = "jenis")
    var jenis:String?,
    @SerializedName("rating")
    var rating:String?,
    var wilayah:String?,
    var descr:String?,
    var phone:String?,
    var harga:String?,
    var address: String?,
    @SerializedName("photo")
    var photo:String?
)
{
    @PrimaryKey(autoGenerate = true)
    var uuid: Int = 0
}

@Entity
data class Message(
    @ColumnInfo(name = "isi")
    var isi:String?,
)
{
    @PrimaryKey(autoGenerate = true)
    var id:Int= 0
}

data class Favorite(
    var id:String?,
    var nama:String?,
    var wilayah: String?,
    var jenis: String?,
    var rating: String?,
    var photo: String?,
    var harga: String?)

@Entity
data class Voucher(
    var judul:String?,
    var description: String?,
    var expDate: String?,
    var photo: String?)
{
    @PrimaryKey(autoGenerate = true)
    var id:Int= 0
}