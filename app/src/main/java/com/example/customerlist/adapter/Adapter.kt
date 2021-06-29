/*package com.example.customerlist.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.customerlist.R
import com.example.customerlist.model.CustomerModel




class Adapter(private val customerList: ArrayList<CustomerModel>): RecyclerView.Adapter<Adapter.RowHolder>() {


    class RowHolder(itemview: View) : RecyclerView.ViewHolder(itemview) {
        lateinit var textView: TextView
        lateinit var textView1: TextView
        fun bind(customerModel: ArrayList<CustomerModel>){
            textView = itemView.findViewById(R.id.lName)
            textView1 = itemView.findViewById(R.id.name)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RowHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.row_layaout,parent,false)
        return RowHolder(view)
    }

    override fun onBindViewHolder(holder: RowHolder, position: Int) {
        holder.bind(customerList)
    }

    override fun getItemCount(): Int {
        return customerList.count()
    }


}


*/