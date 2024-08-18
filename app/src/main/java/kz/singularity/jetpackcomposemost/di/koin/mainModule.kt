package kz.singularity.jetpackcomposemost.di.koin

import kz.singularity.jetpackcomposemost.example_koin.ClassWithParams
import kz.singularity.jetpackcomposemost.example_koin.ClassWithSeveralParams
import kz.singularity.jetpackcomposemost.example_koin.ClassWithoutParams
import kz.singularity.jetpackcomposemost.example_koin.Database
import kz.singularity.jetpackcomposemost.example_koin.RoomDatabase
import org.koin.dsl.module

val mainModule = module {
    factory<ClassWithoutParams> { ClassWithoutParams() }

    factory<ClassWithParams> { ClassWithParams(params = get()) }

    single<ClassWithSeveralParams> { ClassWithSeveralParams(param1 = get(), param2 = get()) }

    single<Database> {
        RoomDatabase()
    }

}


val modules = listOf(mainModule)
