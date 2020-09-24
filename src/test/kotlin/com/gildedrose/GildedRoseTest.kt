package com.gildedrose

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

internal class GildedRoseTest {

    @Test
    fun nameIsUnchanged() {
        val items = arrayOf(Item("foo", 0, 0))
        val app = GildedRose(items)
        app.updateQuality()
        assertEquals("foo", app.items[0].name)
    }

    @Test
    fun backStagePassesToaTAFKAL80ETConcertQuality40SellInMinus5UpdateWell() {
        val items = arrayOf(Item("Backstage passes to a TAFKAL80ETC concert", -5, 40))
        val app = GildedRose(items)
        app.updateQuality()
        assertEquals(0, app.items[0].quality)
        assertEquals(-6, app.items[0].sellIn)
    }

    @Test
    fun agedBrieSellInMinus5quality40updateWell() {
        val items = arrayOf(Item("Aged Brie", -5, 40))
        val app = GildedRose(items)
        app.updateQuality()
        assertEquals(42, app.items[0].quality)
        assertEquals(-6, app.items[0].sellIn)
    }

    @Test
    fun elseItemSellInMinus5quality40updateWell() {
        val items = arrayOf(Item("Test2", -5, 40))
        val app = GildedRose(items)
        app.updateQuality()
        assertEquals(38, app.items[0].quality)
        assertEquals(-6, app.items[0].sellIn)
    }
}
