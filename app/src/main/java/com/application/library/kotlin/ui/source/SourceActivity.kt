package com.application.library.kotlin.ui.source

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.RecyclerView
import android.widget.Toolbar
import com.application.library.kotlin.Injector

import com.application.library.kotlin.R
import com.application.library.kotlin.data.api.model.SourceResponse
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

    private val adapter = SourceAdapter()

    private lateinit var presenter : SourceContract.Presenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_source)

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


//private SourceAdapter adapter;
//private SourceContract.Presenter presenter;
//
//@Override
//protected void onCreate(Bundle savedInstanceState) {
//    super.onCreate(savedInstanceState);
//    setContentView(R.layout.activity_source);
//
//    ButterKnife.bind(this);
//
//    Injector.obtain(this).inject(this);
//
//    new SourcePresenter(this, repository);
//
//    setupRecyclerView();
//}
//
//@Override
//public void onResume() {
//    super.onResume();
//    presenter.getData();
//}
//
//private void setupRecyclerView() {
//    adapter = new SourceAdapter();
//
//    adapter.setItemClickListener(new BaseViewAdapter.ItemClickListener() {
//        @Override
//        public void onItemClickListener(Object item) {
//            if (item instanceof SourceResponse.Sources) {
//                SourceResponse.Sources sources = (SourceResponse.Sources) item;
//
//                Intent intent = new Intent(getApplicationContext(), NewsActivity.class);
//                intent.putExtra("source", sources.name);
//                startActivity(intent);
//            }
//        }
//    });
//
//    list.setLayoutManager(new GridLayoutManager(this, 2));
//    list.setAdapter(adapter);
//}
//
//@Override
//public void setPresenter(SourceContract.Presenter presenter) {
//    this.presenter = presenter;
//}
//
//@Override
//public void updateView(SourceResponse list) {
//    adapter.clearData();
//    adapter.setItems(list.sources);
//}
//}
