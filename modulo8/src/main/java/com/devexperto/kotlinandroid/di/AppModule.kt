package com.devexperto.kotlinandroid.di

import android.app.Application
import androidx.room.Room
import com.devexperto.kotlinandroid.framework.TaskDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
object AppModule {

    @Provides
    @Singleton
    fun provideDatabase(app: Application): TaskDatabase = Room
        .databaseBuilder(app, TaskDatabase::class.java, "task-db")
        .build()

}