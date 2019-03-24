package com.blogspot.alexeykutovenko.daizily.db

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity (tableName = "todo_items")
class TodoEntity (@PrimaryKey(autoGenerate = true)@ColumnInfo(name = "id") val id: Long? = null,
                  @ColumnInfo(name = "todo_text") var text: String = "",
                  @ColumnInfo(name = "date_created") val dateCreated: String = "",
                  @ColumnInfo(name = "date_completed") var dateCompleted: String? = "")