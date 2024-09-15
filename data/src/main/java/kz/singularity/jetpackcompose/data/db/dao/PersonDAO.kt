package kz.singularity.jetpackcompose.data.db.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kz.singularity.jetpackcompose.data.db.entity.Person

@Dao
interface PersonDAO {


   // fun getPerson(id: Int): Person

    @Query("SELECT * FROM Person") // запрос в таблицу
    fun getAll(): List<Person>

    @Query("SELECT * FROM Person WHERE id IN (:userIds)")
    fun loadAllByIds(userIds: IntArray): List<Person>

    @Query("SELECT * FROM Person WHERE name LIKE :name LIMIT 1")
    fun findByName(name: String): Person

    @Insert(onConflict = OnConflictStrategy.REPLACE) // добавление в таблицу
    fun insertAll(vararg users: Person)

    @Insert(onConflict = OnConflictStrategy.REPLACE) // добавление в таблицу
    fun insertAll(users: List<Person>)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(user: Person)

    @Delete // удаление из таблицы
    fun delete(user: Person)


}