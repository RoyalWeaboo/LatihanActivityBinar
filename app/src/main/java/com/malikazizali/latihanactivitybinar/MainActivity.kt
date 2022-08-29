package com.malikazizali.latihanactivitybinar

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {
    lateinit var bmi : Button
    lateinit var nilai : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        bmi = findViewById(R.id.btn_bmi)
        nilai = findViewById(R.id.btn_na)

        bmi.setOnClickListener {
            val goBMI = Intent(this, BMICalculator::class.java)
            startActivity(goBMI)
        }
         nilai.setOnClickListener {
            val goNilai = Intent(this, NilaiAkhir::class.java)
            startActivity(goNilai)
        }
    }
}