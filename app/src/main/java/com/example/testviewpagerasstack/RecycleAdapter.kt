package com.example.testviewpagerasstack

import android.annotation.SuppressLint
import android.content.Context
import android.graphics.Paint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager.widget.ViewPager

class RecycleAdapter : RecyclerView.Adapter<RecycleAdapter.AppointmentDetailsViewHolder>() {

    private lateinit var context: Context
    private lateinit var list:List<String>

    class AppointmentDetailsViewHolder (itemView: View) : RecyclerView.ViewHolder(itemView) {
        //appointment details
        val pager = itemView.findViewById(R.id.viewpager) as ViewPager



    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AppointmentDetailsViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.recycle_view_list_layout, parent, false)
        context = parent.context
        return AppointmentDetailsViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: AppointmentDetailsViewHolder, position: Int) {
//        holder.imageViewAppointmentDetails
        val adapter = ViewPagerAdapter()
        adapter.setDataList(listOf("a","b","c","d","e","f","g","h","i","j","k"),context)
        holder.pager.setPageTransformer(true,ViewPagerStack())
        holder.pager.offscreenPageLimit = 4
        holder.pager.adapter = adapter

    }
    fun setData(list: List<String>){
        this.list = list
    }

    override fun getItemCount(): Int {
        return list.size
    }

    private class ViewPagerStack : ViewPager.PageTransformer{
        override fun transformPage(page: View, position: Float) {
            if(position >= 0){
                page.scaleX = 0.7f - 0.05f * position
                page.scaleY = 0.7f
                page.translationX = -page.width * position
                page.translationY = -30 * position
            }
        }

    }


}

