package com.example.rp_cyberpunk_list.db

import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.provider.BaseColumns
import com.example.rp_cyberpunk_list.Characters

class MySQLManager(context: Context) {
    private val myDBHelper = MySQLHelper(context)
    private lateinit var db: SQLiteDatabase

    private fun openDb() { db = myDBHelper.writableDatabase }

    fun insertToDb(name: String, text: String, image: String){
        openDb()
        val values = ContentValues().apply {
            put(MyDBNameClass.COLUMN_NAME_TEXT, name)
            put(MyDBNameClass.COLUMN_NAME_CLASS, text)
            put(MyDBNameClass.COLUMN_NAME_IMAGE, image)
        }
        db.insert(MyDBNameClass.TABLE_NAME, null, values)
        //closeDb()
    }

    fun getAllCards(): ArrayList<Characters>{
        openDb()
        val cards = ArrayList<Characters>()
        val cursor: Cursor = db.rawQuery(MyDBNameClass.SELECT_ALL, null)
        with(cursor){
            if(moveToFirst()){
                do {
                    val text = getString(cursor.getColumnIndexOrThrow(MyDBNameClass.COLUMN_NAME_CLASS))
                    val name = getString(cursor.getColumnIndexOrThrow(MyDBNameClass.COLUMN_NAME_TEXT))
                    val image = getString(cursor.getColumnIndexOrThrow(MyDBNameClass.COLUMN_NAME_IMAGE))
                    val id = cursor.getString(cursor.getColumnIndexOrThrow(BaseColumns._ID))
                    val card = Characters(id,image,name,text)
                    cards.add(card)
                } while (moveToNext())
            }
            close()
        }
        //closeDb()
        return cards
    }

    fun deleteFromDb(id: String){
        openDb()
        db.delete(MyDBNameClass.TABLE_NAME,"_id=${id}",null)
        closeDb()
    }

    private fun closeDb():Unit = myDBHelper.close()
}