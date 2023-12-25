package com.pavan.efeed

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.SearchView
import android.widget.Toolbar
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.LayoutManager
import com.pavan.efeed.adapters.Adapter
import com.pavan.efeed.repository.Issuerepository
import com.pavan.efeed.viewmodel.issueviewmodel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    lateinit var viewmodel:issueviewmodel
    lateinit var recyclerView: RecyclerView
    lateinit var adapter: Adapter
    lateinit var searchview : SearchView
    lateinit var toolbar : Toolbar
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setSupportActionBar(findViewById(R.id.toolbar))
        supportActionBar?.title = "Efeed Issues"
        searchview = findViewById(R.id.search)
        recyclerView = findViewById(R.id.recyclerview)

        viewmodel = ViewModelProvider(this).get(issueviewmodel::class.java)

        recyclerView.layoutManager = LinearLayoutManager(this)
        adapter = Adapter(emptyList())
        recyclerView.adapter = adapter

        observemodel()

        searchview.setOnQueryTextListener(object : SearchView.OnQueryTextListener{
            override fun onQueryTextSubmit(p0: String?): Boolean {

                return true
            }

            override fun onQueryTextChange(p0: String?): Boolean {
                if(!p0.isNullOrBlank()){
                    viewmodel.searchqueryissues(p0)
                }
                return true
            }

        })


    }



    private fun observemodel() {
         viewmodel.issuelist.observe(this){ issueList ->
             adapter.submitList(issueList)
        }
    }
}