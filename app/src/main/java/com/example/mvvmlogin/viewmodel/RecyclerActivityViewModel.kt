package com.example.mvvmlogin.viewmodel

import android.telecom.Call
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.mvvmlogin.network.RetroInstance
import com.example.mvvmlogin.network.RetroService
import com.example.mvvmlogin.RecyclerList as RecyclerList1

class RecyclerActivityViewModel: ViewModel() {

    var recyclerListData: MutableLiveData<RecyclerList1> = MutableLiveData()


    fun getRecyclerListDataObserver(): MutableLiveData<RecyclerList1> {
        return recyclerListData
    }

    fun makeApiCall(input: String) {
        val retroInstance = RetroInstance.getRetroInstance().create(RetroService::class.java)
        val call = retroInstance.getDataFromAPI(input)
        val enqueue = call.enqueue(object : retrofit2.Callback<RecyclerList1> {
            override fun onResponse(call: Call<RecyclerList1>, response: Response<RecyclerList1>) {
                if (response.isSuccessful) {

                    recyclerListData.postValue(response.body())
                } else {
                    recyclerListData.postValue(null)
                }
            }

            override fun onFailure(call: Call<RecyclerList1>, t: Throwable) {
                )

                recyclerListData.postValue(null)
            }
        })
    }
}