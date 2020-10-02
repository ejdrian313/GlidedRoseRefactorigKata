package com.gildedrose

import com.gildedrose.items.Item
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

internal class GildedRoseTest {

    @Test
    fun testBackStageQuality() {
        val app = GildedRose(arrayOf(Item("Backstage passes to a TAFKAL80ETC concert", -5, 40)))
        app.updateQuality()
        assertEquals(0, app.items[0].quality)
    }

    @Test
    fun testAgedBrieQualityWhenSellInLessThanZero() {
        val app = GildedRose(arrayOf(Item("Aged Brie", -5, 40)))
        app.updateQuality()
        assertEquals(42, app.items[0].quality)
    }

    @Test
    fun testElseItemQuality() {
        val app = GildedRose(arrayOf(Item("Foo bar", -5, 40)))
        app.updateQuality()
        assertEquals(38, app.items[0].quality)
    }

    @Test
    fun testElseItemQualityZero() {
        val app = GildedRose(arrayOf(Item("Foo bar", -5, 0)))
        app.updateQuality()
        assertEquals(0, app.items[0].quality)
    }

    @Test
    fun testSulfurasQuality() {
        val app = GildedRose(arrayOf(Item("Sulfuras, Hand of Ragnaros", -5, 40)))
        app.updateQuality()
        assertEquals(41, app.items[0].quality)
    }

    @Test
    fun conjuredQuality() {
        val app = GildedRose(arrayOf(Item("Conjured", 30, 30)))
        app.updateQuality()
        assertEquals(28, app.items[0].quality)
    }

    @Test
    fun conjuredQualitySellIn() {
        val app = GildedRose(arrayOf(Item("Conjured", -3, 30)))
        app.updateQuality()
        assertEquals(26, app.items[0].quality)
    }
}
