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

    private lateinit var binding: ActivityDetailBinding
    private lateinit var button: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.ibBack.setOnClickListener(this)

        val data = if (Build.VERSION.SDK_INT >= 33) {
            intent.getParcelableExtra(EXTRA_AGENT, Agent::class.java)
        } else {
            @Suppress("DEPRECATION")
            intent.getParcelableExtra(EXTRA_AGENT)
        }

        if (data != null) {
            binding.tvName.text = data.name
            binding.tvRole.text = data.role
            binding.tvCountry.text = data.country
            binding.tvUltimate.text = data.ultimate
            binding.tvDescription.text = data.description
            binding.ivProfile.setImageResource(data.photo)
            binding.ivRole.setImageResource(data.role_icon)
        }

        val url = "https://github.com/riyandifirman/my-valorant-agent-wiki"
        binding.shareButton.setOnClickListener {
            val intent = Intent(Intent.ACTION_SEND)
            intent.type = "text/plain"
            intent.putExtra(Intent.EXTRA_SUBJECT, "My Valorant Agent Wiki")
            intent.putExtra(Intent.EXTRA_TEXT, url)
            startActivity(Intent.createChooser(intent, "Share via"))
        }
    }

    override fun onClick(v: View) {
        when (v.id) {
            R.id.ib_back -> {
                val backIntent = Intent(this@DetailActivity, MainActivity::class.java)
                startActivity(backIntent)
            }
        }
    }

    companion object {
        const val EXTRA_AGENT = "extra_agent"
    }


}