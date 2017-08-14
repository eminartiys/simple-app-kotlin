package com.application.library.kotlin.ui.source

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.RecyclerView
import android.support.v7.widget.Toolbar
import com.application.library.kotlin.Injector

import com.application.library.kotlin.R
import com.application.library.kotlin.data.api.model.SourceResponse
import com.application.library.kotlin.data.repository.source.SourceRepository
import com.application.library.kotlin.ui.source.SourceContract.Presenter
import javax.inject.Inject

/**
 * Created by eminartiys on 8/4/17.
 */

class SourceActivity() : AppCompatActivity(), SourceContract.View {

    @Inject lateinit var repository : SourceRepository

    private val toolbar : Toolbar by lazy {
       findViewById(R.id.toolbar) as Toolbar
    }

    private val list : RecyclerView by lazy {
        findViewById(R.id.list) as RecyclerView
    }

    private val adapter = SourceAdapter()

    private lateinit var presenter : SourceContract.Presenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_source)

        setSupportActionBar(toolbar)

        Injector.obtain(this)!!.inject(this)

        SourcePresenter(this, repository)

        list.adapter = adapter
        val layoutManager = GridLayoutManager(this, 2)
        list.layoutManager = layoutManager

        presenter.getData()
    }

    override fun updateView(list: SourceResponse) {

        adapter.setItems(list.sources)
    }

    override fun setPresenter(presenter: Presenter) {
        this.presenter = presenter
    }
}
