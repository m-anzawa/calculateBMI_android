package com.example.calculatebmi_android

class BodyData(date: String, stature: String, weight: String, message: String?) {
    // 測定日
    var date = date
    // 身長
    var stature = stature
    // 体重
    var weight = weight
    // メモ
    var message = message

    companion object {

        fun toJson(data: BodyData): String {

            val dateStr = "date:" + data.date
            val statureStr = "stature:" + data.stature
            val weightStr = "weight:" + data.weight
            val messageStr = "message:" + data.message

            return ("$dateStr,$statureStr,$weightStr,$messageStr")
        }

        fun parseJson(str: String): BodyData {

            val strSplit = str.split(",")

            var dateStr = ""
            var statureStr = ""
            var weightStr = ""
            var messageStr = ""

            for (item in strSplit) {
                val itemSplit = item.split(":")
                when (itemSplit.first()) {
                    "date" -> dateStr = itemSplit.last()
                    "stature" -> statureStr = itemSplit.last()
                    "weight" -> weightStr = itemSplit.last()
                    "message" -> messageStr = itemSplit.last()
                }
            }

            return BodyData(dateStr, statureStr, weightStr, messageStr)
        }
    }
}