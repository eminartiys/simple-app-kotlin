package com.application.library.kotlin.ui.news

import com.application.library.kotlin.data.api.model.NewsResponse
import com.application.library.kotlin.data.repository.news.NewsDataSource
import com.application.library.kotlin.data.repository.news.NewsRepository
import io.kotlintest.Spec
import io.kotlintest.specs.BehaviorSpec
import io.mockk.every
import io.mockk.mockk
import io.mockk.verify
import org.amshove.kluent.shouldEqual
import org.apache.commons.lang3.reflect.FieldUtils

/**
 * Created by Eminarti Sianturi on 2019-10-29.
 */
class NewsBehaviorTest : BehaviorSpec() {

    private lateinit var view: NewsContract.View
    private lateinit var repository: NewsRepository
    private lateinit var presenter: NewsPresenter
    private lateinit var throwable: Throwable
    private lateinit var newsResponse: NewsResponse

    private fun setPrivateField(fieldName: String, value: Any?) {
        FieldUtils.writeDeclaredField(presenter, fieldName, value, true)
    }

    private fun getPrivateField(fieldName: String): Any? {
        return FieldUtils.readDeclaredField(presenter, fieldName, true)
    }

    override fun beforeSpec(spec: Spec) {
        super.beforeSpec(spec)

        repository = mockk(relaxed = true)
        view = mockk(relaxed = true)
        throwable = mockk(relaxed = true)
        newsResponse = mockk(relaxed = true)

        presenter = NewsPresenter(view, repository)
    }

    init {
        val source = "techcrunch"
        given("I open news detail page with specific source") {

            `when`("I see news detail page") {
                then("It should fetch news feed based on source") {
                    verify(exactly = 1) { view.setPresenter(presenter) }
                    presenter.repository shouldEqual repository
                }
            }

            every { view.getCurrentSource() } returns source

            and("Failed when fetch news feed") {
                every { repository.getNews(any(), any()) } answers {
                    secondArg<NewsDataSource.LoadDataCallback>().onError(throwable)
                }
            }

            `when`("I see news detail page with specific source") {
                presenter.start()

                then("I will see error") {
                    verify(exactly = 1) { view.handleError() }
                }
            }

            and("Success when fetch news feed") {
                every { repository.getNews(any(), any()) } answers {
                    secondArg<NewsDataSource.LoadDataCallback>().onDataLoaded(newsResponse)
                }
            }

            `when`("I will see news detail page with specific source") {
                presenter.start()

                then("I will see news feed loaded") {
                    verify(exactly = 1) { view.updateView(newsResponse) }
                }
            }


        }
    }

}