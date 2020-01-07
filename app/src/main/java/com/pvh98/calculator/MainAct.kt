package com.pvh98.calculator

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

class MainAct : AppCompatActivity() {
    @SuppressLint("MissingSuperCall")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.act_main)
        var fragment = CalculatorFrg()
        var transaction = supportFragmentManager.beginTransaction()
        transaction.add(R.id.frg_calculator, fragment)
        transaction.commit()

    }
}