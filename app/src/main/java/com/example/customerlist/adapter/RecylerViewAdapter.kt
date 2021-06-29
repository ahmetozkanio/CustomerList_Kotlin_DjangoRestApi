package com.example.customerlist.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.customerlist.R
import com.example.customerlist.model.CustomerModel


class RecylerViewAdapter(private val customerList :ArrayList<CustomerModel> ,private val listener :Listener) : RecyclerView.Adapter<RecylerViewAdapter.RowHolder>() {


    interface Listener {
        fun onItemClick(customerModel: CustomerModel)
    }


    class RowHolder(itemView : View) : RecyclerView.ViewHolder(itemView) {
         var fname :TextView
         var lname :TextView

        init {
            fname = itemView.findViewById(R.id.text_fName)
            lname = itemView.findViewById(R.id.text_lName)
        }
        fun bind(customerModel: CustomerModel ,position: Int,listener:Listener){

            itemView.setOnClickListener{
                listener.onItemClick(customerModel)
            }

            fname.text = customerModel.first_name
            lname.text = customerModel.last_name
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RowHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.row_layaout,parent,false)
        return RowHolder(view)
    }

    override fun onBindViewHolder(holder: RowHolder, position: Int) {
            holder.bind(customerList[position],position,listener)
    }

    override fun getItemCount(): Int {
        return customerList.count()
    }


}


