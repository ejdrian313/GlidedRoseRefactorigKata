package com.gildedrose.items

class Sulfuras(private val item: Item) : Updatable {
    private val _quality = Quality(item.quality)

    override fun update() {
        increaseQuality()
    }

    private fun increaseQuality() {
        item.quality = _quality.increase()
    }
}