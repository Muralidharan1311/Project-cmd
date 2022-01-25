package com.example.actstatechange

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView

class MainActivity : AppCompatActivity() {


    var incrementNumber = 0
    val click_me = findViewById<TextView>(R.id.tv_increment)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        click_me.setOnClickListener{
            ++incrementNumber
            click_me.text = incrementNumber.toString()
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)

        val userNumber: Int = incrementNumber
        outState.putInt("savedInt",incrementNumber)
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)

        val userInt: Int = savedInstanceState.getInt("savedInt",0)
        incrementNumber = userInt
        click_me.text = incrementNumber.toString()
    }


}