package com.chrrissoft.marvel.framework.db.converters

import android.graphics.Bitmap
import android.graphics.Bitmap.CompressFormat.JPEG
import android.graphics.BitmapFactory
import androidx.room.TypeConverter
import java.io.ByteArrayOutputStream

class BitmapConverter {
    @TypeConverter
    fun fromJson(byte: ByteArray) : Bitmap {
        return BitmapFactory.decodeByteArray(byte, 0, byte.size)
    }

    @TypeConverter
    fun toJson(bitmap: Bitmap) : ByteArray {
        val outputStream = ByteArrayOutputStream()
        bitmap.compress(JPEG, 100, outputStream)
        return outputStream.toByteArray()
    }
}