package tw.hankli.pagingdemo.paging

import android.arch.lifecycle.MutableLiveData
import android.arch.paging.DataSource
import tw.hankli.pagingdemo.models.Item

class ItemDataSourceFactory : DataSource.Factory<Int, Item>() {

    val sourceLiveData = MutableLiveData<MyItemKeyedDataSource>()

    override fun create(): DataSource<Int, Item> {
        val source = MyItemKeyedDataSource()
        sourceLiveData.postValue(source)
        return source
    }
}