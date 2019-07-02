package com.ashish.echo.database

import android.content.ContentValues
import android.content.Context
import android.database.DatabaseErrorHandler
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class EchoDatabase :SQLiteOpenHelper{
    val DB_NAME="FavouriteDatabase"
    val TABLE_NAME="FavouriteTable"
    val COLUMN_ID="SongID"
    val COLUMN_SONG_TITLE="SongTitle"
    val COLUMN_SONG_ARTIST="SongArtist"
    val COLUMN_SONG_PATH="SongPath"

    
      
    override fun onCreate(sqliteDatabase: SQLiteDatabase?) {
        sqliteDatabase?.execSQL("CREATE TABLE"+TABLE_NAME + " ( "+COLUMN_ID+ "INTEGER," + COLUMN_SONG_ARTIST +" STRING,"+COLUMN_SONG_TITLE+ "STRING,"+COLUMN_SONG_PATH+ " STRING);")
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
       
    }

    constructor(context: Context?, name: String?, factory: SQLiteDatabase.CursorFactory?, version: Int) : super(
        context,
        name,
        factory,
        version
    )
    fun storeAsFavoourite(id:Int?,artist:String?,songTitle:String?,path:String?){
        val db=this.writableDatabase
        var contentValues=ContentValues()
        contentValues.put(COLUMN_ID,id)
        contentValues.put(COLUMN_SONG_ARTIST,artist)
        contentValues.put(COLUMN_SONG_TITLE,songTitle)
        contentValues.put(COLUMN_SONG_PATH,path)
        db.insert(TABLE_NAME,null,contentValues)
        db.close()
    }



}