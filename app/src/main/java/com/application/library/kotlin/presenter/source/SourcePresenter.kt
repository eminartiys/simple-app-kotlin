package com.application.library.kotlin.presenter.source

import com.application.library.kotlin.repository.source.SourceRepository
import com.application.library.kotlin.ui.source.SourceViewContract
import io.reactivex.disposables.Disposable
import timber.log.Timber
import javax.inject.Inject

/**
 * Created by eminartiys on 8/5/17.
 */
class SourcePresenter @Inject
    constructor(private val repository: SourceRepository): SourcePresenterContract {

    private lateinit var view: SourceViewContract
    private var disposable: Disposable? = null

    override fun setView(view: SourceViewContract) {
        this.view = view
    }

    override fun cancelLoadSource() {
        Timber.i("Undispose")

        disposable?.let {
            if (!disposable!!.isDisposed) {
                disposable!!.dispose()
                disposable = null
            }
        }
    }

    override fun loadSource() {
        disposable = repository.getSource()
                .subscribe({
                    sources -> view.showSources(sources) }, {
                })
    }

}

