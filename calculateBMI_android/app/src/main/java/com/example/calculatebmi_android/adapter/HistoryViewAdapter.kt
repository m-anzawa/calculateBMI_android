package com.example.calculatebmi_android.adapter

import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.calculatebmi_android.BodyData
import com.example.calculatebmi_android.HistoryViewHolder
import com.example.calculatebmi_android.R
import com.example.calculatebmi_android.Util


class HistoryViewAdapter(private val list: List<BodyData>, private val listener: ListListener) : RecyclerView.Adapter<HistoryViewHolder>() {

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HistoryViewHolder {
            Log.d("Adapter", "onCreateViewHolder")
            val rowView: View = LayoutInflater.from(parent.context).inflate(R.layout.list_item, parent, false)

            return HistoryViewHolder(rowView)
        }

        override fun onBindViewHolder(holder: HistoryViewHolder, position: Int) {
            Log.d("Adapter", "onBindViewHolder")

//            val dayStr = Util.getDay(list[posiq])     getDay(date: historyData[indexPath.section].data[indexPath.row].date)
//            val stature = historyData[indexPath.section].data[indexPath.row].stature
//            val weight = historyData[indexPath.section].data[indexPath.row].weight
//            val message = historyData[indexPath.section].data[indexPath.row].message

            //holder.displayData()

            holder.dayLabel.text = list[position].date
            holder.statureLabel.text = list[position].stature
//            holder.itemView.setOnClickListener {
//                listener.onClickRow(it, list[position])
//            }
        }

        override fun getItemCount(): Int {
            Log.d("Adapter", "getItemCount")
            return list.size
        }

        interface ListListener {
            fun onClickRow(tappedView: View, rowModel: BodyData)
        }
    }