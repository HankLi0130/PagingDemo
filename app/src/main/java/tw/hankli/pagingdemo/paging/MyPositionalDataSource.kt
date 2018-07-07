package tw.hankli.pagingdemo.paging

import android.arch.paging.PositionalDataSource
import tw.hankli.pagingdemo.models.Item

class MyPositionalDataSource : PositionalDataSource<Item>() {

    override fun loadRange(params: LoadRangeParams, callback: LoadRangeCallback<Item>) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun loadInitial(params: LoadInitialParams, callback: LoadInitialCallback<Item>) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}