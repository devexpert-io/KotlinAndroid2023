package com.devexperto.kotlinandroid.di

import android.app.Application
import androidx.room.Room
import com.devexperto.kotlinandroid.data.TaskLocalDataSource
import com.devexperto.kotlinandroid.data.TaskRepository
import com.devexperto.kotlinandroid.domain.AddTaskUseCase
import com.devexperto.kotlinandroid.domain.GetTasksUseCase
import com.devexperto.kotlinandroid.domain.UpdateTaskUseCase
import com.devexperto.kotlinandroid.framework.RoomTaskLocalDataSource
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

@InstallIn(SingletonComponent::class)
@Module
object DataModule {

    @Provides
    fun provideTaskLocalDataSource(db: TaskDatabase): TaskLocalDataSource =
        RoomTaskLocalDataSource(db.taskDao())

    @Provides
    fun provideTaskRepository(taskLocalDataSource: TaskLocalDataSource) =
        TaskRepository(taskLocalDataSource)
}

@InstallIn(SingletonComponent::class)
@Module
object UseCaseModule {

    @Provides
    fun provideGetTasksUseCase(repository: TaskRepository) = GetTasksUseCase(repository)

    @Provides
    fun provideAddTaskUseCase(repository: TaskRepository) = AddTaskUseCase(repository)

    @Provides
    fun provideUpdateTaskUseCase(repository: TaskRepository) = UpdateTaskUseCase(repository)
}

