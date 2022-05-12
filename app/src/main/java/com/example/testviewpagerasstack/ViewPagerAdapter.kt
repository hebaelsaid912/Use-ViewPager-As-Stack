package com.example.testviewpagerasstack

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.viewpager.widget.PagerAdapter

class ViewPagerAdapter:PagerAdapter() {

    private lateinit var list:List<String>
    private lateinit var context:Context
    override fun getCount(): Int {
        return list.size
    }

    override fun isViewFromObject(view: View, `object`: Any): Boolean {
        return view == `object`
    }
    fun setDataList(list: List<String>,context: Context){
        this.list = list
        this.context = context
    }
    override fun instantiateItem(container: ViewGroup, position: Int): Any {
        val inflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        val view = inflater.inflate(R.layout.view_layout,container,false)
        container.addView(view)
        val image = view.findViewById<ImageView>(R.id.pager_image)
        image.setImageResource(R.drawable.rectangle_purple)
        return view
    }

    override fun destroyItem(container: ViewGroup, position: Int, `object`: Any) {
        container.removeView(`object` as View)
    }
}