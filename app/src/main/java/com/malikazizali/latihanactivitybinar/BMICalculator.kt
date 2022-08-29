package com.malikazizali.latihanactivitybinar

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class BMICalculator : AppCompatActivity() {
    lateinit var in_umur : EditText
    lateinit var in_tinggi : EditText
    lateinit var in_berat : EditText
    lateinit var bt_hitung : Button
    lateinit var bt_reset : Button
    lateinit var umur : TextView
    lateinit var tinggi : TextView
    lateinit var berat : TextView
    lateinit var bmi : TextView
    lateinit var kategori : TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_bmicalculator)
        in_umur = findViewById(R.id.et_umur)
        in_tinggi = findViewById(R.id.et_tinggi)
        in_berat = findViewById(R.id.et_bb)
        bt_hitung = findViewById(R.id.btn_htg)
        bt_reset = findViewById(R.id.btn_reset)
        umur = findViewById(R.id.tv_umur)
        tinggi = findViewById(R.id.tv_tinggi)
        berat = findViewById(R.id.tv_bb)
        bmi = findViewById(R.id.tv_bmi)
        kategori = findViewById(R.id.tv_kategori)

        bt_reset.setOnClickListener{
            reset()
        }

        bt_hitung.setOnClickListener{
            hitungBMI()
        }
    }

    fun reset(){
        in_umur.setText("")
        in_tinggi.setText("")
        in_berat.setText("")
        umur.setText("")
        tinggi.setText("")
        berat.setText("")
        bmi.setText("")
        kategori.setText("")
    }

    fun hitungBMI(){
        val umurUser = in_umur.text.toString()
        umur.text = umurUser
        val tinggiUser = in_tinggi.text.toString()
        tinggi.text = tinggiUser
        val beratUser = in_berat.text.toString()
        berat.text = beratUser

        val tinggiUserDalamMeter = tinggiUser.toDouble()/100
        val tinggiUserKuadrat = tinggiUserDalamMeter*tinggiUserDalamMeter
        val hasilBMI = beratUser.toFloat()/tinggiUserKuadrat
        bmi.text = hasilBMI.toString()

        if(hasilBMI.toDouble() < 16){
            kategori.text = "Terlalu Kurus"
        }else if(hasilBMI.toDouble() in 16.1..17.0){
            kategori.text = "Cukup Kurus"
        }else if(hasilBMI.toDouble() in 17.1..18.5){
            kategori.text = "Sedikit Kurus"
        }else if(hasilBMI.toDouble() in 18.6..25.0){
            kategori.text = "Normal"
        }else if(hasilBMI.toDouble() in 25.1..30.0){
            kategori.text = "Gemuk"
        }else if(hasilBMI.toDouble() in 30.0..35.0){
            kategori.text = "Obesitas Kelas 1"
        }else if(hasilBMI.toDouble() in 35.1..40.0){
            kategori.text = "Obesitas Kelas 2"
        }else{
            kategori.text ="Obesitas Kelas 3"
        }

    }
}