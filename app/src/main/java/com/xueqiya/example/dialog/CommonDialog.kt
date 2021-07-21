package com.xueqiya.example.dialog

import android.content.Context
import android.content.DialogInterface
import android.text.InputType
import android.widget.EditText
import androidx.annotation.LayoutRes
import com.afollestad.materialdialogs.MaterialDialog
import com.afollestad.materialdialogs.ModalDialog
import com.afollestad.materialdialogs.customview.customView
import com.afollestad.materialdialogs.input.getInputLayout
import com.afollestad.materialdialogs.input.input
import com.afollestad.materialdialogs.list.listItems
import com.xueqiya.example.R
import com.google.android.material.textfield.TextInputLayout

object CommonDialog {
    const val NegativeIndex = -1
    const val PositiveIndex = -2
    const val NeutralIndex = -3

    fun alert(context: Context, title: String = "提示", message: String) {
        MaterialDialog(context).show {
            title(text = title)
            message(text = message)
        }
    }

    fun alert(
        context: Context,
        title: String = "提示",
        message: String,
        onClickListener: DialogClickListener
    ) {
        MaterialDialog(context).show {
            title(null, title)
            message(null, message)
            negativeButton(android.R.string.cancel) {
                onClickListener.onClick(it, NegativeIndex)
            }
            positiveButton(android.R.string.ok) {
                onClickListener.onClick(it, PositiveIndex)
            }
        }
    }

    fun list(
        context: Context,
        title: String,
        list: List<String>,
        onClickListener: DialogClickListener
    ) {
        MaterialDialog(context).show {
            title(text = title)
            listItems(items = list) { _, index, _ ->
                onClickListener.onClick(this, index)
            }
        }
    }

    fun customView(
        context: Context,
        title: String,
        @LayoutRes viewRes: Int,
        onClickListener: DialogClickListener
    ): MaterialDialog {
        return MaterialDialog(context, ModalDialog).show {
            title(text = title)
            customView(viewRes, scrollable = true, horizontalPadding = true)
            negativeButton(text = "取消") {
                onClickListener.onClick(this, NegativeIndex)
            }
            positiveButton(text = "确定") {
                onClickListener.onClick(this, PositiveIndex)
            }
        }
    }

    fun input(
        context: Context,
        title: String,
        hint: String,
        maxLength: Int,
        onClickListener: DialogClickListener
    ) {
        MaterialDialog(context).show {
            title(text = title)
            input(
                hint = hint,
                inputType = InputType.TYPE_CLASS_TEXT,
                maxLength = maxLength,
                allowEmpty = true
            )
            negativeButton(text = "取消") {
                onClickListener.onClick(this, NegativeIndex, this.getInputLayout().editText!!)
            }
            positiveButton(text = "确定") {
                onClickListener.onClick(this, PositiveIndex, this.getInputLayout().editText!!)
            }
        }
    }
}

abstract class DialogClickListener {
    open fun onClick(dialog: DialogInterface, which: Int) {
        dialog.dismiss()
    }

    open fun onClick(dialog: DialogInterface, which: Int, editText: EditText) {
        dialog.dismiss()
    }
}