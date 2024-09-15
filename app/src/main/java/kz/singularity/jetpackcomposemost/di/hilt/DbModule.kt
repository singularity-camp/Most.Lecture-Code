package kz.singularity.jetpackcomposemost.di.hilt

import android.content.Context
import androidx.room.Room
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import kz.singularity.jetpackcompose.data.db.MyDatabase
import kz.singularity.jetpackcompose.data.db.dao.PersonDAO

@Module
@InstallIn(SingletonComponent::class)
class DbModule {

    @Provides
    fun provideMyDatabase(@ApplicationContext applicationContext: Context): MyDatabase {
        val db = Room.databaseBuilder(applicationContext, MyDatabase::class.java, "my-database")
// .addMigrations(MigrationFromVersion1ToVersion2()) // миграция БД
 .allowMainThreadQueries() // разрешить работу с БД на основном потоке
// .createFromAsset("pre_populated_database_file") // создать БД из подставленного файла (данных)
 .fallbackToDestructiveMigration() // очистить в случае ошибки миграции
// .setQueryExecutor(SomeExecutor()) // задать Executor для запросов в фоновом режиме
            .build()
        return db
    }

    @Provides
    fun providesPersonDao(myDb: MyDatabase): PersonDAO {
        return myDb.personDAO()
    }

}