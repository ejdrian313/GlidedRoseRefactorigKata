package com.gildedrose.items

class BackstagePass(private val item: Item) : Updatable {
    private val _quality = Quality(item.quality)

    override fun update() {
        increaseQuality()
        increaseQualitySpecial()
        decreaseSellIn()
        if (sellInLessThanZero())
            decreaseQuality()
    }

    private fun increaseQuality() {
        item.quality = _quality.increase()
    }

    private fun decreaseQuality() {
        item.quality = 0
    }

    private fun decreaseSellIn() {
        --item.sellIn
    }

    private fun sellInLessThanZero() = item.sellIn < 0

    private fun increaseQualitySpecial() {
        if (item.sellIn < 11) {
            increaseQuality()
        }
        if (item.sellIn < 6) {
            increaseQuality()
        }
    }
}