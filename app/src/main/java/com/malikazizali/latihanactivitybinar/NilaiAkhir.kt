package com.malikazizali.latihanactivitybinar

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class NilaiAkhir : AppCompatActivity() {
    lateinit var nama : EditText
    lateinit var nim : EditText
    lateinit var uas : EditText
    lateinit var uts : EditText
    lateinit var tugas : EditText
    lateinit var tvnama : TextView
    lateinit var tvnim : TextView
    lateinit var tvuas : TextView
    lateinit var tvuts : TextView
    lateinit var tvtgs : TextView
    lateinit var tvtotal : TextView
    lateinit var tvrata : TextView
    lateinit var tvhuruf : TextView
    lateinit var tvstatus : TextView
    lateinit var buttonhitung : Button
    lateinit var buttonReset : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_nilai_akhir)
        nama = findViewById(R.id.et_nama)
        nim = findViewById(R.id.et_nim)
        uas = findViewById(R.id.et_uas)
        uts = findViewById(R.id.et_uts)
        tugas = findViewById(R.id.et_tugas)
        tvnama = findViewById(R.id.tv_nama)
        tvnim = findViewById(R.id.tv_nim)
        tvuas = findViewById(R.id.tv_uas)
        tvuts = findViewById(R.id.tv_uts)
        tvtgs = findViewById(R.id.tv_tugas)
        tvtotal = findViewById(R.id.tv_total)
        tvrata = findViewById(R.id.tv_rata)
        tvhuruf = findViewById(R.id.tv_huruf)
        tvstatus = findViewById(R.id.tv_status)
        buttonhitung = findViewById(R.id.button_hitung_nilai)
        buttonReset = findViewById(R.id.button_reset_nilai)

        buttonReset.setOnClickListener {
            reset()
        }
        buttonhitung.setOnClickListener {
            hitungNilai()
        }
    }

    fun reset(){
        nama.setText("")
        nim.setText("")
        uas.setText("")
        uts.setText("")
        tugas.setText("")
        tvnama.setText("")
        tvnim.setText("")
        tvuas.setText("")
        tvuts.setText("")
        tvtgs.setText("")
        tvtotal.setText("")
        tvrata.setText("")
        tvhuruf.setText("")
        tvstatus.setText("")
    }

    fun hitungNilai(){
        val namaMhs = nama.text.toString()
        tvnama.text = namaMhs
        val nimMhs = nim.text.toString()
        tvnim.text = nimMhs
        val uasMhs = uas.text.toString()
        tvuas.text = uasMhs
        val utsMhs = uts.text.toString()
        tvuts.text = utsMhs
        val tugasMhs = tugas.text.toString()
        tvtgs.text = tugasMhs
        val totalNilai = uasMhs.toInt() + utsMhs.toInt() + tugasMhs.toInt()
        tvtotal.text = totalNilai.toString()
        val rataRata = totalNilai/3
        tvrata.text = rataRata.toString()
        when(rataRata){
            in 0..60 -> tvhuruf.text = "E"
            in 61..70 -> tvhuruf.text = "D"
            in 71..80 -> tvhuruf.text = "C"
            in 81..90 -> tvhuruf.text = "B"
            in 91..100 -> tvhuruf.text = "A"
            else -> tvhuruf.text = "Nilai $rataRata tidak Valid"
        }
        when(tvhuruf.text.toString()){
            "A" -> tvstatus.text = "Lolos"
            "B" -> tvstatus.text = "Lolos"
            "C" -> tvstatus.text = "Lolos"
            "D" -> tvstatus.text = "Tidak Lolos"
            "E" -> tvstatus.text = "Tidak Lolos"

        }
    }
}