package com.example.fragmentdisplaydemo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val fragmentManager = supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()
        val fragment = AFragment()
        fragmentTransaction.add(R.id.fragment_container, fragment)
        fragmentTransaction.commit()

        val btnA:Button = findViewById(R.id.btnA)
        val btnB:Button = findViewById(R.id.btnB)
        val btnSet:Button = findViewById(R.id.btnSet)
        btnA.setOnClickListener(){

            val fragmentTransaction = fragmentManager.beginTransaction()

            val fragment = AFragment()
            fragmentTransaction.replace(R.id.fragment_container, fragment)
            fragmentTransaction.addToBackStack(null)
            fragmentTransaction.commit()

        }

        btnB.setOnClickListener(){
            val fragmentTransaction = fragmentManager.beginTransaction()

            val fragment = BFragment()
            fragmentTransaction.replace(R.id.fragment_container, fragment)
            fragmentTransaction.addToBackStack(null)
            fragmentTransaction.commit()
        }

        btnSet.setOnClickListener(){

            val fragment = supportFragmentManager.findFragmentById(R.id.fragment_container) as AFragment

            fragment.requireView()!!.findViewById<TextView>(R.id.tvName).text = "John"

        }
    }
}