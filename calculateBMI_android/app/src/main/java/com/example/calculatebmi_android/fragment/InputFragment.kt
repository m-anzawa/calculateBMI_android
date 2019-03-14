package com.example.calculatebmi_android

import android.support.v4.app.Fragment
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import com.example.calculatebmi_android.fragment.AlertDialogFragment

class InputFragment : Fragment() {


    // 履歴データ
    val bodyDataHistory = BodyDataHistory()

    //
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        super.onCreateView(inflater, container, savedInstanceState)
        val view = inflater.inflate(R.layout.fragment_input, container, false)

        // タイトル
        (activity as AppCompatActivity).supportActionBar?.title = getString(R.string.input_text)

        // ボタン
        buttonSetting(view)

        return view
    }

    // ボタン設定
    private fun buttonSetting(view: View){

        val today = Util.stringDate()
        val stature = view.findViewById<TextView>(R.id.statureInput).text
        val weight = view.findViewById<TextView>(R.id.weightInput).text
        val memo = view.findViewById<TextView>(R.id.memoInput).text


        // BMI計算ボタン
        view.findViewById<Button>(R.id.calculationButton).setOnClickListener {
            if (validate(stature.toString(), weight.toString())) {
                val bmi = Util.calculationBMI(stature.toString().toDouble(), weight.toString().toDouble())
                if (bmi != null) {
                    // 結果のラベルを表示
                    view.findViewById<TextView>(R.id.messageLabel2).text = Util.formatDouble(bmi, 2)
                } else {
                    val dialog = AlertDialogFragment()
                    dialog.msg = "計算が正しく行われませんでした"
                    dialog.show((activity as AppCompatActivity).supportFragmentManager,"alert")
                }
            }
        }

        // 保存ボタン
        view.findViewById<Button>(R.id.saveButton).setOnClickListener {
            if (validate(stature.toString(), weight.toString())) {
                // 今日の日付のデータ
                val data = BodyData(today, stature.toString(), weight.toString(), memo.toString())
                // 保存
                val maActivity = getActivity() as MainActivity?
                maActivity!!.saveArrayList(bodyDataHistory.getSaveData(data))

                val dialog = AlertDialogFragment()
                dialog.msg = "保存しました"
                dialog.show((activity as AppCompatActivity).supportFragmentManager,"alert")
            }
        }

        // 削除ボタン


    }

    // 入力チェック
    fun validate(stature: String, weight: String) : Boolean {
        if (!stature.isEmpty() && !weight.isEmpty()) {
            if (stature.toDoubleOrNull() != null && weight.toDoubleOrNull() != null) {
                return true
            }
        }

        val dialog = AlertDialogFragment()
        dialog.msg = "身長と体重を半角数字で入力してください"
        dialog.show((activity as AppCompatActivity).supportFragmentManager,"alert")

        return false
    }

}