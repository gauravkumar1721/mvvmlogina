package com.example.mvvmlogin

import android.icu.lang.UCharacter.DecompositionType.VERTICAL
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_recycler_view.*

private val Nothing?.text: Any
    get() {
        TODO("Not yet implemented")
    }

class RecyclerViewActivity : AppCompatActivity() {
    lateinit var recyclerViewAdapter: RecyclerViewAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recycler_view)


        initRecyclerView()
        createData()
    }

    private fun initRecyclerView() {
        recyclerView.apply {
            layoutManager = LinearLayoutManager(this@RecyclerViewActivity)
            recyclerViewAdapter = RecyclerViewAdapter()
            adapter = recyclerViewAdapter

            val decoration = DividerItemDecoration(applicationContext, VERTICAL)
            addItemDecoration(decoration)
        }
    }



    private fun createData() {


        val viewModel = ViewModelProviders.of(this).get(RecyclerActivityViewModel::class.java)
        viewModel.getRecyclerListDataObserver().observe(this, Observer<RecyclerList>{

            if(it != null) {
                recyclerViewAdapter.setListData(it.items)
                recyclerViewAdapter.notifyDataSetChanged()

            } else {
                Toast.makeText(this@RecyclerViewActivity, "Error in getting data from api.", Toast.LENGTH_LONG).show()
            }

        })
        val searchButton = null
        searchButton.setOnClickListener {
            val searchBoxId = null
            viewModel.makeApiCall(searchBoxId.text.toString())
        }

    }
}

private fun ViewModelProvider.get(java: Class<RecyclerActivityViewModel>): RecyclerActivityViewModel {
    TODO("Not yet implemented")
}

private fun Nothing?.setOnClickListener(function: () -> Unit) {
    TODO("Not yet implemented")
}

private fun Any.observe(
    recyclerViewActivity: RecyclerViewActivity,
    observer: Observer<RecyclerList>
) {
    TODO("Not yet implemented")
}

class RecyclerActivityViewModel {
    fun getRecyclerListDataObserver(): Any {
        TODO("Not yet implemented")
    }

    fun makeApiCall(toString: Any) {
        TODO("Not yet implemented")
    }

}

