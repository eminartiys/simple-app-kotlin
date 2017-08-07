package com.application.library.kotlin.ui.source

import com.application.library.kotlin.data.api.model.SourceResponse
import com.application.library.kotlin.data.repository.source.SourceDataSource
import com.application.library.kotlin.data.repository.source.SourceRepository

/**
 * Created by eminartiys on 8/5/17.
 */
class SourcePresenter(val view : SourceContract.View, val repository: SourceRepository)
    : SourceContract.Presenter {

    fun setViewToPresenter() {
        this.view.setPresenter(this)
    }

    override fun getData() {
        repository.getSource(object : SourceDataSource.LoadDataCallback {
            override fun onDataLoaded(sourceResponse: SourceResponse) {
                view.updateView(sourceResponse)
            }

            override fun onError(throwable: Throwable) {

            }

        })
    }

}

//public class SourcePresenter implements SourceContract.Presenter {
//
//    private SourceContract.View view;
//    private SourceRepository repository;
//
//    public SourcePresenter(SourceContract.View view, SourceRepository repository) {
//        this.repository = repository;
//        this.view = view;
//
//        this.view.setPresenter(this);
//    }
//
//    @Override
//    public void getData() {
//        repository.getSource(new SourceDataSource.LoadDataCallback() {
//            @Override
//            public void onDataLoaded(SourceResponse sourceResponse) {
//                view.updateView(sourceResponse);
//            }
//
//            @Override
//            public void onError(Throwable e) {
//
//            }
//        });
//    }
//}
