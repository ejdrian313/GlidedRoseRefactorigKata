package com.gildedrose

class GildedRose(var items: Array<Item>) {

    fun updateQuality() {
        for (i in items.indices) {
            val item = ItemFactory.create(items[i])
            item.update()
        }
    }
}
