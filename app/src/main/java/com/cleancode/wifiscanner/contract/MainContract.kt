package com.cleancode.wifiscanner.contract

import android.content.Context
import com.cleancode.wifiscanner.model.WifiData

interface MainContract {

    interface View {
        fun addItem(index: Int)
        fun notifyChange()
        fun setTitle(title: String?)
    }

    interface Presenter {
        var view: View?
        fun getWifiList(context: Context)
        fun getItem(index: Int)
        fun getTitle()
    }
}