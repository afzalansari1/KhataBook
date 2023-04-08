package com.afzal.khatabook

import android.app.PendingIntent.getActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.text.method.TextKeyListener.clear
import android.view.View
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.afzal.databases.Subject

class MainActivity : AppCompatActivity(), ISubjectDataAdapter {

    lateinit var viewModel : SubjectViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)
        val adapter = SubjectDataAdapter(this, this)
        recyclerView.adapter = adapter

        viewModel = ViewModelProvider(this,
            ViewModelProvider.AndroidViewModelFactory.getInstance(application))[SubjectViewModel::class.java]

        viewModel.allSubject.observe(this, Observer {list->
            list?.let{
                adapter.updateList(it)
            }
        })

    }

    override fun onItemClicked(subject: Subject) {

        viewModel.deleteNode(subject)
    }

    fun submitData(view: View) {
        addItemDialog()
    }
    private fun addItemDialog() {
        val inflater = this.layoutInflater
        val view: View = inflater.inflate(R.layout.dialog_add,null)
        val item = view.findViewById<EditText>(R.id.item_name)
        val price = view.findViewById<EditText>(R.id.price)

        setErrorListener(item)
        setErrorListener(price)

        val builder = AlertDialog.Builder(this)
        with(builder) {
            setTitle("Add Item")
            setMessage("Enter the details of purchased item")
            setView(view)

            //sets positive button
            setPositiveButton("Add") { _, _ ->
                val itemName = item.text.toString()
                val itemPrice = price.text.toString().toFloatOrNull()


//                val itemP: Long = itemPrice.toLong()
                if(itemName.isNotEmpty() && itemPrice!=null) {
                    viewModel.insertNode(Subject(itemName, itemPrice!!))
                }
                else
                    Toast.makeText(this@MainActivity,"Invalid Input", Toast.LENGTH_SHORT).show()
            }
            setNegativeButton("Cancel") { _, _ ->
            }
            show()
        }
    }
    private fun setErrorListener(editText: EditText) {
        editText.error = if(editText.text.toString().isNotEmpty()) null else "Field Cannot be Empty"
        editText.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable?) {
            }
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                editText.error = if(editText.text.toString().isNotEmpty()) null else "Field Cannot be Empty"
            }
        })
    }

}
