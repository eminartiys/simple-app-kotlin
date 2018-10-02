package com.application.library.kotlin.presenter

import com.application.library.kotlin.data.ImmediateSchedulerProvider
import com.application.library.kotlin.model.SourceResponse
import com.application.library.kotlin.presenter.source.SourcePresenter
import com.application.library.kotlin.repository.source.SourceRepository
import com.application.library.kotlin.ui.source.SourceViewContract
import io.reactivex.Single
import org.junit.Before
import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito.`when`
import org.mockito.Mockito.verify
import org.mockito.MockitoAnnotations

class SourcePresenterTest {

    private val ITEMS = emptyList<SourceResponse.Sources>()
    private val RESPONSE = SourceResponse("Success", ITEMS)

    @Mock private var view: SourceViewContract? = null
    @Mock private var repository: SourceRepository? = null

    private lateinit var presenter: SourcePresenter
    private lateinit var schedulerProvider: ImmediateSchedulerProvider

    @Before
    fun setupSourcePresenterTest() {
        MockitoAnnotations.initMocks(this)

        schedulerProvider = ImmediateSchedulerProvider()

        presenter = SourcePresenter(repository!!, schedulerProvider)
        presenter.setView(view!!)
    }

    @Test
    fun testLoadSource_Success() {
        `when`(repository!!.getSource()).thenReturn(Single.just(RESPONSE))

        presenter.loadSource()

        verify(view!!).showSources(RESPONSE)
    }
}