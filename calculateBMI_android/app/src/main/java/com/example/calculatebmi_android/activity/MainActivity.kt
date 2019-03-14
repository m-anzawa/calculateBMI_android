package com.example.calculatebmi_android

import android.support.v7.app.AppCompatActivity
import android.support.design.widget.TabLayout
import org.json.JSONArray
import android.os.Bundle
import android.content.Context
import kotlinx.android.synthetic.main.activity_main.pager
import kotlinx.android.synthetic.main.activity_main.tabs
import android.util.Log


class MainActivity : AppCompatActivity() {

    // キー
    private val DATA_KEY = "bodydata"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)

        setTabLayout()
    }

    // タブの設定
    private fun setTabLayout() {
        val adapter = TagAdapter(supportFragmentManager, this)
        pager.adapter = adapter
        tabs.setupWithViewPager(pager)
        for (i in 0 until adapter.count) {
            val tab: TabLayout.Tab = tabs.getTabAt(i)!!
            tab.customView = adapter.getTabView(tabs, i)
        }
    }


    // リストの保存
    fun saveArrayList(arrayList: ArrayList<String>) {

        val shardPreferences = this.getPreferences(Context.MODE_PRIVATE)
        val shardPrefEditor = shardPreferences.edit()

        val jsonArray = JSONArray(arrayList)
        shardPrefEditor.putString(DATA_KEY, jsonArray.toString())
        shardPrefEditor.apply()
    }

    // リストの読み込み
    fun loadArrayList(key: String) : JSONArray {

        val shardPreferences = this.getPreferences(Context.MODE_PRIVATE)

        val jsonArray = JSONArray(shardPreferences.getString(key, "[]"));

        for (i in 0 until jsonArray.length()) {
            Log.i("loadArrayList", "[$i] -> " + jsonArray.get(i))
        }

        return jsonArray
    }

}
