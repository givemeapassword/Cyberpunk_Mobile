package com.example.rp_cyberpunk_list.db

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

open class MySQLHelper(context: Context): SQLiteOpenHelper(context,MyDBNameClass.TABLE_NAME,
    null, MyDBNameClass.DATABASE_VERSION) {
    override fun onCreate(db: SQLiteDatabase?) {
        db?.execSQL(MyDBNameClass.CREATE_TABLE)
    }

    override fun onUpgrade(db: SQLiteDatabase?, p1: Int, p2: Int) {
        db?.execSQL(MyDBNameClass.DROP_TABLE)
        onCreate(db)
    }

}