package com.example.getirclone.database

import androidx.room.TypeConverter
import com.example.getirclone.model.Rating


class TypeConverter {

    @TypeConverter
    fun fromRating(rating: Rating) = rating.rate

    @TypeConverter
    fun toRating(double: Double) = Rating(double.toInt(), double)
}