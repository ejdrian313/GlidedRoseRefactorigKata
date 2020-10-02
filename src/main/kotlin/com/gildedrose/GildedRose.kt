package com.gildedrose

import com.gildedrose.items.Item
import com.gildedrose.items.ItemFactory

class GildedRose(var items: Array<Item>) {

    fun updateQuality() {
        for (it in items) {
            val item = ItemFactory.create(it)
            item.update()
        }
    }
}
