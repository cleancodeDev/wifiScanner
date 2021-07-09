package com.cleancode.wifiscanner

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.cleancode.wifiscanner.adapter.MainAdapter
import com.cleancode.wifiscanner.contract.MainContract
import com.cleancode.wifiscanner.presenter.MainPresenter

class MainActivity : AppCompatActivity(), MainContract.View {
    private var presenter: MainContract.Presenter? = null
    private var list: RecyclerView? = null
    private var title: TextView? = null
    private var btn: Button? = null
    private var adapter: MainAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        init()
    }

    private fun init() {
        list = findViewById(R.id.wifi_list)
        title = findViewById(R.id.title)
        btn = findViewById(R.id.scanBtn)
        presenter = MainPresenter(this)
        presenter?.view = this
        list?.adapter = adapter
        presenter?.getItem(0)
        addListener()
    }

    private fun addListener() {
        btn?.setOnClickListener {
            presenter?.getWifiList(applicationContext)
            presenter?.getItem(adapter?.itemCount ?: 0)
        }
    }

    override fun addItem(index: Int) {
        adapter?.addItem(index)
    }

    override fun notifyChange() {
        adapter?.notifyDataSetChanged()
    }

    override fun setTitle(title: String?) {
        this.title?.text = title
    }
}