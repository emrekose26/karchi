package com.emrekose.karchi.data.local.dao

import android.arch.persistence.room.Dao
import android.arch.persistence.room.Insert
import android.arch.persistence.room.OnConflictStrategy
import android.arch.persistence.room.Query
import com.emrekose.karchi.data.local.entity.Repos
import io.reactivex.Single

/**
 * Created by emrekose on 13.12.2017.
 */

@Dao
abstract class KarchiDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    abstract fun insertRepos(repoList: List<Repos>)

    @Query("SELECT * FROM repos WHERE username = :username")
    abstract fun getReposFromDb(username: String): Single<List<Repos>>
}