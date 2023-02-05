package com.example.wishlist

import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    private lateinit var items: MutableList<Item>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        items = ArrayList()
        val itemsRv = findViewById<RecyclerView>(R.id.itemsRv)
        val adapter = ItemAdapter(items)
        itemsRv.adapter = adapter
        itemsRv.layoutManager = LinearLayoutManager(this)

        val itemURL = findViewById<EditText>(R.id.itemURL)
        val itemName = findViewById<EditText>(R.id.itemName)
        val itemPrice = findViewById<EditText>(R.id.itemPrice)
        val submitBtn = findViewById<Button>(R.id.submitBtn)

        submitBtn.setOnClickListener {
            this.hideKeyboard()
            if (itemURL.text.isEmpty() || itemName.text.isEmpty() || itemPrice.text.isEmpty()) {
                Toast.makeText(this, "Please fill out all fields to add an item!", Toast.LENGTH_LONG).show()
                return@setOnClickListener
            }
            items.add(Item(itemName.text.toString(), itemURL.text.toString(), itemPrice.text.toString()))
            adapter.notifyDataSetChanged()
            itemName.text.clear()
            itemURL.text.clear()
            itemPrice.text.clear()
        }
    }

    // hiding the keyboard
    private fun hideKeyboard() {
        val view: View? = this.currentFocus
        if (view != null) {
            val inputMethodManager =
                getSystemService(INPUT_METHOD_SERVICE) as InputMethodManager
            inputMethodManager.hideSoftInputFromWindow(view.windowToken, 0)
        }
    }
}
