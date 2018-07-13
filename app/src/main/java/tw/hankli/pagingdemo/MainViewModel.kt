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
        const val INITIAL_LOAD_KEY = 0
    }

    /*
     * Config的設定建議
     *
     * ItemKeyedDataSource  -> 1. requestedInitialKey
     *                         2. requestedLoadSize
     *                         3. placeholderEnabled
     *
     * PageKeyedDataSource  -> 1. requestedLoadSize
     *                         2. placeholderEnabled
     *
     * PositionalDataSource -> 1. requestedStarPosition
     *                         2. pageSize
     *                         3. requestedLoadSize
     *                         4. placeholdersEnabled
     */

    init {
        val factory = ItemDataSourceFactory(ItemDataSourceFactory.PAGE_KEYED)
        val config = PagedList.Config.Builder()
                .setPageSize(PAGE_SIZE)
                .setInitialLoadSizeHint(PAGE_SIZE * 2)
                .setEnablePlaceholders(false)
                .build()

        itemLiveData = LivePagedListBuilder<Int, Item>(factory, config)
                .setInitialLoadKey(INITIAL_LOAD_KEY)
                .build()
    }
}