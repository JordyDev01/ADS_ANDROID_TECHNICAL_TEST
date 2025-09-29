package com.jordydev.ads_android_technical_test_jordy_etienne.di

import com.jordydev.ads_android_technical_test_jordy_etienne.data.TimeStampRepository
import com.jordydev.ads_android_technical_test_jordy_etienne.domain.TimeStampEvent
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


/*
* using dagger hilt to inject the repository into the viewmodel of each View so that the same
* instance of the repository is used for each viewmodel
* */
@Module
@InstallIn(SingletonComponent::class)
 abstract class AppModule {
    @Binds
    @Singleton
     abstract fun bindTimestampEvent(impl: TimeStampRepository): TimeStampEvent
}