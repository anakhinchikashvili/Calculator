package com.example.myapplication

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView

class MainActivity : AppCompatActivity() {

private lateinit var tvClear : TextView
private lateinit var tvResult : TextView
private var operand = 0.0
private var operation = ""




    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        tvResult=findViewById(R.id.tvResult)
    }

    fun numberClick(clickedView: View) {
        if (clickedView is TextView) {
            var text = tvResult.text.toString()
            val number = clickedView.text.toString()
            if (text == "0") {
                text = ""
            }
            val result = text + number
            tvResult.text=result
        }
    }
    fun dotClick(clickedView: View) {
        if (clickedView is TextView) {
           var text = tvResult.text.toString()
            var dot = clickedView.text.toString()
            if (text.contains('.')) {
                dot=""
            }
            tvResult.text = text + dot
        }
    }
    fun operationClick(clickedView: View) {
        if (clickedView is TextView) {
            operand = tvResult.text.toString().toDouble()
            operation = clickedView.text.toString()
            tvResult.text=""
        }
    }
    fun equalsClick(clickedView: View) {
        var secondOperant = tvResult.text.toString().toDouble()
        when (operation) {
            "/" -> tvResult.text = (operand / secondOperant).toString()
            "+" -> tvResult.text = (operand + secondOperant).toString()
            "-" -> tvResult.text = (operand - secondOperant).toString()
            "*" -> tvResult.text = (operand * secondOperant).toString()
        }
    }
    fun clearClick(clickedView: View) {
        if (clickedView is TextView) {
            tvResult.text="0"
        }
    }
    fun delClick(clickedView: View) {
        if (clickedView is TextView) {
            var text = tvResult.text.toString()

            tvResult.text=text.dropLast(1)
            if (tvResult.text.toString() == "") {
                tvResult.text="0"
            }
        }

    }
}