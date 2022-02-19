package com.example.calc

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import net.objecthunter.exp4j.ExpressionBuilder
import java.util.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val Enter = findViewById<Button>(R.id.Enter)
        val Hangman = findViewById<TextView>(R.id.Hangman)
        val Input = findViewById<EditText>(R.id.Input)
        val Hint = findViewById<TextView>(R.id.Hint)
        var c=0
        var c1=0
        var e=0
        var s1=""
        var s2=""
        var l=""
        var h=""
        val hang0 = arrayListOf<String>()
        var hang1 = arrayListOf<String>()
        var hang2 = arrayListOf("H - ","A - ","N - ","G - ","M - ","A - ","N - ")

        if (c==0)
        {
            Enter.setOnClickListener{
                h=Input.toString()
                for (i in h.indices)
                {
                    hang0[i]=h[i].toString()
                    hang1[i]="_"
                }
                s1="$hang2[1]/n$hang2[2]/n$hang2[3]/n$hang2[4]/n$hang2[5]/n$hang2[6]/n$hang2[7]"
                s2="$hang1[1] $hang1[2] $hang1[3] $hang1[4] $hang1[5] $hang1[6] $hang1[7]"
                Hangman.text=s2
                Hint.text=s1
            }
            c=1
        }
        else
        {
            Enter.setOnClickListener{
                l=Input.text.toString()
                for(i in h.indices)
                {
                    if (l == hang0[i])
                    {
                        hang1[i]=l
                        c1=1
                    }
                }
                if (c1==1)
                {
                    s2="$hang1[1] $hang1[2] $hang1[3] $hang1[4] $hang1[5] $hang1[6] $hang1[7]"
                    Hangman.text=s2
                    Hint.text=s1
                    c=0
                }
                else
                {
                    if(e==7)
                    {
                        s1="The word is $hang0[1] $hang0[2] $hang0[3] $hang0[4] $hang0[5] $hang0[6] $hang0[7]"
                        Hangman.text=s1
                        s2="You Lost"
                        Hint.text=s2
                        s1=""
                        s2=""
                        c=0
                    }
                    else if(hang1==hang0)
                    {
                        s1="The word is $hang0[1] $hang0[2] $hang0[3] $hang0[4] $hang0[5] $hang0[6] $hang0[7]"
                        Hangman.text=s1
                        s2="You Won"
                        Hint.text=s2
                        s1=""
                        s2=""
                        c=0
                    }
                    else
                    {
                        hang2[e]+=l
                        e++
                        s1="$hang2[1]/n$hang2[2]/n$hang2[3]/n$hang2[4]/n$hang2[5]/n$hang2[6]/n$hang2[7]"
                        s2="$hang1[1] $hang1[2] $hang1[3] $hang1[4] $hang1[5] $hang1[6] $hang1[7]"
                        Hangman.text=s2
                        Hint.text=s1
                    }
                }
            }
        }
    }
}