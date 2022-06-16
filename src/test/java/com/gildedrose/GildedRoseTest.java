package com.gildedrose;

import org.junit.jupiter.api.Test;

import static com.gildedrose.GildedRose.*;
import static com.gildedrose.GildedRose.CONJURED;
import static org.junit.jupiter.api.Assertions.assertEquals;

class GildedRoseTest {

    @Test
    void downgradeQualityNormalItem() {
        Item[] items = new Item[] { new Item("foo", 10, 25) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(24, app.items[0].quality);
        assertEquals(9, app.items[0].sellIn);
    }

    @Test
    void downgradeNegativeQualityNormalItem_shouldntDowngrade() {
        Item[] items = new Item[] { new Item("foo", 10, 0) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(0, app.items[0].quality);
        assertEquals(9, app.items[0].sellIn);
    }

    @Test
    void downgradeQualityNormalItemAfterPeremption_shouldDoubleDowngrade() {
        Item[] items = new Item[] { new Item("foo", -1, 25) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(23, app.items[0].quality);
    }


    @Test
    void downgradeQualityConjuredItem_shouldDoubleDowngrade() {
        Item[] items = new Item[] { new Item(CONJURED, 10, 25) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(23, app.items[0].quality);
        assertEquals(9, app.items[0].sellIn);
    }

    @Test
    void downgradeQualityConjuredItem_shouldBe0() {
        Item[] items = new Item[] { new Item(CONJURED, 10, 1) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(0, app.items[0].quality);
        assertEquals(9, app.items[0].sellIn);
    }

    @Test
    void downgradeNegativeQualityConjuredItem_shouldntDowngrade() {
        Item[] items = new Item[] { new Item(CONJURED, 10, 0) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(0, app.items[0].quality);
        assertEquals(9, app.items[0].sellIn);
    }

    @Test
    void downgradeQualityConjuredItemAfterPeremption_shouldFourTimesDowngrade() {
        Item[] items = new Item[] { new Item(CONJURED, -1, 25) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(21, app.items[0].quality);
    }

    @Test
    void updateQualityAgedBrie_shouldIncrease() {
        Item[] items = new Item[] { new Item(AGED_BRIE, 20, 25) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(26, app.items[0].quality);
        assertEquals(19, app.items[0].sellIn);
    }

    @Test
    void updateQualityAgedBrieAfterPeremption_shouldDoubleIncrease() {
        Item[] items = new Item[] { new Item(AGED_BRIE, -2, 25) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(27, app.items[0].quality);
        assertEquals(-3, app.items[0].sellIn);
    }


    @Test
    void updateQualityAgedBrieOver50_shouldNotIncrease() {
        Item[] items = new Item[] { new Item(AGED_BRIE, 20, 50) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(50, app.items[0].quality);
        assertEquals(19, app.items[0].sellIn);
    }

    @Test
    void updateQualitySulfura_shouldntChange() {
        Item[] items = new Item[] { new Item(SULFURAS, 0, 80) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(80, app.items[0].quality);
        assertEquals(0, app.items[0].sellIn);
    }

    @Test
    void updateQualityBackstage_shouldIncrease() {
        Item[] items = new Item[] { new Item(BACKSTAGE_CONCERT, 15, 10) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(11, app.items[0].quality);
        assertEquals(14, app.items[0].sellIn);
    }

    @Test
    void updateQualityBackstageWithLessThan10Days_shouldDoubleIncrease() {
        Item[] items = new Item[] { new Item(BACKSTAGE_CONCERT, 9, 10) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(12, app.items[0].quality);
        assertEquals(8, app.items[0].sellIn);
    }

    @Test
    void updateQualityBackstageWithLessThan5Days_shouldTripleIncrease() {
        Item[] items = new Item[] { new Item(BACKSTAGE_CONCERT, 4, 10) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(13, app.items[0].quality);
        assertEquals(3, app.items[0].sellIn);
    }

    @Test
    void updateQualityBackstageOver50_shouldNotIncrease() {
        Item[] items = new Item[] { new Item(BACKSTAGE_CONCERT, 20, 50) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(50, app.items[0].quality);
        assertEquals(19, app.items[0].sellIn);
    }

    @Test
    void updateQualityBackstageWithLessThan11Days_shouldReachLimit() {
        Item[] items = new Item[] { new Item(BACKSTAGE_CONCERT, 4, 49) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(50, app.items[0].quality);
        assertEquals(3, app.items[0].sellIn);
    }
    @Test
    void updateQualityBackstageWithLessThan5Days_shouldReachLimit() {
        Item[] items = new Item[] { new Item(BACKSTAGE_CONCERT, 4, 48) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(50, app.items[0].quality);
        assertEquals(3, app.items[0].sellIn);
    }

    @Test
    void updateQualityBackstageAfterConcert_qualityShouldBe0() {
        Item[] items = new Item[] { new Item(BACKSTAGE_CONCERT, 0, 10) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(0, app.items[0].quality);
        assertEquals(-1, app.items[0].sellIn);
    }



}
