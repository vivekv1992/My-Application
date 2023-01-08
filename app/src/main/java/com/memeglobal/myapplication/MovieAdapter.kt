package com.memeglobal.myapplication

import android.content.Context
import android.widget.ArrayAdapter
import android.view.ViewGroup
import android.view.LayoutInflater
import android.view.View
import com.memeglobal.myapplication.databinding.SpinnerItemsBinding

class MovieAdapter(mContext: Context, private val list: List<User>, private val funItemClick: () -> Unit) : ArrayAdapter<User?>(mContext, 0, list) {

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val binding =
            SpinnerItemsBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        val itemData = list[position]
        binding.checkbox.setOnCheckedChangeListener { _, isChecked ->
            itemData.selected = isChecked
            funItemClick.invoke()
        }
        binding.checkbox.text = list[position].name
        return binding.root
    }
}