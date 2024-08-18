package kz.singularity.jetpackcomposemost

import android.app.Application
import dagger.hilt.android.HiltAndroidApp
import org.koin.core.context.startKoin

@HiltAndroidApp
class CustomApplication : Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin {
            modules(kz.singularity.jetpackcomposemost.di.koin.modules)
        }
    }
}