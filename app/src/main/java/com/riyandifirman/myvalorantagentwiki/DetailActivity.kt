package com.riyandifirman.myvalorantagentwiki

import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import com.riyandifirman.myvalorantagentwiki.databinding.ActivityDetailBinding

class DetailActivity : AppCompatActivity(), View.OnClickListener {

    // Inisiasi binding
    private lateinit var binding: ActivityDetailBinding
    // Inisiasi button share
    private lateinit var button: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        // Inisiasi binding
        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Set onClickListener untuk button back di detail page
        binding.ibBack.setOnClickListener(this)

        // Pengambilan data dari MainActivity melalui Parcelable Extra
        val data = if (Build.VERSION.SDK_INT >= 33) {
            intent.getParcelableExtra(EXTRA_AGENT, Agent::class.java)
        } else {
            @Suppress("DEPRECATION")
            intent.getParcelableExtra(EXTRA_AGENT)
        }

        // Set data ke view
        if (data != null) {
            binding.tvName.text = data.name
            binding.tvRole.text = data.role
            binding.tvCountry.text = data.country
            binding.tvUltimate.text = data.ultimate
            binding.tvDescription.text = data.description
            binding.ivProfile.setImageResource(data.photo)
            binding.ivRole.setImageResource(data.role_icon)
        }

        // Set onClickListener untuk button share
        val message = "My Valorant Agent Wiki\n\n" +
                "Name: ${binding.tvName.text}\n" +
                "${binding.tvRole.text}\n" +
                "${binding.tvCountry.text}\n" +
                "${binding.tvUltimate.text}\n" +
                "Description: ${binding.tvDescription.text}\n"
        binding.shareButton.setOnClickListener {
            val intent = Intent(Intent.ACTION_SEND)
            intent.type = "text/plain"
            intent.putExtra(Intent.EXTRA_SUBJECT, "My Valorant Agent Wiki")
            intent.putExtra(Intent.EXTRA_TEXT, message)
            startActivity(Intent.createChooser(intent, "Share via"))
        }
    }

    // Fungsi untuk menangani onClickListener
    override fun onClick(v: View) {
        when (v.id) {
            // Jika button back di klik, maka akan kembali ke MainActivity
            R.id.ib_back -> {
                val backIntent = Intent(this@DetailActivity, MainActivity::class.java)
                startActivity(backIntent)
            }
        }
    }

    // Deklarasi companion object untuk Parcelable Extra
    companion object {
        const val EXTRA_AGENT = "extra_agent"
    }


}