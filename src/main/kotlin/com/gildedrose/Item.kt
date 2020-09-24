package com.gildedrose

open class Item(var name: String, var sellIn: Int, var quality: Int) {
    override fun toString(): String {
        return this.name + ", " + this.sellIn + ", " + this.quality
    }
}

class ItemFactory {
    companion object {
        fun createItem(item: Item): Manageable {
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
    fun increaseQuality()
    fun decreaseQuality()
    fun decreaseSellIn()
    fun sellInLessThanZero(): Boolean
}

class AgedBrie(private val item: Item) : Manageable {
    private val _quality = Quality(item.quality)

    override fun increaseQuality() {
        item.quality = _quality.increase()
    }

    override fun decreaseQuality() {
        item.quality = _quality.decrease()
    }

    override fun decreaseSellIn() {
        --item.sellIn
    }

    override fun sellInLessThanZero() = item.sellIn < 0

    override fun toString(): String {
        return item.toString()
    }
}

class BackstagePass(private val item: Item) : Manageable {
    private val _quality = Quality(item.quality)

    override fun increaseQuality() {
        item.quality = _quality.increase()
    }

    override fun decreaseQuality() {
        item.quality = 0
    }

    override fun decreaseSellIn() {
        --item.sellIn
    }

    override fun sellInLessThanZero() = item.sellIn < 0

    override fun toString(): String {
        return item.toString()
    }

    fun increaseQualitySpecial() {
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


    override fun increaseQuality() {
        item.quality = _quality.increase()
    }

    override fun decreaseQuality() {
        item.quality = _quality.decrease()
    }

    override fun decreaseSellIn() {
        --item.sellIn
    }

    override fun sellInLessThanZero() = item.sellIn < 0

    override fun toString(): String {
        return item.toString()
    }
}

class DefaultItem(private val item: Item) : Manageable {
    private val _quality = Quality(item.quality)


    override fun increaseQuality() {
        item.quality = _quality.increase()
    }

    override fun decreaseQuality() {
        item.quality = _quality.decrease()
    }

    override fun decreaseSellIn() {
        --item.sellIn
    }

    override fun sellInLessThanZero() = item.sellIn < 0

    override fun toString(): String {
        return item.toString()
    }
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