package com.afzal.khatabook

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.lifecycle.findViewTreeViewModelStoreOwner
import androidx.recyclerview.widget.RecyclerView
import com.afzal.databases.Subject
import com.afzal.databases.Subject.Companion.formatter
import kotlinx.coroutines.Job
import kotlinx.coroutines.NonDisposableHandle.parent
import org.w3c.dom.Text

class SubjectDataAdapter(private val context: Context, private val listener: ISubjectDataAdapter) : RecyclerView.Adapter<SubjectDataAdapter.SubjectViewHolder>() {

    private val allItems  = ArrayList<Subject>()
    inner class SubjectViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        val textView: TextView = itemView.findViewById(R.id.item_name)
        val priceView: TextView = itemView.findViewById(R.id.price)
        val deleteButton: ImageView = itemView.findViewById(R.id.delete)
//        val totalAmount: TextView = itemView.findViewById(R.id.total)

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
        holder.priceView.text = currentItem.getFormattedPrice()

    }

    override fun getItemCount(): Int {
        return allItems.size
    }

    fun updateList(newList : List<Subject>){
        allItems.clear()
        allItems.addAll(newList)
        notifyDataSetChanged()
    }

    fun getTotalAmount(): String? {

            var total:Float=0f
            allItems.forEach {
                total+=it.price
            }
        return total.toString()
    }
}


interface ISubjectDataAdapter{
    fun onItemClicked(subject: Subject)
}