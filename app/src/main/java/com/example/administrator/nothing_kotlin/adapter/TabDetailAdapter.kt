package com.example.administrator.nothing_kotlin.adapter

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.example.administrator.nothing_kotlin.R
import com.example.administrator.nothing_kotlin.bean.RespHomeDetailData
import com.example.administrator.nothing_kotlin.cardview.CardView
import com.example.administrator.nothing_kotlin.utils.LogU
import com.example.administrator.nothing_kotlin.utils.glide_utils.GlideU

class TabDetailAdapter(var context: Context , var list: ArrayList<RespHomeDetailData.Result> , var itemClick: ItemClick) : RecyclerView.Adapter<TabDetailAdapter.TabDetailAdapter_VH>() {

    var inflater : LayoutInflater? = null

    init {
        inflater = LayoutInflater.from(context)
    }

    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): TabDetailAdapter_VH {
        var view = inflater?.inflate(R.layout.fragment_tab_layout , p0 , false)
        return TabDetailAdapter_VH(view!!)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(p0: TabDetailAdapter_VH, p1: Int) {
        val result = list.get(p1)
        if(result.cover != null && result.cover.length > 0){
            GlideU
                    .get()
                    .with(context)
                    .compressScale(10)
                    .loadImgNormal(p0.tab_img , result.cover)

        }
        p0.tab_tv.setText(result.title)
        p0.tab_container.setOnClickListener {
            itemClick.onItemClick(p1)
        }
    }


    open class TabDetailAdapter_VH(view: View) : RecyclerView.ViewHolder(view){
        var tab_img : ImageView = view.findViewById(R.id.tab_img)
        var tab_tv : TextView = view.findViewById(R.id.tab_title)
        var tab_container : CardView = view.findViewById(R.id.tab_container)
        var tab_img_progress : TextView = view.findViewById(R.id.tab_img_progress)
    }

    open interface ItemClick{
        fun onItemClick(psn : Int)
    }
}