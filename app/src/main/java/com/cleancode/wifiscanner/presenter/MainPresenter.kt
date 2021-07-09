package com.cleancode.wifiscanner.presenter

import android.content.Context
import com.cleancode.wifiscanner.contract.MainContract
import com.cleancode.wifiscanner.model.WifiData

class MainPresenter(override var view: MainContract.View?) :
    MainContract.Presenter {

    private val model : WifiData = WifiData()

    override fun getWifiList(context: Context) {
        model.getWifiList(context)
    }

    override fun getItem(size: Int) {
        val tempSize = size + 1
        val tempCount = (size / 10) + 1
        for (index in tempSize..(10 * tempCount)) {
            view?.addItem(index)
        }
        view?.notifyChange()
    }

    override fun getTitle() {
        val title = "Wifi List"
        view?.setTitle(title)
    }


}