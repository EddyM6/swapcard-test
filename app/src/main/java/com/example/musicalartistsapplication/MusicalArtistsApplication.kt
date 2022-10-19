package com.example.musicalartistsapplication

import android.app.Application
import androidx.viewbinding.BuildConfig
import com.example.musicalartistsapplication.core.extension.d
import com.example.musicalartistsapplication.common.data.setup.di.commonDataModule
import com.example.musicalartistsapplication.common.domain.setup.di.commonDomainModule
import com.example.musicalartistsapplication.common.presentation.setup.di.commonPresentationModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import timber.log.Timber

class MusicalArtistsApplication : Application() {

    override fun onCreate() {
        super.onCreate()

        d {
            "onCreate: MusicalArtistsApplication!"
        }

        startKoin {
            androidLogger()
            androidContext(this@MusicalArtistsApplication)
            modules(
                listOf(
                    commonDataModule,
                    commonDomainModule,
                    commonPresentationModule
                )
            )
        }

        if (BuildConfig.DEBUG) {
            Timber.plant(Timber.DebugTree())
        }
    }
}