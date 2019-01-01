package tw.hankli.pagingdemo

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.ViewModel
import android.arch.paging.PagedList
import tw.hankli.pagingdemo.models.Item
import tw.hankli.pagingdemo.repository.ItemRepo

class MainViewModel : ViewModel() {

    private val itemRepo = ItemRepo()

    fun getItems(): LiveData<PagedList<Item>> {
        return itemRepo.getItems()
    }
}