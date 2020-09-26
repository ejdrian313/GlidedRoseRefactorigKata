package com.gildedrose.items

class AgedBrie(private val item: Item) : Updatable {
    private val _quality = Quality(item.quality)

    override fun update() {
        increaseQuality()
        decreaseSellIn()
        if (sellInLessThanZero())
            increaseQuality()
    }

    private fun increaseQuality() {
        item.quality = _quality.increase()
    }

    private fun decreaseSellIn() {
        --item.sellIn
    }

    private fun sellInLessThanZero() = item.sellIn < 0

}