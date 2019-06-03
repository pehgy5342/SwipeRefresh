package com.example.pulltorequest

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.view_item.view.*

class MyAdapter(val list: ArrayList<MyData>) : RecyclerView.Adapter<MyAdapter.CustomerHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CustomerHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.view_item, parent, false)
        return CustomerHolder(view)

    }

    override fun getItemCount(): Int = list.size

    override fun onBindViewHolder(holder: CustomerHolder, position: Int) {


        holder.bind(list[position])
    }


    inner class CustomerHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        val name = itemView.tv_name
//        val image = itemView.iv_image

        fun bind(data: MyData) {

            name.text = data.name

//            Glide.with(itemView.context).load(list).into(image)


        }


    }


}