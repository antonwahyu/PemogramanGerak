package com.example.utspemogramanbergerak

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.widget.Button

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Tombol menuju Mainsearch2
        // Pastikan ID di sini (R.id.btn_mainsearch2) sama dengan ID di activity_main.xml
        val btnSearch = findViewById<Button>(R.id.btn_mainsearch2)
        btnSearch.setOnClickListener {
            startActivity(Intent(this, Mainsearch2::class.java))
        }

        // Tombol menuju ResultActivity
        // Pastikan ID di sini (R.id.btn_result) sama dengan ID di activity_main.xml
        val btnResult = findViewById<Button>(R.id.btn_result)
        btnResult.setOnClickListener {
            startActivity(Intent(this, ResultActivity::class.java))
        }

        // Tombol menuju NotFoundActivity
        // Pastikan ID di sini (R.id.btn_notfound) sama dengan ID di activity_main.xml
        val btnNotFound = findViewById<Button>(R.id.btn_notfound)
        btnNotFound.setOnClickListener {
            startActivity(Intent(this, NotFoundActivity::class.java))
        }
    }
}