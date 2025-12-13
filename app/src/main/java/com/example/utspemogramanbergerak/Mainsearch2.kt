package com.example.utspemogramanbergerak

import android.app.DatePickerDialog // HARUS ADA: Untuk menampilkan pemilih tanggal
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.widget.EditText // Sudah ada: Untuk mengakses kolom input
import java.util.Calendar // Sudah ada: Untuk mengelola tanggal dan waktu

class Mainsearch2 : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_mainsearch2)

        // 1. Dapatkan referensi ke EditText tanggal lahir (ID: edit_text_tanggal_lahir)
        val etTanggalLahir = findViewById<EditText>(R.id.edit_text_tanggal_lahir)

        // 2. Tambahkan Listener saat EditText diklik
        etTanggalLahir.setOnClickListener {
            // Panggil fungsi untuk menampilkan DatePickerDialog
            showDatePickerDialog(etTanggalLahir)
        }

        // Catatan: etNama (dari XML) belum memiliki listener di sini.
    }

    // =======================================================
    // >>> FUNGSI WAJIB DITAMBAHKAN DI SINI (Di luar onCreate) <<<
    // =======================================================
    private fun showDatePickerDialog(editText: EditText) {
        // Dapatkan tanggal saat ini untuk inisialisasi dialog
        val c = Calendar.getInstance()
        val year = c.get(Calendar.YEAR)
        val month = c.get(Calendar.MONTH)
        val day = c.get(Calendar.DAY_OF_MONTH)

        // Buat dan tampilkan dialog Date Picker
        val datePickerDialog = DatePickerDialog(
            this,
            { _, selectedYear, selectedMonth, selectedDay ->
                //selectedMonth adalah 0-based (0=Januari), jadi perlu ditambah 1
                val date = String.format("%02d/%02d/%d", selectedDay, selectedMonth + 1, selectedYear)
                editText.setText(date)
            },
            year, month, day
        )
        datePickerDialog.show()
    }
}