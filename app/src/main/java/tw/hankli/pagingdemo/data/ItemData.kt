package tw.hankli.pagingdemo.data

import tw.hankli.pagingdemo.models.Item

/**
 * 假設為 API
 */

object ItemData {

    fun getItems(): List<Item> {
        return Array(100) { Item(it, "Item $it") }.toList()
    }

}