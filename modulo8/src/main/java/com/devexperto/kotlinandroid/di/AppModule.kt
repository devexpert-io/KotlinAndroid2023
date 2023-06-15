package com.devexperto.kotlinandroid.di

import android.app.Application
import androidx.room.Room
import com.devexperto.kotlinandroid.data.TaskLocalDataSource
import com.devexperto.kotlinandroid.framework.RoomTaskLocalDataSource
import com.devexperto.kotlinandroid.framework.TaskDao
import com.devexperto.kotlinandroid.framework.TaskDatabase
import dagger.Binds
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

    @Provides
    @Singleton
    fun provideTaskDao(db: TaskDatabase): TaskDao = db.taskDao()

}

@InstallIn(SingletonComponent::class)
@Module
abstract class DataModule {

    @Binds
    abstract fun provideTaskLocalDataSource(ds: RoomTaskLocalDataSource): TaskLocalDataSource

}

