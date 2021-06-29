package com.example.customerlist.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.customerlist.R
import com.example.customerlist.adapter.RecylerViewAdapter
import com.example.customerlist.model.CustomerModel
import com.example.customerlist.service.CustomerAPI
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : AppCompatActivity(), RecylerViewAdapter.Listener{

    private val BASE_URL = "https://raw.githubusercontent.com/"
    private var customerModels: ArrayList<CustomerModel>? = null
    private  var recyclerViewAdapter : RecylerViewAdapter? =null

    lateinit var recyclerView :RecyclerView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        //RecyclerView
        val layoutManager : RecyclerView.LayoutManager = LinearLayoutManager(this)
        recyclerView = findViewById(R.id.recyclerView)
        recyclerView.layoutManager = layoutManager

        loadData()
    }

    private fun loadData(){

        val retrofit = Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
        val service = retrofit.create(CustomerAPI::class.java)
        val call = service.getData()

        call.enqueue(object: Callback<List<CustomerModel>>{
            override fun onResponse(call: Call<List<CustomerModel>>, response: Response<List<CustomerModel>>) {


                if(response.isSuccessful){
                    response.body()?.let {
                        customerModels = ArrayList(it)


                        customerModels?.let {
                            recyclerViewAdapter = RecylerViewAdapter(it,this@MainActivity)
                            recyclerView.adapter = recyclerViewAdapter
                        }

                       /* for (customerss : CustomerModel in customerModels!!){
                            println("Ahmet"+customerss.first_name)
                            println("Ozkan"+customerss.last_name)
                        }
                        */

                    }
                }
            }

            override fun onFailure(call: Call<List<CustomerModel>>, t: Throwable) {
                t.printStackTrace()
            }

        })

    }

    override fun onItemClick(customerModel: CustomerModel) {
        Toast.makeText(this,"Clisked : ${customerModel.first_name}",Toast.LENGTH_SHORT).show()
    }
}