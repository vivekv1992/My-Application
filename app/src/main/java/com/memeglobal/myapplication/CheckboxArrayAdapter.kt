package com.memeglobal.myapplication

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.BaseAdapter
import android.widget.CheckBox
import android.widget.TextView

class CheckboxArrayAdapter(context: Context, resource: Int, objects: Array<String>) :
    BaseAdapter() {

    private val layoutInflater = LayoutInflater.from(context)
    private val items = objects

    override fun getCount(): Int {
        return items.size
    }

    override fun getItem(position: Int): Any {
        return items[position]
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val view = convertView ?: layoutInflater.inflate(R.layout.spinner_items, parent, false)

        val item = getItem(position) as String
        val checkBox = view.findViewById<CheckBox>(R.id.checkbox)
        val textView = view.findViewById<TextView>(R.id.textView)

        checkBox.text = item
        textView.text = item

        return view
    }
}