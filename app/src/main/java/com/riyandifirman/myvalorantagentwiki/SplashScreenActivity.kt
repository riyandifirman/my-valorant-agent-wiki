package com.riyandifirman.myvalorantagentwiki

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import com.riyandifirman.myvalorantagentwiki.databinding.ActivityDetailBinding
import com.riyandifirman.myvalorantagentwiki.databinding.ActivitySplashScreenBinding

class SplashScreenActivity : AppCompatActivity() {
    // Inisialisasi binding
    private lateinit var binding: ActivitySplashScreenBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)

        // Inisialisasi binding
        binding = ActivitySplashScreenBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Animasi
        var image = binding.ivSplashScreenIcon
        image.alpha = 0f
        // Durasi animasi
        image.animate().setDuration(2000).alpha(1f).withEndAction {
            // Intent
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            // Animasi
            overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out)
            finish()
        }

    }
}