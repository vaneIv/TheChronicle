package com.vane.android.thechronicle.utils

import androidx.room.TypeConverter
import com.vane.android.thechronicle.api.model.Source


class Converters {

    @TypeConverter
    fun fromSource(source: Source): String {
        return source.name
    }

    @TypeConverter
    fun toSource(name: String): Source {
        return Source(name, name)
    }
}