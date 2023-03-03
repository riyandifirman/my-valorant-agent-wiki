package com.riyandifirman.myvalorantagentwiki

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ListAgentAdapter(private val listAgent: ArrayList<Agent>) : RecyclerView.Adapter<ListAgentAdapter.ListViewHolder>() {

    // Inisiasi variabel onItemClickCallback dengan tipe OnItemClickCallback
    private lateinit var onItemClickCallback: OnItemClickCallback

    class ListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        val imgPhoto = itemView.findViewById<ImageView>(R.id.img_item_photo)
        val tvName = itemView.findViewById<TextView>(R.id.tv_item_name)
        val tvRole = itemView.findViewById<TextView>(R.id.tv_item_role)
        val tvCountry = itemView.findViewById<TextView>(R.id.tv_item_country)
        val tvUltimate = itemView.findViewById<TextView>(R.id.tv_item_ultimate)

    }

    // Fungsi ini akan dipanggil ketika RecyclerView membutuhkan ViewHolder baru untuk menampilkan item.
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        // Membuat view baru
        val view: View = LayoutInflater.from(parent.context).inflate(R.layout.item_row_agent, parent, false)
        // Mengembalikan view yang sudah dibuat
        return ListViewHolder(view)
    }

    // Fungsi getItemCount() digunakan untuk mengembalikan jumlah item yang ada pada list.
    override fun getItemCount(): Int = listAgent.size

    // Fungsi onBindViewHolder() digunakan untuk menghubungkan data dengan view holder.
    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        // Mengambil data dari listAgent berdasarkan posisi
        val (name, role, country, ultimate, role_icon, description, photo) = listAgent[position]
        holder.imgPhoto.setImageResource(photo)
        holder.tvName.text = name
        holder.tvRole.text = role
        holder.tvCountry.text = country
        holder.tvUltimate.text = ultimate

        // Membuat fungsi ketika item di klik
        holder.itemView.setOnClickListener{
            onItemClickCallback.onItemClicked(listAgent[holder.adapterPosition])
        }
    }

    // Membuat fungsi setOnItemClickCallback
    fun setOnItemClickCallback(onItemClickCallback: ListAgentAdapter.OnItemClickCallback) {
        this.onItemClickCallback = onItemClickCallback
    }

    // Membuat interface OnItemClickCallback
    interface OnItemClickCallback {

        // Membuat fungsi onItemClicked
        fun onItemClicked(data: Agent)
    }
}