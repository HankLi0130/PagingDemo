package tw.hankli.pagingdemo.paging

import android.arch.paging.PositionalDataSource
import android.util.Log
import tw.hankli.pagingdemo.data.ItemData
import tw.hankli.pagingdemo.models.Item

/**
 * 使用時機：
 * 根據RecyclerView的絕對位置決定放資料
 */

class MyPositionalDataSource : PositionalDataSource<Item>() {

    private val tag = this::class.java.simpleName

    override fun loadInitial(params: LoadInitialParams, callback: LoadInitialCallback<Item>) {

        val pageSize = params.pageSize
        val loadSize = params.requestedLoadSize
        val startPosition = params.requestedStartPosition

        Log.i(tag, "loadInitial -> pageSize: $pageSize, loadSize: $loadSize, startPosition: $startPosition")

        val items = ItemData.getIncreaseItems(startPosition, pageSize)

        callback.onResult(items, 0)
    }

    override fun loadRange(params: LoadRangeParams, callback: LoadRangeCallback<Item>) {

        val loadSize = params.loadSize
        val startPosition = params.startPosition

        Log.i(tag, "loadRange -> loadSize: $loadSize, startPosition: $startPosition")

        val items = ItemData.getIncreaseItems(startPosition, loadSize)

        callback.onResult(items)
    }
}