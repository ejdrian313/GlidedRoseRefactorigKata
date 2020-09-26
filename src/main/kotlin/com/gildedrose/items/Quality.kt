package com.gildedrose.items

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