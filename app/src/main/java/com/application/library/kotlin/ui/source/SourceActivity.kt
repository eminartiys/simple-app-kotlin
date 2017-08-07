package com.application.library.kotlin.ui.source

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.RecyclerView
import android.widget.Toolbar
import butterknife.Bind
import butterknife.ButterKnife
import com.application.library.kotlin.Injector

import com.application.library.kotlin.R
import com.application.library.kotlin.data.api.model.SourceResponse
import com.application.library.kotlin.data.api.service.SourceService
import com.application.library.kotlin.data.repository.source.RemoteSourceDataSource
import com.application.library.kotlin.data.repository.source.SourceRepository
import com.application.library.kotlin.ui.source.SourceContract.Presenter
import javax.inject.Inject

class SourceActivity() : AppCompatActivity(), SourceContract.View {

    @Inject lateinit var repository : SourceRepository

    private val toolbar : Toolbar by lazy {
       findViewById(R.id.toolbar) as Toolbar
    }

    private val list : RecyclerView by lazy {
        findViewById(R.id.list) as RecyclerView
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_source)

        SourcePresenter(this, repository)

    }

    override fun updateView(list: SourceResponse) {

    }

    override fun setPresenter(presenter: Presenter) {
        this.presenter = presenter
    }
}

