package com.example.calculatebmi_android.fragment

import android.app.AlertDialog
import android.app.Dialog
import android.content.DialogInterface
import android.os.Bundle
import android.support.v4.app.DialogFragment

class AlertDialogFragment : DialogFragment() {

    var msg = "msg"
    var okText = "OK"
    var cancelText = "cancel"
    var cancel = false

    // 押下時の挙動 デフォルトでは何もしない
    var onOkClickListener : DialogInterface.OnClickListener? = DialogInterface.OnClickListener { _, _ -> }
    var onCancelClickListener : DialogInterface.OnClickListener? = DialogInterface.OnClickListener { _, _ -> }

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {

        if (cancel) {
            // OKとCancel
            return okCancel()
        } else {
            // OKのみ
            return okOnly()
        }

    }

    override fun onPause() {
        super.onPause()
        // onPause でダイアログを閉じる場合
        dismiss()
    }

    private fun okOnly () : Dialog {
        val builder = AlertDialog.Builder(activity)
        builder.setTitle("")
            .setMessage(msg)
            .setPositiveButton(okText, onOkClickListener)
        // Create the AlertDialog object and return it
        return builder.create()
    }

    private fun okCancel () : Dialog {
        val builder = AlertDialog.Builder(activity)
        builder.setTitle("")
            .setMessage(msg)
            .setPositiveButton(okText, onOkClickListener)
            .setNegativeButton(cancelText, onCancelClickListener)
        // Create the AlertDialog object and return it
        return builder.create()
    }
}