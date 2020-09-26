package com.gildedrose.items

object ItemFactory {
    fun create(item: Item): Updatable {
        return when (item.name) {
            "Aged Brie" -> AgedBrie(item)
            "Backstage passes to a TAFKAL80ETC concert" -> BackstagePass(item)
            "Sulfuras, Hand of Ragnaros" -> Sulfuras(item)
            else -> DefaultItem(item)
        }
    }
}

interface Updatable {
    fun update()
}