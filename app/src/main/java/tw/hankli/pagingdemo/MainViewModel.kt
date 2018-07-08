package tw.hankli.pagingdemo

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.ViewModel
import android.arch.paging.LivePagedListBuilder
import android.arch.paging.PagedList
import tw.hankli.pagingdemo.models.Item
import tw.hankli.pagingdemo.paging.ItemDataSourceFactory

class MainViewModel : ViewModel() {

    val itemLiveData: LiveData<PagedList<Item>>

    companion object {
        const val PAGE_SIZE = 10
        const val INITIAL_LOAD_KEY = 5
    }

    init {
        val factory = ItemDataSourceFactory()
        val config = PagedList.Config.Builder()
                .setPageSize(PAGE_SIZE)
                .setInitialLoadSizeHint(PAGE_SIZE * 2)
                .setEnablePlaceholders(false)
                .build()

        itemLiveData = LivePagedListBuilder<Int, Item>(factory, config)
                //.setInitialLoadKey(INITIAL_LOAD_KEY)
                .build()
    }

    override fun onCleared() {
        super.onCleared()
    }
}