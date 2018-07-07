package tw.hankli.pagingdemo.paging

import android.arch.paging.ItemKeyedDataSource
import tw.hankli.pagingdemo.data.ItemData
import tw.hankli.pagingdemo.models.Item

class MyItemKeyedDataSource : ItemKeyedDataSource<Int, Item>() {

    override fun loadInitial(params: LoadInitialParams<Int>, callback: LoadInitialCallback<Item>) {
        val initKey = params.requestedInitialKey ?: 0
        val size = params.requestedLoadSize
        callback.onResult(ItemData.getItems(initKey, size))
    }

    override fun loadAfter(params: LoadParams<Int>, callback: LoadCallback<Item>) {
        val initKey = params.key
        val size = params.requestedLoadSize
        callback.onResult(ItemData.getItems(initKey, size))
    }

    override fun loadBefore(params: LoadParams<Int>, callback: LoadCallback<Item>) {

    }

    override fun getKey(item: Item): Int = item.id
}