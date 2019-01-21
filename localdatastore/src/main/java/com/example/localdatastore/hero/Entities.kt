package com.example.localdatastore.hero

import android.arch.persistence.room.ColumnInfo
import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey
import com.example.model.Hero

@Entity(tableName = "favorite")
data class Favorite(
    @PrimaryKey @ColumnInfo(name = "id")
    override val id: Int,

    @ColumnInfo(name = "name")
    override val name: String,

    @ColumnInfo(name = "photo")
    override val photo: String,

    @ColumnInfo(name = "description")
    override val description: String,

    @ColumnInfo(name = "resourceUri")
    override val resourceUri: String
) : Hero