package com.blogspot.alexeykutovenko.daizily.db

import androidx.room.Insert
import androidx.room.OnConflictStrategy.REPLACE
import androidx.room.Query

interface TodoDao {
    @Query("SELECT * from todo_items")
    fun getAll(): List<TodoEntity>

    @Insert(onConflict = REPLACE)
    fun insert(todoData: TodoEntity)

    @Query("DELETE from todo_items")
    fun deleteAll()
}