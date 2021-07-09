package com.cleancode.wifiscanner.adapter

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.cleancode.wifiscanner.model.WifiModel

class MainAdapter : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private val itemList : MutableList<WifiModel> = ArrayList()

    override fun getItemId(p0: Int): Long {
        TODO("Not yet implemented")
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        TODO("Not yet implemented")
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        TODO("Not yet implemented")
    }

    override fun getItemCount(): Int {
        return itemList.size
    }

    fun addItem(index: Int) {

    }
}