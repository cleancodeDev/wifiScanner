package com.cleancode.wifiscanner.model

import android.content.Context
import com.cleancode.wifiscanner.utils.WifiUtils

class WifiData {
    fun getWifiList(context: Context): Array<String> {
        val wifiList = WifiUtils.scan(context)
        val wifiListSize = wifiList?.size ?: 0
        val wifiArr = arrayOf<String>()
        for (index in 0..wifiListSize) {
            wifiArr[index] = wifiList?.get(index).toString()
        }
        return wifiArr
    }
}