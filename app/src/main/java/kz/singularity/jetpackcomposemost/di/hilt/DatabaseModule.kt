package kz.singularity.jetpackcomposemost.di.hilt

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent
import kz.singularity.jetpackcomposemost.example_hilt.HiltDatabase
import kz.singularity.jetpackcomposemost.example_hilt.HiltRoomDatabase

@Module
@InstallIn(ActivityComponent::class)
abstract class DatabaseModule {

    @Binds
    abstract fun bindDatabase(
        impl: HiltRoomDatabase
    ): HiltDatabase
}
