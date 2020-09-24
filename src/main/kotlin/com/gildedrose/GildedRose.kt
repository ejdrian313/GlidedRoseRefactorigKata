package com.gildedrose

class GildedRose(var items: Array<Item>) {

    fun updateQuality() {
        for (i in items.indices) {
            val item = ItemFactory.createItem(items[i])

            if (item is AgedBrie || item is BackstagePass || item is Sulfuras) {
                item.increaseQuality()
                if (item is BackstagePass) {
                    item.increaseQualitySpecial()
                }
            } else {
                item.decreaseQuality()
            }

            if (item !is Sulfuras) {
                item.decreaseSellIn()
            }

            if (item.sellInLessThanZero()) {
                when (item) {
                    is AgedBrie -> {
                        item.increaseQuality()
                    }
                    is BackstagePass -> {
                        item.decreaseQuality()
                    }
                    is Sulfuras -> {
                        //nothing
                    }
                    else -> {
                        item.decreaseQuality()
                    }
                }
            }
        }
    }
}
