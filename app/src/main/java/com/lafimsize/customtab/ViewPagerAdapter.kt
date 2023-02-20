package com.lafimsize.customtab

import android.text.Layout
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.lafimsize.customtab.databinding.ViewPagerItemBinding

class ViewPagerAdapter:RecyclerView.Adapter<ViewPagerAdapter.ViewPagerHolder>() {
    private lateinit var binding:ViewPagerItemBinding
    class ViewPagerHolder(val binding:ViewPagerItemBinding):RecyclerView.ViewHolder(binding.root){


    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewPagerHolder {
        val inflater=LayoutInflater.from(parent.context)

        binding=ViewPagerItemBinding.inflate(inflater,parent,false)
        return ViewPagerHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewPagerHolder, position: Int) {
        holder.binding.imageItem.setImageResource(R.drawable.ic_launcher_background)

    }

    override fun getItemCount(): Int {
        return 5
    }
}