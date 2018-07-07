package tw.hankli.pagingdemo.data

import tw.hankli.pagingdemo.models.Item

/**
 * 假設為 API
 */

object ItemData {

    fun getItems(start: Int, size: Int): List<Item> {
        return Array(size) {
            val index = start + it
            Item(index, "Item $index")
        }.toList()
    }
}