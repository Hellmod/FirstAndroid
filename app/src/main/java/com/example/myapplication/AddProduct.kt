package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_add_product.*


class AddProduct : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_product)
        var db = DataBaseHandler(this)




        buttonOK.setOnClickListener{
            if(editTextName.text!=null && editTextPrice.text!=null){
                var product = Product(editTextName.text.toString(), editTextPrice.text.toString().toDouble())
                db.insertData(product)
                //db.updateData(1,plainText.text.toString())
                var nowaAktywnosc: Intent = Intent(applicationContext,MainActivity::class.java)
                startActivity(nowaAktywnosc)
                //cos dla git
            }else{
                Toast.makeText(this,"Pole nie może być puste!", Toast.LENGTH_LONG).show()
            }



        }

    }
}