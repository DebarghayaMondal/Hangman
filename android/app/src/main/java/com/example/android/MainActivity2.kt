package com.example.android

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)
        val name0 = intent.getStringExtra("n").toString()
        val button = findViewById<Button>(R.id.b)
        val letter = findViewById<EditText>(R.id.l)
        val hangman = findViewById<TextView>(R.id.hangman)
        val name = findViewById<TextView>(R.id.name)
        var c=0
        var s1=""
        var s2=""
        var s3=""
        var m = name0.length
        button.setOnClickListener{
                for (i in 0..name0.length)
                {
                    val l = letter.text.toString()
                    val n = name0.length
                    val list = mutableListOf<String>()
                    for (i in 0 until n)
                    {
                        list[i]=name0[i].toString()
                    }
                    val listh = mutableListOf<String>()
                    val listn = mutableListOf<String>()
                    for (k in 0 until n)
                    {
                        listn [k] = "_ "
                    }
                    if (l in name0)
                    {
                        for (j1 in 0 until n)
                        {
                            if (list[j1]==l)
                            {
                                listn[j1] = l
                            }
                        }
                    }
                    else
                    {
                        c+=1
                    }
                    when (c)
                    {
                        1 -> listh[c] = "H "
                        2 -> listh[c] = "A "
                        3 -> listh[c] = "N "
                        4 -> listh[c] = "G "
                        5 -> listh[c] = "M "
                        6 -> listh[c] = "A "
                        7 -> listh[c] = "N"
                    }
                    for (j2 in list)
                    {
                        s1+=j2
                    }
                    for (j3 in listh)
                    {
                        s2+="$j3/n"
                    }
                    for (j3 in listn)
                    {
                        s3+=j3
                    }
                    hangman.text = s2
                    name.text = s3
                }
        }

    }
}

