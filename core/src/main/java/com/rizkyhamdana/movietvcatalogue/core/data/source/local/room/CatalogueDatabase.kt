package com.rizkyhamdana.movietvcatalogue.core.data.source.local.room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.rizkyhamdana.movietvcatalogue.core.data.source.local.entity.MovieEntity
import com.rizkyhamdana.movietvcatalogue.core.data.source.local.entity.TvShowEntity

@Database(entities = [MovieEntity::class, TvShowEntity::class], version = 1, exportSchema = false)
abstract class CatalogueDatabase: RoomDatabase(){

    abstract fun catalogueDao(): CatalogueDao

}