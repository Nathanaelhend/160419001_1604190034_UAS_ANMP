package com.example.a160419034_ubayakost.util

import android.content.Context
import android.view.View
import android.widget.ImageView
import android.widget.ProgressBar
import androidx.databinding.BindingAdapter
import androidx.room.Room
import androidx.room.migration.Migration
import androidx.sqlite.db.SupportSQLiteDatabase
import com.example.a160419034_ubayakost.R
import com.example.a160419034_ubayakost.model.KostDatabase
import com.squareup.picasso.Callback
import com.squareup.picasso.Picasso
import java.lang.Exception

val DB_NAME = "newkostdb"

@BindingAdapter("imageUrl", "progressBar")
fun loadImageFromUrl(view: ImageView, url: String?, pb: ProgressBar) {
    view.loadImage(url,pb)
}

fun ImageView.loadImage(url: String?, progressBar : ProgressBar){
    Picasso.get()
        .load(url)
        .resize(400,400)
        .centerCrop()
        .error(R.drawable.ic_baseline_error_24)
        .into(this, object : Callback{
            override fun onSuccess() {
                progressBar.visibility = View.GONE
            }

            override fun onError(e: Exception?) { }
        })
}

fun buildDb(context: Context) = Room.databaseBuilder(context, KostDatabase::class.java, DB_NAME)
    .addMigrations(MIGRATION_1_2, MIGRATION_2_3, MIGRATION_3_4)
    .build()

val MIGRATION_1_2 = object : Migration(1, 2) {
    override fun migrate(database: SupportSQLiteDatabase) {
        database.execSQL(
            "ALTER TABLE kost ADD COLUMN nama STRING DEFAULT NULL"
        )
    }
}
val MIGRATION_2_3 = object : Migration(2, 3) {
    override fun migrate(database: SupportSQLiteDatabase) {
        database.execSQL("ALTER TABLE kost ADD COLUMN jenis STRING DEFAULT NULL")
    }
}

val MIGRATION_3_4 = object : Migration(3, 4) {
    override fun migrate(database: SupportSQLiteDatabase) {
        database.execSQL(
            "ALTER TABLE message ADD COLUMN isi STRING DEFAULT NULL"
        )
    }
}

