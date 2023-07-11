package com.example.multiplerecyclerview

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.multiplerecyclerview.DataBase.TYPE_HEADER
import com.example.multiplerecyclerview.DataBase.TYPE_ITEM
import com.example.multiplerecyclerview.databinding.HeaderDesignBinding
import com.example.multiplerecyclerview.databinding.ItemDesignBinding

class Adapter: RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    class ItemViewHolder(val itemBinding: ItemDesignBinding): RecyclerView.ViewHolder(itemBinding.root){
        fun bind(item: DataItem.Item){
            itemBinding.item = item
        }
    }
    class HeaderViewHolder(val headerBinding: HeaderDesignBinding):RecyclerView.ViewHolder(headerBinding.root){
        fun bind(header: DataItem.Header){
            headerBinding.header = header.texto
        }
    }

    private val itemList = arrayListOf<Any>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
       return when(viewType){
           TYPE_ITEM->ItemViewHolder(ItemDesignBinding.inflate(LayoutInflater.from(parent.context),parent,false))
           TYPE_HEADER->HeaderViewHolder(HeaderDesignBinding.inflate(LayoutInflater.from(parent.context),parent,false))
           else -> throw IllegalArgumentException("View Type Inválido")
       }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when(holder){
            is ItemViewHolder -> holder.bind(itemList[position] as DataItem.Item)
            is HeaderViewHolder -> holder.bind(itemList[position] as DataItem.Header)
        }
    }

    override fun getItemCount(): Int = itemList.size

    override fun getItemViewType(position: Int): Int {
        return  when(itemList[position]){
            is DataItem.Item -> TYPE_ITEM
            is DataItem.Header -> TYPE_HEADER
            else -> throw IllegalArgumentException("Item Inválido")
        }
    }

    fun updateList(updateList: List<Any>){
        itemList.clear()
        itemList.addAll(updateList)
        notifyDataSetChanged()
    }
}