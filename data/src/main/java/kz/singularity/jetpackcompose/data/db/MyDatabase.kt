package kz.singularity.jetpackcompose.data.db

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import kz.singularity.jetpackcompose.data.db.converters.Converters
import kz.singularity.jetpackcompose.data.db.dao.PersonDAO
import kz.singularity.jetpackcompose.data.db.entity.Person

@Database(entities = [Person::class], version = 3)
@TypeConverters(Converters::class)
abstract class MyDatabase: RoomDatabase() {
    abstract fun personDAO(): PersonDAO
}