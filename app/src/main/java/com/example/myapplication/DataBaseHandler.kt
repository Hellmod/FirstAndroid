package com.example.myapplication

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.widget.Toast
import java.sql.PreparedStatement

val DATABASE_NAME ="MyDB"
val TABLE_NAME = "Product"
val COL_NAME = "name"
val COL_PRICE = "price"
val COL_ID = "id"

class DataBaseHandler(var context: Context):SQLiteOpenHelper(context, DATABASE_NAME,null,1){
    override fun onCreate(db: SQLiteDatabase?) {
        val createTable = "CREATE TABLE " + TABLE_NAME +" (" +
                COL_ID +" INTEGER PRIMARY KEY AUTOINCREMENT," +
                COL_NAME + " VARCHAR(256)," +
                COL_PRICE +" DOUBLE)"

        db?.execSQL(createTable)
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        TODO("Not yet implemented")
    }

    fun insertData(product : Product){
        val db = this.writableDatabase
        var cv = ContentValues()
        cv.put(COL_NAME,product.name)
        cv.put(COL_PRICE,product.price)
        var result = db.insert(TABLE_NAME,null,cv)
        if(result == -1.toLong())
            Toast.makeText(context,"Failed",Toast.LENGTH_SHORT).show()
        else
            Toast.makeText(context,"Success",Toast.LENGTH_SHORT).show()
    }

    fun readData() : MutableList<Product>{
        var list : MutableList<Product> = ArrayList()

        val db = this.readableDatabase
        val query = "Select * from " + TABLE_NAME
        val result = db.rawQuery(query,null)
        if(result.moveToFirst()){
            do {
                var product = Product()
                product.id = result.getString(result.getColumnIndex(COL_ID)).toInt()
                product.name = result.getString(result.getColumnIndex(COL_NAME))
                product.price = result.getString(result.getColumnIndex(COL_PRICE)).toDouble()
                list.add(product)
            }while (result.moveToNext())
        }

        result.close()
        db.close()
        return list
    }

    fun deleteData(){
        val db = this.writableDatabase
        db.delete(TABLE_NAME,null,null)
        db.close()
    }

    fun updateData(id:Int,name:String){
        val db = this.writableDatabase
        val productVlue : ContentValues = ContentValues()
        productVlue.put(COL_NAME,name)
        db.update(TABLE_NAME,productVlue,"id=?", arrayOf(id.toString()))
    }

    fun updateData() {
        val db = this.writableDatabase
        val query = "Select * from " + TABLE_NAME
        val result = db.rawQuery(query,null)

        if(result.moveToFirst()){
            do {
                var cv = ContentValues()
                cv.put(COL_PRICE,(result.getInt(result.getColumnIndex(COL_PRICE))+1))
                db.update(TABLE_NAME,cv,COL_ID + "=? AND " + COL_NAME + "=?",
                    arrayOf(result.getString(result.getColumnIndex(COL_ID)),
                        result.getString(result.getColumnIndex(COL_NAME))))
            }while (result.moveToNext())
        }

        result.close()
        db.close()
    }


}