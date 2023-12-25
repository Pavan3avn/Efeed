package com.pavan.efeed.adapters

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.pavan.efeed.Models.Issues
import com.pavan.efeed.R


class Adapter( private var issuelist: List<Issues> ):RecyclerView.Adapter<Adapter.viewholder>() {
    inner class viewholder(v: View):RecyclerView.ViewHolder(v) {
         val imageView : ImageView = v.findViewById(R.id.profile)
         val title:TextView = v.findViewById(R.id.title)
         val created : TextView = v.findViewById(R.id.created)
         val closed : TextView  = v.findViewById(R.id.closed)
         val user : TextView = v.findViewById(R.id.username)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Adapter.viewholder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item,parent,false)
        return viewholder(view)
    }

    override fun onBindViewHolder(holder: Adapter.viewholder, position: Int) {
         val issue = issuelist[position]
        holder.title.text = issue.title
        holder.created.text = holder.itemView.context.getString(R.string.created,issue.created)
        holder.closed.text = holder.itemView.context.getString(R.string.closed,issue.closed)
        holder.user.text = holder.itemView.context.getString(R.string.name,issue.user.name)
        val image = issue
        Glide.with(holder.itemView)
            .load(image.user.avatarUrl)
            .into(holder.imageView)
    }

    override fun getItemCount(): Int {
        return issuelist.size
    }

    @SuppressLint("NotifyDataSetChanged")
    fun submitList(list : List<Issues>){
        this.issuelist = list
        notifyDataSetChanged()
    }
}