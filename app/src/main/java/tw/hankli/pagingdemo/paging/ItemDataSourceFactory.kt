package tw.hankli.pagingdemo.paging

import android.arch.paging.DataSource
import android.util.Log
import tw.hankli.pagingdemo.models.Item

class ItemDataSourceFactory : DataSource.Factory<Int, Item>() {

    private val tag = this::class.java.simpleName

    companion object {

        const val ITEM_KEYED = 0
        const val PAGE_KEYED = 1
        const val POSITIONAL = 2

        fun getDataSource(which: Int): DataSource<Int, Item> {

            return when (which) {
                ITEM_KEYED -> MyItemKeyedDataSource()
                PAGE_KEYED -> MyPageKeyedDataSource()
                POSITIONAL -> MyPositionalDataSource()
                else -> throw IllegalArgumentException("unknown data source")
            }
        }
    }

    override fun create(): DataSource<Int, Item> {

        Log.i(tag, "create data source factory")

        return getDataSource(POSITIONAL)
    }
}