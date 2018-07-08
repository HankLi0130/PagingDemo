package tw.hankli.pagingdemo.paging

import android.arch.paging.ItemKeyedDataSource
import android.util.Log
import tw.hankli.pagingdemo.data.ItemData
import tw.hankli.pagingdemo.models.Item

class MyItemKeyedDataSource : ItemKeyedDataSource<Int, Item>() {

    private val tag = this::class.java.simpleName

    override fun loadInitial(params: LoadInitialParams<Int>, callback: LoadInitialCallback<Item>) {

        // Key -> 查詢的索引
        // Size -> 要求資料的長度

        val initKey = params.requestedInitialKey ?: 0
        val size = params.requestedLoadSize

        Log.i(tag, "loadInitial -> key: $initKey, size: $size")

        callback.onResult(ItemData.getIncreaseItems(initKey, size))
    }

    override fun loadAfter(params: LoadParams<Int>, callback: LoadCallback<Item>) {

        // Key -> 查詢的索引，這裡給的是上一頁最後一筆資料的Key
        // Size -> 要求資料的長度

        val previousLatestKey = params.key
        val size = params.requestedLoadSize

        Log.i(tag, "loadAfter -> key: $previousLatestKey, size: $size")

        val newKey = previousLatestKey + 1

        callback.onResult(ItemData.getIncreaseItems(newKey, size))
    }

    override fun loadBefore(params: LoadParams<Int>, callback: LoadCallback<Item>) {

        // Key -> 查詢的索引，這裡給的是上一頁第一筆資料的Key
        // Size -> 要求資料的長度

        val previousFirstKey = params.key
        val size = params.requestedLoadSize

        Log.i(tag, "loadBefore -> key: $previousFirstKey, size: $size")

        callback.onResult(ItemData.getReduceItems(previousFirstKey, size))
    }

    override fun getKey(item: Item): Int = item.id
}