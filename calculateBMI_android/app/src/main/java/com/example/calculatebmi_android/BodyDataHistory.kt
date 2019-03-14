package com.example.calculatebmi_android

import android.content.Context
import android.support.v7.app.AppCompatActivity
import android.support.v4.app.Fragment
import android.util.Log
import android.os.Bundle
import org.json.JSONArray



class BodyDataHistory : Fragment() {

    // リスト
    var dataList: ArrayList<BodyData> = ArrayList()



    // Fragment生成時にシステムが呼び出す
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        //dataList = getData()

    }



    // データの登録
    fun getSaveData(data: BodyData) : ArrayList<String> {

        // 既に存在する日付があれば上書きする
        val index = dateIndex(data. date)
        if (index != null) {
            // 削除
            remove(index)
        }
        dataList.add(data)

        val arrayList: ArrayList<String> = ArrayList()
        for (item in dataList) {
            arrayList.add(BodyData.toJson(item))
        }

        return arrayList
    }

    // 指定の日付のインデックスを返す
    private fun dateIndex(date: String) : Int?  {
        if (dataList.count() > 0) {
            for(i in dataList.indices) {
                if (date == dataList[i].date) {
                    return i
                }
            }
        }
        return null
    }

    private fun remove(index: Int) {
        val tempData: ArrayList<BodyData> = ArrayList()

        // 配列から削除
        if (dataList.count() > 0) {
            for (i in dataList.indices) {
                if (i != index) {
                    tempData.add(dataList[i])
                }
            }
            dataList = tempData
        }
    }

    // リストの保存
//    private fun saveArrayList(key: String, arrayList: ArrayList<String>) {
//        val shardPreferences = activity.getPreferences(Context.MODE_PRIVATE)
//        val shardPrefEditor = shardPreferences.edit()
//
//        val jsonArray = JSONArray(arrayList)
//        shardPrefEditor.putString(key, jsonArray.toString())
//        shardPrefEditor.apply()
//    }
//
//    // リストの読み込み
//    private fun loadArrayList(key: String) : JSONArray {
//
//        val shardPreferences = (activity as AppCompatActivity).getPreferences(Context.MODE_PRIVATE)
//
//        val jsonArray = JSONArray(shardPreferences.getString(key, "[]"));
//
//        for (i in 0 until jsonArray.length()) {
//            Log.i("loadArrayList", "[$i] -> " + jsonArray.get(i))
//        }
//
//        return jsonArray
//    }

//    private fun getData() : ArrayList<BodyData> {
//        val list: ArrayList<BodyData> = ArrayList()
//
////        val jsonArray = loadArrayList(DATA_KEY)
//        val maActivity = getActivity() as MainActivity?
//        val jsonArray = maActivity!!.loadArrayList(DATA_KEY)
//
//        for (i in 0 until jsonArray.length()) {
//            list.add(BodyData.parseJson(jsonArray.getString(i)))
//        }
//        return list
//    }

}