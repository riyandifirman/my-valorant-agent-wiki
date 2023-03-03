package com.riyandifirman.myvalorantagentwiki

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ListAgentAdapter(private val listAgent: ArrayList<Agent>) : RecyclerView.Adapter<ListAgentAdapter.ListViewHolder>() {

    private lateinit var onItemClickCallback: OnItemClickCallback

    class ListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        val imgPhoto = itemView.findViewById<ImageView>(R.id.img_item_photo)
        val tvName = itemView.findViewById<TextView>(R.id.tv_item_name)
        val tvRole = itemView.findViewById<TextView>(R.id.tv_item_role)
        val tvCountry = itemView.findViewById<TextView>(R.id.tv_item_country)
        val tvUltimate = itemView.findViewById<TextView>(R.id.tv_item_ultimate)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        val view: View = LayoutInflater.from(parent.context).inflate(R.layout.item_row_agent, parent, false)
        return ListViewHolder(view)
    }

    override fun getItemCount(): Int = listAgent.size

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val (name, role, country, ultimate, role_icon, description, photo) = listAgent[position]
        holder.imgPhoto.setImageResource(photo)
        holder.tvName.text = name
        holder.tvRole.text = role
        holder.tvCountry.text = country
        holder.tvUltimate.text = ultimate

        holder.itemView.setOnClickListener{
            onItemClickCallback.onItemClicked(listAgent[holder.adapterPosition])
        }
    }

    fun setOnItemClickCallback(onItemClickCallback: ListAgentAdapter.OnItemClickCallback) {
        this.onItemClickCallback = onItemClickCallback
    }

    interface OnItemClickCallback {

        fun onItemClicked(data: Agent)
    }
}