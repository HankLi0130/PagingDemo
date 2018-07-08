package tw.hankli.pagingdemo.data

import tw.hankli.pagingdemo.models.Item

/**
 * 假設為 API
 */

object ItemData {

    fun getItems(size: Int): List<Item> {
        return Array(size) {
            Item(it, "Item $it")
        }.toList()
    }

    // 累加
    fun getIncreaseItems(start: Int, size: Int): List<Item> {
        return Array(size) {
            val index = start + it
            Item(index, "Item $index")
        }.toList()
    }

    // 累減，陣列的第一個元素是最小的數
    fun getReduceItems(start: Int, size: Int): List<Item> {
        return Array(size) {
            val index = (start - size) + it
            Item(index, "Item $index")
        }.toList()
    }
}