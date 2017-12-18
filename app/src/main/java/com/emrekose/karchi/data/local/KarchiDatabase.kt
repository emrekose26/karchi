package com.emrekose.karchi.data.local

import android.arch.persistence.room.Database
import android.arch.persistence.room.RoomDatabase
import com.emrekose.karchi.data.local.dao.KarchiDao
import com.emrekose.karchi.data.local.entity.Repos
import com.emrekose.karchi.data.local.entity.User

/**
 * Created by emrekose on 11.12.2017.
 */

@Database(entities = arrayOf(User::class, Repos::class), version = 1, exportSchema = false)
abstract class KarchiDatabase: RoomDatabase() {
    abstract fun karchiDao(): KarchiDao
}