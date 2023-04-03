package com.afzal.khatabook

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.afzal.database.Subject

class MainActivity : AppCompatActivity(), ISubjectDataAdapter {

    lateinit var viewModel : SubjectViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        viewModel = ViewModelProvider(this,
            ViewModelProvider.AndroidViewModelFactory.getInstance(application))[SubjectViewModel :: class.java]

        viewModel.allSubject.observe(this, Observer {

        })
        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)
        val adapter = SubjectDataAdapter(this, this)
        recyclerView.adapter = adapter
    }

    override fun onItemClicked(subject: Subject) {

    }
}
