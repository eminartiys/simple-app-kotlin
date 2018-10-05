package com.application.library.kotlin.presenter

import com.application.library.kotlin.data.ImmediateSchedulerProvider
import com.application.library.kotlin.model.NewsResponse
import com.application.library.kotlin.presenter.news.NewsPresenter
import com.application.library.kotlin.repository.news.NewsRepository
import com.application.library.kotlin.ui.news.NewsViewContract
import io.reactivex.Single
import org.junit.Before
import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.MockitoAnnotations

class NewsPresenterTest {

    private val SOURCEFOUND = "TECHCRUNCH"
    private val SOURCENOTFOUND = "NEWS"
    private val ITEMS = emptyList<NewsResponse.News>()
    private val RESPONSE = NewsResponse("Success", "", "", SOURCEFOUND, "", ITEMS)
    private val ERROR = Throwable("News Not Found")

    @Mock private var view: NewsViewContract? = null
    @Mock private var repository: NewsRepository? = null

    private lateinit var presenter: NewsPresenter
    private lateinit var schedulerProvider: ImmediateSchedulerProvider

    @Before
    fun setupNewsPresenterTest() {
        MockitoAnnotations.initMocks(this)

        schedulerProvider = ImmediateSchedulerProvider()

        presenter = NewsPresenter(repository!!, schedulerProvider)
        presenter.setView(view!!)
    }

    @Test
    fun testLoadNewsBySources_Success() {
        Mockito.`when`(repository!!.getNews(SOURCEFOUND)).thenReturn(Single.just(RESPONSE))

        presenter.loadNews(SOURCEFOUND)

        Mockito.verify(view!!).showNews(RESPONSE)
    }

    @Test
    fun testLoadNewsBySources_NotFound() {
        Mockito.`when`(repository!!.getNews(SOURCENOTFOUND)).thenReturn(Single.error(ERROR))

        presenter.loadNews(SOURCENOTFOUND)

        Mockito.verify(view!!).handleError()
    }
}