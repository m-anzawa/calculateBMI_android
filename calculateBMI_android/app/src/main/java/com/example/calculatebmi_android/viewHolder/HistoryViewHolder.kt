package com.example.calculatebmi_android

import android.support.v7.widget.RecyclerView
import android.view.View
import android.widget.TextView


class HistoryViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){

    val dayLabel: TextView = itemView.findViewById(R.id.dayLabel)
    val statureLabel: TextView = itemView.findViewById(R.id.statureLabel)
    val weightLabel: TextView = itemView.findViewById(R.id.weightLabel)
    val bmiLabel: TextView = itemView.findViewById(R.id.bmiLabel)
    val messageLabel: TextView = itemView.findViewById(R.id.messageLabel)

    fun displayData(day: String, stature: String, weight: String, message: String?) {

        val dayStr = "$day 日"
        val statureStr = "$stature cm"
        val weightStr = "$weight kg"
        dayLabel.text = dayStr
        statureLabel.text = statureStr
        weightLabel.text = weightStr
        messageLabel.text = message

        // BMI計算
        val s = stature.toDoubleOrNull()
        val w = weight.toDoubleOrNull()
        if (s != null && w != null){

            val bmi = Util.calculationBMI(s, w)
            if (bmi != null) {
                bmiLabel.text = Util.formatDouble(bmi, 2)
            }

        }

    }

}