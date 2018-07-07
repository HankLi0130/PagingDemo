package tw.hankli.pagingdemo.paging

import android.arch.paging.PageKeyedDataSource
import tw.hankli.pagingdemo.models.Item

class MyPageKeyedDataSource : PageKeyedDataSource<Int, Item>() {

    override fun loadInitial(params: LoadInitialParams<Int>, callback: LoadInitialCallback<Int, Item>) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun loadAfter(params: LoadParams<Int>, callback: LoadCallback<Int, Item>) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun loadBefore(params: LoadParams<Int>, callback: LoadCallback<Int, Item>) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}