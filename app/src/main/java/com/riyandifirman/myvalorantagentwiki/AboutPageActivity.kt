package com.riyandifirman.myvalorantagentwiki

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.riyandifirman.myvalorantagentwiki.databinding.ActivityAboutPageBinding

class AboutPageActivity : AppCompatActivity(), View.OnClickListener {

    // Inisiasi binding
    private lateinit var binding: ActivityAboutPageBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_about_page)

        // Inisiasi binding
        binding = ActivityAboutPageBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Set onClickListener untuk button back di about page
        binding.ibBack.setOnClickListener(this)
    }

    // Fungsi untuk menangani onClickListener
    override fun onClick(v: View) {
        when (v.id) {
            // Jika button back di klik, maka akan kembali ke MainActivity
            R.id.ib_back -> {
                val backIntent = Intent(this@AboutPageActivity, MainActivity::class.java)
                startActivity(backIntent)
            }
        }
    }
}