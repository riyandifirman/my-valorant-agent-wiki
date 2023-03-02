package com.riyandifirman.myvalorantagentwiki

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.riyandifirman.myvalorantagentwiki.databinding.ActivityAboutPageBinding

class AboutPageActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var binding: ActivityAboutPageBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_about_page)

        binding = ActivityAboutPageBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.ibBack.setOnClickListener(this)
    }

    override fun onClick(v: View) {
        when (v.id) {
            R.id.ib_back -> {
                val backIntent = Intent(this@AboutPageActivity, MainActivity::class.java)
                startActivity(backIntent)
            }
        }
    }
}