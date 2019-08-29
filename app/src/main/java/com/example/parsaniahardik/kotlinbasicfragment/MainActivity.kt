package com.example.parsaniahardik.kotlinbasicfragment

import android.content.Intent
import android.support.v4.app.Fragment
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {

    private var btnFrag1WithoutBack: Button? = null
    private var btnFrag2WithoutBack: Button? = null
    private var btnback: Button? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnFrag1WithoutBack = findViewById(R.id.btnfr1without)
        btnFrag2WithoutBack = findViewById(R.id.btnfr2without)
        btnback = findViewById(R.id.btnback)

        btnback!!.setOnClickListener {
            val intent = Intent(this@MainActivity, BackStackActivity::class.java)
            startActivity(intent)
        }

        btnFrag1WithoutBack!!.setOnClickListener { addFragment(OneFragment(), false, "one") }

        btnFrag2WithoutBack!!.setOnClickListener { addFragment(TwoFragment(), false, "two") }

    }

    private fun addFragment(fragment: Fragment, addToBackStack: Boolean, tag: String) {
        val manager = supportFragmentManager
        val ft = manager.beginTransaction()

        if (addToBackStack) {
            ft.addToBackStack(tag)
        }
        ft.replace(R.id.container_frame, fragment, tag)
        ft.commitAllowingStateLoss()

    }

}