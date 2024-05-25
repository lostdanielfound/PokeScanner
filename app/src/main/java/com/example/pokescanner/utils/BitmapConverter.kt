package com.example.pokescanner.utils

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.util.Base64
import android.util.Log
import java.io.ByteArrayOutputStream

object BitmapConverter {
    fun converterBitmapToString(bitmap: Bitmap): String {
        val baos = ByteArrayOutputStream()
        bitmap.compress(Bitmap.CompressFormat.JPEG, 70, baos)
        val byteArray = baos.toByteArray()
        return Base64.encodeToString(byteArray, Base64.DEFAULT)
    }

    fun converterStringToBitmap(encodedString: ByteArray): Bitmap? {
        return try {
            val encodeByte = Base64.decode(encodedString.toString(), Base64.DEFAULT)
            BitmapFactory.decodeByteArray(encodeByte, 0, encodeByte.size)
        } catch (e: Exception) {
            Log.e("convertStringToBitmap", "Failed to convert string to bitmap. ")
            e.printStackTrace()
            null
        }
    }
}