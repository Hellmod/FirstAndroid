package com.example.myapplication


import android.content.Context
import android.view.LayoutInflater
import android.view.TextureView
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class MyAdapter(var ct: Context, var s1:Array<String>, var s2:Array<Int>): RecyclerView.Adapter<MyAdapter.MyViewHolder>(){

    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        lateinit var textView1:TextView
        lateinit var textView2:TextView

        init {
            textView1=itemView.findViewById(R.id.name)
            textView2=itemView.findViewById(R.id.price)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        var inflater:LayoutInflater= LayoutInflater.from(ct)
        var view:View= inflater.inflate(R.layout.product_row,parent,false)
        return MyViewHolder(view)
    }

    override fun getItemCount(): Int {
        return  s1.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.textView1.setText(s1[position])
        holder.textView2.setText(s2[position].toString())

    }

}

