package com.example.localdatastore.hero

import android.arch.persistence.room.*
import io.reactivex.Flowable

@Dao
abstract class FavoriteDao {

    @Query("SELECT * FROM Favorite")
    abstract fun getFavorites(): Flowable<List<Favorite>?>

    @Query("SELECT * FROM Favorite WHERE id = :idHero")
    abstract fun getFavoriteById(idHero: Int): Flowable<Favorite?>

    @Insert(onConflict = OnConflictStrategy.FAIL)
    abstract fun insertFavorite(favorite: Favorite)

    @Delete
    abstract fun deleteFavorite(favorite: Favorite)
}