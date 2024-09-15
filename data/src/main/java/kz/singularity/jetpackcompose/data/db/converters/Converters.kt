package kz.singularity.jetpackcompose.data.db.converters

import android.icu.util.Calendar
import androidx.room.TypeConverter

class Converters {
    @TypeConverter
    fun calendarToTimestamp(calendar: Calendar): Long = calendar.timeInMillis

    @TypeConverter
    fun timestampToCalendar(value: Long): Calendar =
        Calendar.getInstance().apply { timeInMillis = value }
}
