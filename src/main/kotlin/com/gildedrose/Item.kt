package com.gildedrose

open class Item(var name: String, var sellIn: Int, var quality: Int) {
    override fun toString(): String {
        return this.name + ", " + this.sellIn + ", " + this.quality
    }
}

class ItemFactory {
    companion object {
        fun create(item: Item): Manageable {
            return when (item.name) {
                "Aged Brie" -> AgedBrie(item)
                "Backstage passes to a TAFKAL80ETC concert" -> BackstagePass(item)
                "Sulfuras, Hand of Ragnaros" -> Sulfuras(item)
                else -> DefaultItem(item)
            }
        }
    }
}

interface Manageable {
    fun update()
}

class AgedBrie(private val item: Item) : Manageable {
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

class BackstagePass(private val item: Item) : Manageable {
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

class Sulfuras(private val item: Item) : Manageable {
    private val _quality = Quality(item.quality)

    override fun update() {
        increaseQuality()
    }

    private fun increaseQuality() {
        item.quality = _quality.increase()
    }
}

class DefaultItem(private val item: Item) : Manageable {
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

class Quality(private var value: Int) {

    fun increase(): Int {
        return if (value < 50) {
            ++value
        } else value
    }

    fun decrease(): Int {
        return if (value > 0) {
            --value
        } else value
    }
}