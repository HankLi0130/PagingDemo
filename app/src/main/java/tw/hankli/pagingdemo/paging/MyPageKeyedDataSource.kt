package tw.hankli.pagingdemo.paging

import android.arch.paging.PageKeyedDataSource
import android.util.Log
import tw.hankli.pagingdemo.data.ItemData
import tw.hankli.pagingdemo.models.Item

/**
 * 使用時機：
 * 原始資料來源（遠端 Server 或其他資料來源）已有分頁功能
 * 根據每頁的 Key 取得 RecyclerView 的 Item 資料
 */

class MyPageKeyedDataSource : PageKeyedDataSource<Int, Item>() {

    private val tag = this::class.java.simpleName

    override fun loadInitial(params: LoadInitialParams<Int>, callback: LoadInitialCallback<Int, Item>) {

        // params中沒有預設的Key

        val size = params.requestedLoadSize

        Log.i(tag, "loadInitial -> size: $size")

        val items = ItemData.getItems(size)

        // 指定 上一頁 和 下一頁 的Key
        callback.onResult(items, items[0].id, items.last().id)
    }

    override fun loadAfter(params: LoadParams<Int>, callback: LoadCallback<Int, Item>) {

        val key = params.key
        val size = params.requestedLoadSize

        Log.i(tag, "loadAfter -> key: $key, size: $size")

        val items = ItemData.getIncreaseItems(key, size)

        // 指定 下一頁 的Key
        callback.onResult(items, items.last().id)
    }

    override fun loadBefore(params: LoadParams<Int>, callback: LoadCallback<Int, Item>) {

        val key = params.key
        val size = params.requestedLoadSize

        Log.i(tag, "loadAfter -> key: $key, size: $size")

        val items = ItemData.getReduceItems(key, size)

        // 指定 上一頁 的Key
        callback.onResult(items, items.first().id)
    }
}