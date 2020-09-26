package com.gildedrose.items

class DefaultItem(private val item: Item) : Updatable {
    private val _quality = Quality(item.quality)

    override fun update() {
        decreaseQuality()
        decreaseSellIn()
        if (sellInLessThanZero())
            decreaseQuality()
    }

    private fun decreaseQuality() {
        item.quality = _quality.decrease()
    }

    private fun decreaseSellIn() {
        --item.sellIn
    }

    private fun sellInLessThanZero() = item.sellIn < 0
}