package com.cleancode.wifiscanner.utils

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import android.net.wifi.ScanResult
import android.net.wifi.WifiManager
import android.os.Build
import androidx.annotation.RequiresApi
import com.cleancode.wifiscanner.contract.MainContract

object WifiUtils {

    // 와이파이 검색
    fun scan(context: Context) : List<ScanResult>?{
        val wifiManager =
            context.applicationContext.getSystemService(Context.WIFI_SERVICE) as WifiManager
        var results: List<ScanResult>? = null
        val wifiScanReceiver = object : BroadcastReceiver() {
            @RequiresApi(Build.VERSION_CODES.M)
            override fun onReceive(context: Context, intent: Intent) {
                val success = intent.getBooleanExtra(WifiManager.EXTRA_RESULTS_UPDATED, false)
                results = if (success) {
                    wifiManager.scanResults
                } else {
                    null
                }
            }
        }

        val intentFilter = IntentFilter()
        intentFilter.addAction(WifiManager.SCAN_RESULTS_AVAILABLE_ACTION)
        context.registerReceiver(wifiScanReceiver, intentFilter)

        return results
    }
}