package tw.hankli.pagingdemo.paging

import android.arch.paging.DataSource
import android.util.Log
import tw.hankli.pagingdemo.models.Item

class ItemDataSourceFactory : DataSource.Factory<Int, Item>() {

    private val tag = this::class.java.simpleName

    override fun create(): DataSource<Int, Item> {

        Log.i(tag, "create data source factory")

        return MyItemKeyedDataSource()
    }
}