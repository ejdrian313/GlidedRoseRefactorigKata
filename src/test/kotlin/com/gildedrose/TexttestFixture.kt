package com.gildedrose

import com.gildedrose.items.Item
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

internal class TexttestFixture  {
    @Test
    fun textResult() {
        var reportedLines = "OMGHAI!\n"
        println("OMGHAI!")

        val items = arrayOf(Item("+5 Dexterity Vest", 10, 20), //
                Item("Aged Brie", 2, 0), //
                Item("Elixir of the Mongoose", 5, 7), //
                Item("Sulfuras, Hand of Ragnaros", 0, 80), //
                Item("Sulfuras, Hand of Ragnaros", -1, 80),
                Item("Backstage passes to a TAFKAL80ETC concert", 15, 20),
                Item("Backstage passes to a TAFKAL80ETC concert", 10, 49),
                Item("Backstage passes to a TAFKAL80ETC concert", 5, 49),
                // this conjured item does not work properly yet
                Item("Conjured Mana Cake", 3, 6))

        val app = GildedRose(items)

        val days = 2

        for (i in 0 until days) {
            println("-------- day $i --------")
            println("name, sellIn, quality")
            reportedLines +="-------- day $i --------\n"
            reportedLines +="name, sellIn, quality\n"
            for (item in items) {
                println(item)
                reportedLines +="$item\n"
            }
            reportedLines +="\n"
            println()
            app.updateQuality()
        }
        assertEquals("OMGHAI!\n" +
                "-------- day 0 --------\n" +
                "name, sellIn, quality\n" +
                "+5 Dexterity Vest, 10, 20\n" +
                "Aged Brie, 2, 0\n" +
                "Elixir of the Mongoose, 5, 7\n" +
                "Sulfuras, Hand of Ragnaros, 0, 80\n" +
                "Sulfuras, Hand of Ragnaros, -1, 80\n" +
                "Backstage passes to a TAFKAL80ETC concert, 15, 20\n" +
                "Backstage passes to a TAFKAL80ETC concert, 10, 49\n" +
                "Backstage passes to a TAFKAL80ETC concert, 5, 49\n" +
                "Conjured Mana Cake, 3, 6\n" +
                "\n" +
                "-------- day 1 --------\n" +
                "name, sellIn, quality\n" +
                "+5 Dexterity Vest, 9, 19\n" +
                "Aged Brie, 1, 1\n" +
                "Elixir of the Mongoose, 4, 6\n" +
                "Sulfuras, Hand of Ragnaros, 0, 80\n" +
                "Sulfuras, Hand of Ragnaros, -1, 80\n" +
                "Backstage passes to a TAFKAL80ETC concert, 14, 21\n" +
                "Backstage passes to a TAFKAL80ETC concert, 9, 50\n" +
                "Backstage passes to a TAFKAL80ETC concert, 4, 50\n" +
                "Conjured Mana Cake, 2, 5\n" +
                "\n", reportedLines)
    }
}

