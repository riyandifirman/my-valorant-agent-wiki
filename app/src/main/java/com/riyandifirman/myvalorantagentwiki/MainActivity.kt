package com.riyandifirman.myvalorantagentwiki

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.riyandifirman.myvalorantagentwiki.databinding.ActivityDetailBinding
import com.riyandifirman.myvalorantagentwiki.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    // Inisialisasi RecyclerView, ArrayList, dan Binding
    private lateinit var rvAgent: RecyclerView
    private val list = ArrayList<Agent>()
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Menggunakan ViewBinding
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Menggunakan RecyclerView
        rvAgent = binding.rvAgent
        rvAgent.setHasFixedSize(true)

        // Memanggil method getListAgent() dan showRecyclerList()
        list.addAll(getListAgent())
        showRecyclerList()
    }

    // Method untuk menampilkan RecyclerView
    private fun showRecyclerList() {
        // Menggunakan LinearLayoutManager
        rvAgent.layoutManager = LinearLayoutManager(this)
        val listAgentAdapter = ListAgentAdapter(list)
        rvAgent.adapter = listAgentAdapter

        // Menggunakan OnItemClickCallback untuk menampilkan Toast dan Intent
        listAgentAdapter.setOnItemClickCallback(object : ListAgentAdapter.OnItemClickCallback {
            override fun onItemClicked(data: Agent) {
                showSelectedAgent(data)
                sendIntent(data)
            }
        })
    }

    // Method untuk menampilkan Toast
    private fun showSelectedAgent(agent: Agent) {
        Toast.makeText(this, "You choose ${agent.name}", Toast.LENGTH_SHORT).show()
    }

    // Method untuk mengirimkan data ke DetailActivity
    private fun sendIntent(dataAgent: Agent) {
        val intent = Intent(this@MainActivity, DetailActivity::class.java)
        // Menggunakan Parcelable
        intent.putExtra(DetailActivity.EXTRA_AGENT, dataAgent)
        startActivity(intent)
    }

    // Method untuk mengambil data dari file strings.xml
    private fun getListAgent(): ArrayList<Agent> {
        val dataName = resources.getStringArray(R.array.data_name)
        val dataRole = resources.getStringArray(R.array.data_role)
        val dataCountry = resources.getStringArray(R.array.data_country)
        val dataUltimate = resources.getStringArray(R.array.data_ultimate)
        val dataRoleIcon = resources.obtainTypedArray(R.array.data_role_icon)
        val dataDescription = resources.getStringArray(R.array.data_description)
        val dataPhoto = resources.obtainTypedArray(R.array.data_photo)

        // Menggunakan ArrayList
        val listAgent = ArrayList<Agent>()
        // Menggunakan for loop untuk mengambil data dari file strings.xml
        for (position in dataName.indices) {
            val agent = Agent(
                dataName[position],
                dataRole[position],
                dataCountry[position],
                dataUltimate[position],
                dataRoleIcon.getResourceId(position, -1),
                dataDescription[position],
                dataPhoto.getResourceId(position, -1)
            )
            listAgent.add(agent)
        }
        return listAgent
    }

    // Method untuk menampilkan menu
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.about_me, menu)
        return super.onCreateOptionsMenu(menu)
    }

    // Method untuk menampilkan AboutPageActivity
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == R.id.about_page) {
            val intent = Intent(this, AboutPageActivity::class.java)
            startActivity(intent)
        }
        return super.onOptionsItemSelected(item)
    }

    // Method untuk menutup aplikasi ketika tombol back ditekan
    override fun onBackPressed() {
        finishAffinity()
    }
}