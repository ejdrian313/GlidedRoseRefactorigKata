package com.gildedrose

class GildedRose(var items: Array<Item>) {

    fun updateQuality() {
        for (i in items.indices) {
            val item = items[i]

            if (item.name == "Aged Brie" || item.name == "Backstage passes to a TAFKAL80ETC concert" || item.name == "Sulfuras, Hand of Ragnaros") {
                if (item.quality < 50) {
                    item.quality = item.quality + 1

                    if (item.name == "Backstage passes to a TAFKAL80ETC concert") {//Backstage pass
                        if (item.sellIn < 11 && item.quality < 50) {
                            item.quality = item.quality + 1
                        }
                        if (item.sellIn < 6 && item.quality < 50) {
                            item.quality = item.quality + 1
                        }
                    }
                }
            } else {
                if (item.quality > 0) {
                    item.quality = item.quality - 1
                }
            }

            if (item.name != "Sulfuras, Hand of Ragnaros") {
                item.sellIn = item.sellIn - 1
            }

            if (item.sellIn < 0) {
                if (item.name == "Aged Brie") {
                    if (item.quality < 50) {
                        item.quality = item.quality + 1
                    }
                } else {
                    if (item.name == "Backstage passes to a TAFKAL80ETC concert") {
                        item.quality = item.quality - item.quality
                    } else {
                        if (item.name == "Sulfuras, Hand of Ragnaros") {
                            //nothing
                        } else if (item.quality > 0) {
                            item.quality = item.quality - 1
                        }
                    }
                }
            }
        }
    }
}

