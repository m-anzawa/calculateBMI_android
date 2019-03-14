package com.example.calculatebmi_android

import android.content.Context
import android.view.View
import android.view.LayoutInflater
import android.support.design.widget.TabLayout
import android.widget.TextView
import android.widget.ImageView

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentStatePagerAdapter


class TagAdapter(fm: FragmentManager, private val context: Context) : FragmentStatePagerAdapter(fm) {


    private val pageTitle = arrayOf(context.getString(R.string.input_text), context.getString(R.string.history_text))
    private val pageIcon = arrayOf(R.drawable.icon_input, R.drawable.icon_history)

    //
    override fun getItem(position: Int): Fragment {
        return InputFragment()
    }
    // タブの名前
    override fun getPageTitle(position: Int): CharSequence? {
        return pageTitle[position]
    }
    // タブの個数
    override fun getCount(): Int {
        return pageTitle.size
    }
    // タブの変更
    fun getTabView(tabLayout: TabLayout, position: Int): View {
        // tab_item.xml を複数
        val view = LayoutInflater.from(this.context).inflate(R.layout.tab_item, tabLayout, false)
        // タイトル
        val tab = view.findViewById<TextView>(R.id.teb_item_text)
        tab.text = pageTitle[position]
        // アイコン
        val image = view.findViewById<ImageView>(R.id.teb_item_image)
        image.setImageResource(pageIcon[position])
        return view
    }
}