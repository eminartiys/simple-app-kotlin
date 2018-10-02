package com.application.library.kotlin.ui.news

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.view.MenuItem
import android.view.View
import com.application.library.kotlin.Injector
import com.application.library.kotlin.R
import com.application.library.kotlin.model.NewsResponse
import com.application.library.kotlin.presenter.news.NewsPresenter
import kotlinx.android.synthetic.main.activity_news.*
import javax.inject.Inject

/**
 * Created by eminartiys on 8/12/17.
 */
class NewsActivity : AppCompatActivity(), NewsViewContract {

    @Inject lateinit var presenter: NewsPresenter

    private val adapter = NewsAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_news)

        setupToolbar()

        Injector.obtain(this)!!.inject(this)

        this.list.adapter = adapter
        this.list.layoutManager = LinearLayoutManager(this)

        presenter.setView(this)
        presenter.loadNews(getCurrentSource())
    }

    fun setupToolbar() {
        setSupportActionBar(this.toolbar)
        val actionBar = supportActionBar
                ?: throw IllegalStateException("Action bar must be not null")

        actionBar.setDisplayShowHomeEnabled(true)
        actionBar.setDisplayHomeAsUpEnabled(true)
        actionBar.title = getCurrentSource()
        actionBar.setTitle(actionBar.title)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == android.R.id.home) {
            super.onBackPressed()
            return true
        }
        return super.onOptionsItemSelected(item)
    }

    override fun showNews(list: NewsResponse) {
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
