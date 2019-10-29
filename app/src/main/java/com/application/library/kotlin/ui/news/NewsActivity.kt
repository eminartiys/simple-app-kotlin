package com.application.library.kotlin.ui.news

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_news.*
import android.view.MenuItem
import android.view.View
import com.application.library.kotlin.Injector

import com.application.library.kotlin.R
import com.application.library.kotlin.data.api.model.NewsResponse
import com.application.library.kotlin.data.repository.news.NewsRepository
import javax.inject.Inject

/**
 * Created by eminartiys on 8/12/17.
 */
class NewsActivity : AppCompatActivity(), NewsContract.View {

    @Inject lateinit var repository : NewsRepository

    private val adapter = NewsAdapter()

    private lateinit var presenter : NewsContract.Presenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_news)

        setupToolbar()

        Injector.obtain(this)!!.inject(this)

        NewsPresenter(this, repository)

        this.list.adapter = adapter
        this.list.layoutManager = LinearLayoutManager(this)
        presenter.start()

    }

    fun setupToolbar() {
        setSupportActionBar(this.toolbar)
        val actionBar = supportActionBar
                ?: throw IllegalStateException("Action bar must be not null")

        actionBar.setDisplayShowHomeEnabled(true)
        actionBar.setDisplayHomeAsUpEnabled(true)
        actionBar.title = getCurrentSource()
        actionBar.title = actionBar.title
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == android.R.id.home) {
            super.onBackPressed()
            return true
        }
        return super.onOptionsItemSelected(item)
    }

    override fun setPresenter(presenter: NewsContract.Presenter) {
        this.presenter = presenter
    }

    override fun updateView(list: NewsResponse) {
        adapter.clearItems()
        adapter.setItems(list.articles)
    }

    override fun handleError() {
        this.list.visibility = View.GONE
        this.empty_view.visibility = View.VISIBLE
    }

    override fun getCurrentSource(): String {
        val source = intent.getStringExtra("source")
                ?: throw IllegalStateException("field source missing in Intent")

        return source
    }
}
