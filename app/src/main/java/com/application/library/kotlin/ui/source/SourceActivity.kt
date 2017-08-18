package com.application.library.kotlin.ui.source

import kotlinx.android.synthetic.main.activity_source.*
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.RecyclerView
import com.application.library.kotlin.Injector

import com.application.library.kotlin.R
import com.application.library.kotlin.data.api.model.SourceResponse
import com.application.library.kotlin.data.repository.source.SourceRepository
import com.application.library.kotlin.ui.news.NewsActivity
import com.application.library.kotlin.ui.source.SourceContract.Presenter
import javax.inject.Inject

/**
 * Created by eminartiys on 8/4/17.
 */
class SourceActivity : AppCompatActivity(), SourceContract.View {

    @Inject lateinit var repository : SourceRepository


    private val adapter = SourceAdapter()

    private lateinit var presenter : SourceContract.Presenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_source)

        setSupportActionBar(this.toolbar)

        Injector.obtain(this)!!.inject(this)

        SourcePresenter(this, repository)

        adapter.setClickListener(object: SourceAdapter.ItemClickListener{
            override fun onItemClickListener(item: SourceResponse.Sources) {
                val intent = Intent(applicationContext, NewsActivity::class.java)
                intent.putExtra("source", item.name)
                startActivity(intent)
            }

        })

        this.list.adapter = adapter
        this.list.layoutManager = GridLayoutManager(this, 2) as RecyclerView.LayoutManager?
        presenter.start()
    }

    override fun updateView(list: SourceResponse) {
        adapter.clearItems()
        adapter.setItems(list.sources)
    }

    override fun setPresenter(presenter: Presenter) {
        this.presenter = presenter
    }
}
