package com.memeglobal.myapplication

import android.os.Bundle
import android.view.View
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import android.widget.TextView


class MainActivity : AppCompatActivity() {

    private lateinit var spinner: Spinner
    private  var textView: TextView? = null
//    private var items = arrayOf("Item 1", "Item 2", "Item 3", "Item 4", "Item 5")
//    private var selectedItems = ArrayList<String>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        spinner = findViewById(R.id.spinner)
        val items = arrayOf("vivek", "vicky", "veer", "vv", "vk")

        val adapter = CheckboxArrayAdapter(this, R.layout.spinner_items, items)
        spinner.adapter = adapter
        spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>, view: View, position: Int, id: Long) {
                val selectedItems = mutableListOf<String>()
                for (i in 0 until parent.count) {
                    val itemView = parent.getChildAt(i)
                    if (itemView != null) {
                        val checkBox = itemView.findViewById<CheckBox>(R.id.checkbox)
                        if (checkBox.isChecked) {
                            selectedItems.add(checkBox.text.toString())

                        }
                    }
                }
                textView?.text = selectedItems.joinToString(", ")
            }

            override fun onNothingSelected(parent: AdapterView<*>) {}
        }

    }
}







