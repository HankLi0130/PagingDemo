package tw.hankli.pagingdemo

import android.arch.lifecycle.ViewModel
import tw.hankli.pagingdemo.data.ItemData
import tw.hankli.pagingdemo.models.Item

class MainViewModel : ViewModel() {

    override fun onCleared() {
        super.onCleared()
    }

    fun getItems(): List<Item> {
        return ItemData.getItems()
    }
}