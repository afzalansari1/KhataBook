package com.afzal.khatabook

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.afzal.database.Subject

class SubjectDataAdapter(private val context: Context, private val listener: ISubjectDataAdapter) : RecyclerView.Adapter<SubjectDataAdapter.SubjectViewHolder>() {

    private val allItems  = ArrayList<Subject>()
    inner class SubjectViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        val textView: TextView = itemView.findViewById(R.id.add)
        val deleteButton: ImageView = itemView.findViewById(R.id.delete)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SubjectViewHolder {
        val viewHolder = SubjectViewHolder(LayoutInflater.from(context).inflate(R.layout.list_item, parent, false))
        viewHolder.deleteButton.setOnClickListener{
            listener.onItemClicked(allItems[viewHolder.adapterPosition])
        }
        return viewHolder
    }

    override fun onBindViewHolder(holder: SubjectViewHolder, position: Int) {
        val currentItem = allItems[position]
        holder.textView.text = currentItem.item
    }

    override fun getItemCount(): Int {
        return allItems.size
    }
}

interface ISubjectDataAdapter{
    fun onItemClicked(subject: Subject)
}