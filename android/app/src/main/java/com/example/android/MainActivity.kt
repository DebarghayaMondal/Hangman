package com.example.android

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val n = findViewById<EditText>(R.id.n)
        val b = findViewById<Button>(R.id.next)
        b.setOnClickListener {

            val intent = Intent(this@MainActivity , MainActivity2::class.java)
            val s = n.text.toString()
            intent.putExtra("n",s)
            startActivity(intent)
        }


    }
}