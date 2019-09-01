package com.example.tugas3

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {

    var isFragmentOneLoaded = true
    val manager = supportFragmentManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val Change = findViewById<Button>(R.id.btn_Fragment)
        ShowFragment1()
        Change.setOnClickListener({
            if (isFragmentOneLoaded)
                ShowFragment2()
            else
                ShowFragment1()})
    }

    fun ShowFragment1() {
        val transaction = manager.beginTransaction()
        val fragment = SatuFragment()
        transaction.replace(R.id.fragment_holder, fragment)
        transaction.addToBackStack(null)
        transaction.commit()
        isFragmentOneLoaded = true
    }

    fun ShowFragment2() {
        val transaction = manager.beginTransaction()
        val fragment = DuaFragment()
        transaction.replace(R.id.fragment_holder, fragment)
        transaction.addToBackStack(null)
        transaction.commit()
        isFragmentOneLoaded = false
    }
}