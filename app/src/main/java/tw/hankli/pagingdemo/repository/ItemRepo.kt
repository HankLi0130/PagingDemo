package tw.hankli.pagingdemo.repository

import android.arch.lifecycle.LiveData
import android.arch.paging.LivePagedListBuilder
import android.arch.paging.PagedList
import tw.hankli.pagingdemo.models.Item
import tw.hankli.pagingdemo.paging.ItemDataSourceFactory

class ItemRepo {

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

    // 每頁的資料量
    private val pageSize = 10

    // 第一筆資料的 Key
    private val initialLoadKey = 0

    private val factory = ItemDataSourceFactory(ItemDataSourceFactory.PAGE_KEYED)

    private val config = PagedList.Config.Builder()
            .setPageSize(pageSize)
            .setInitialLoadSizeHint(pageSize * 2)
            .setEnablePlaceholders(false)
            .build()

    fun getItems(): LiveData<PagedList<Item>> {
        return LivePagedListBuilder<Int, Item>(factory, config)
                .setInitialLoadKey(initialLoadKey)
                .build()
    }
}