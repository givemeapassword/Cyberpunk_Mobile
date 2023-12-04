package com.example.rp_cyberpunk_list.db

import android.provider.BaseColumns

object MyDBNameClass:BaseColumns {
    const val TABLE_NAME = "Card_table"
    const val COLUMN_NAME_TEXT = "Card_name"
    const val COLUMN_NAME_IMAGE = "Card_image"
    const val COLUMN_NAME_CLASS = "Card_class"

    const val DATABASE_VERSION = 1

    const val CREATE_TABLE =
        "CREATE TABLE IF NOT EXISTS $TABLE_NAME (${BaseColumns._ID} INTEGER PRIMARY KEY," +
                "$COLUMN_NAME_IMAGE TEXT, $COLUMN_NAME_TEXT TEXT, $COLUMN_NAME_CLASS TEXT)"

    const val DROP_TABLE =
        "DROP TABLE IF EXISTS $TABLE_NAME"

    const val SELECT_ALL =
        "SELECT * FROM $TABLE_NAME"
}