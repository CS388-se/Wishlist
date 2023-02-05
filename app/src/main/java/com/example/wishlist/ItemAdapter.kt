package com.example.wishlist

import android.content.ActivityNotFoundException
import android.content.Intent
import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView

class ItemAdapter(private val items: MutableList<Item>) : RecyclerView.Adapter<ItemAdapter.ViewHolder>() {

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val nameTextView: TextView
        val urlTextView: TextView
        val priceTextView: TextView

        init {
            nameTextView = itemView.findViewById(R.id.nameTv)
            urlTextView = itemView.findViewById(R.id.urlTv)
            priceTextView = itemView.findViewById(R.id.priceTv)

            urlTextView.setOnClickListener {
                try {
                    val browserIntent = Intent(Intent.ACTION_VIEW, Uri.parse(urlTextView.text.toString()))
                    ContextCompat.startActivity(itemView.context, browserIntent, null)
                } catch (e: ActivityNotFoundException) {
                    Toast.makeText(itemView.context, "Invalid URL for " + nameTextView.text.toString(), Toast.LENGTH_LONG).show()
                }
            }

            itemView.setOnLongClickListener {
                deleteItem(adapterPosition)
                return@setOnLongClickListener true
            }
        }
    }

    fun deleteItem(index: Int) {
        items.removeAt(index)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val context = parent.context
        val inflater = LayoutInflater.from(context)
        val contactView = inflater.inflate(R.layout.item, parent, false)
        return ViewHolder(contactView)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = items[position]
        holder.nameTextView.text = item.name
        holder.urlTextView.text = item.url
        holder.priceTextView.text = item.price
    }

    override fun getItemCount(): Int {
        return items.size
    }
}
