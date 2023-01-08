package com.memeglobal.myapplication

import android.os.Bundle
import android.view.View
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.content.res.AppCompatResources
import androidx.appcompat.widget.ListPopupWindow
import com.memeglobal.myapplication.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setUpPopUp()
    }

    private fun setUpPopUp() {
        val listPopupWindowButton = binding.menu
        val listPopupWindow = ListPopupWindow(this, null, androidx.appcompat.R.attr.popupWindowStyle)
        listPopupWindow.setBackgroundDrawable(AppCompatResources.getDrawable(this, R.drawable.bg_bottom_popup_white))
        listPopupWindow.anchorView = listPopupWindowButton
        val items = arrayOf(
            User("arun", false),
            User("anand", false),
            User("vivek", false),
            User("messi", false),
            User("cr7", false)
        )
        val adapter = MovieAdapter(this, items.toList()) {
            val data = items.filter(User::selected).joinToString() { it.name }
            binding.message.setText(data)
        }
        listPopupWindow.setAdapter(adapter)
        listPopupWindow.setOnItemClickListener { parent: AdapterView<*>?, view: View?, position: Int, id: Long ->


        }
        var isShowing = false
        listPopupWindowButton.setEndIconOnClickListener { v: View? ->
            println("setEndIconOnClickListener")
            if (isShowing) {
                listPopupWindow.dismiss()
            } else {
                listPopupWindow.show()
            }
            isShowing = !isShowing
        }
    }
}







