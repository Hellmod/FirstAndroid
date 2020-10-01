package com.example.myapplication


import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class MyAdapterProduct(var ct: Context, var listOfProduct:MutableList<Product>): RecyclerView.Adapter<MyAdapterProduct.MyViewHolder>(){

    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        lateinit var textViewName:TextView
        lateinit var textViewPrice:TextView

        init {
            textViewName=itemView.findViewById(R.id.name)
            textViewPrice=itemView.findViewById(R.id.price)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        var inflater:LayoutInflater= LayoutInflater.from(ct)
        var view:View= inflater.inflate(R.layout.product_row,parent,false)
        return MyViewHolder(view)
    }

    override fun getItemCount(): Int {
        return  listOfProduct.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.textViewName.setText(listOfProduct.get(position).name)
        holder.textViewPrice.setText(listOfProduct.get(position).price.toString())
        /*
        holder.textView1.setText(s1[position])
        holder.textView2.setText(s2[position].toString())

         */

    }

}

