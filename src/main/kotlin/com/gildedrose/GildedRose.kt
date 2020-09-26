package com.gildedrose

import com.gildedrose.items.Item
import com.gildedrose.items.ItemFactory

class GildedRose(var items: Array<Item>) {

    fun updateQuality() {
        for (i in items.indices) {
            val item = ItemFactory.create(items[i])
            item.update()
        }
    }
}
