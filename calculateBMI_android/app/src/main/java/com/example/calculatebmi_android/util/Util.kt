package com.example.calculatebmi_android

import java.text.SimpleDateFormat
import java.util.*

class Util {
    companion object {

        // 今日の日付文字列
        fun stringDate(): String {
            val df = SimpleDateFormat("yyyyMMdd", Locale.JAPAN)
            val date = Date()

            return df.format(date)
        }

        // yyyyMMddからdを返す
        fun getDay(date: String) : String
        {
            var day = ""
            if (date.count() > 1) {
                day = date.substring(date.count() - 2, date.count())
            }

            return day
        }

        // BMI計算
        fun calculationBMI(stature: Double, weight: Double) : Double? {
            var bmi: Double? = null
            // BMI＝体重(kg) / {身長(m) * 身長(m)}
            val height = (stature / 100) * (stature / 100)
            if (height > 0) {
                bmi = weight / height
            }
            return bmi
        }

        fun formatDouble(data: Double, digits: Int) : String {
            return java.lang.String.format("%.${digits}f", data)
        }

    }
}