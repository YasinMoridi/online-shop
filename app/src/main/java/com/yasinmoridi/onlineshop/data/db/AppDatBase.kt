package com.yasinmoridi.onlineshop.data.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.yasinmoridi.onlineshop.data.db.dao.FavoriteDao
import com.yasinmoridi.onlineshop.data.db.dao.ShoppingDao
import com.yasinmoridi.onlineshop.data.db.dao.UserDao
import com.yasinmoridi.onlineshop.data.db.entity.FavoriteEntity
import com.yasinmoridi.onlineshop.data.db.entity.ShoppingEntity
import com.yasinmoridi.onlineshop.data.db.entity.UserEntity

@Database(entities = [ShoppingEntity::class, FavoriteEntity::class, UserEntity::class], version = 1)
abstract class AppDatBase : RoomDatabase() {

    abstract fun ShoppingDao(): ShoppingDao
    abstract fun FavoriteDao(): FavoriteDao
    abstract fun UserDao():UserDao
}