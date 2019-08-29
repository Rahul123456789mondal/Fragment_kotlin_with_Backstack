package com.example.parsaniahardik.kotlinbasicfragment

import android.support.v4.app.Fragment
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class BackStackActivity : AppCompatActivity() {

    private var btnFrag1WithBack: Button? = null
    private var btnFrag2WithBack: Button? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_back_stack)

        btnFrag1WithBack = findViewById(R.id.btnfr1with)
        btnFrag2WithBack = findViewById(R.id.btnfr2with)

        btnFrag1WithBack!!.setOnClickListener { addFragment(OneFragment(), true, "one1") }

        btnFrag2WithBack!!.setOnClickListener { addFragment(TwoFragment(), true, "two2") }
    }

    private fun addFragment(fragment: Fragment, addToBackStack: Boolean, tag: String) {
        val manager = supportFragmentManager
        val ft = manager.beginTransaction()

        if (addToBackStack) {
            ft.addToBackStack(tag)
        }
        ft.replace(R.id.container_frame_back, fragment, tag)
        ft.commitAllowingStateLoss()
    }
}
