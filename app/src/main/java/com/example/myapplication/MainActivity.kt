package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

import kotlinx.android.synthetic.main.products.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.products)

        var db = DataBaseHandler(this)
        //db.insertData(Product("Name",1.0))
        /*
        download.setOnClickListener{
            var product = Product(plainText.text.toString(),1.0)
            db.updateData(1,plainText.text.toString())
            var tekst:MutableList<Product> = db.readData()
            textView.setText(tekst.get(0).name)
        }

         */
        buttonAdd.setOnClickListener{
            var nowaAktywnosc:Intent = Intent(applicationContext,Book::class.java)
            startActivity(nowaAktywnosc)
        }


        var listOfProduct:MutableList<Product> = db.readData()


        recycleView.layoutManager = LinearLayoutManager(this)
        recycleView.adapter

        var myAdapter:MyAdapterProduct= MyAdapterProduct(this, listOfProduct)
        recycleView.setAdapter(myAdapter)
        recycleView.setLayoutManager(LinearLayoutManager(this))


    }

    override fun onStart() {
        super.onStart()
        /*
        super.onStart()
        var db = DataBaseHandler(this)
        var tekst:MutableList<Product> = db.readData()
        textView.setText(tekst.get(0).name)

         */
    }

    fun addactivity(view: View){
        var nowaAktywnosc:Intent = Intent(applicationContext,AddProduct::class.java)
        startActivity(nowaAktywnosc)
    }
}