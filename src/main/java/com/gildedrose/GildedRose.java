package com.gildedrose;

class GildedRose {
    public static final String AGED_BRIE = "Aged Brie";
    public static final String BACKSTAGE_CONCERT = "Backstage passes to a TAFKAL80ETC concert";
    public static final String SULFURAS = "Sulfuras, Hand of Ragnaros";
    public static final String CONJURED = "Conjured Mana Cake";
    public static final int MAX_QUALITY = 50;
    public static final int MIN_QUALITY = 0;
    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        for (Item item : items) {
            if (item.name.equals(SULFURAS)) {
                item.quality = 80;
                continue;
            }

            item.sellIn--;

            if (item.name.equals(AGED_BRIE)) {
                updateQualiteAgedBried(item);
                continue;
            }

            if (item.name.equals(BACKSTAGE_CONCERT)) {
                updateQualityBackstageConcert(item);
                continue;
            }

            if (item.name.equals(CONJURED)) {
                updateQualityConjuredItem(item);
                continue;
            }
            if (item.quality > MIN_QUALITY) {
                updateQualityNormalItem(item);
            }
        }
    }

    private void updateQualiteAgedBried(Item item) {
        if (item.quality < MAX_QUALITY) {
            item.quality = item.quality + 1;
            if (item.sellIn < 0 && item.quality < MAX_QUALITY) {
                item.quality = item.quality + 1;
            }
        }
    }

    private void updateQualityConjuredItem(Item item) {
        if (item.quality > MIN_QUALITY + 1) {
            item.quality = item.quality - 2;
            if (isItemAfterPeremption(item)) {
                if (item.quality > MIN_QUALITY + 1) {
                    item.quality = item.quality - 2;
                } else {
                    item.quality = 0;
                }
            }
        } else {
            item.quality = 0;
        }
    }

    private void updateQualityNormalItem(Item item) {
        if (item.quality > MIN_QUALITY) {
            item.quality = item.quality - 1;
            if (this.isItemAfterPeremption(item) && item.quality > MIN_QUALITY) {
                item.quality = item.quality - 1;
            }
        }
    }

    private void updateQualityBackstageConcert(Item item) {
        if (this.isItemAfterPeremption(item)) {
            item.quality = MIN_QUALITY;
            return;
        }
        if (item.quality >= MAX_QUALITY) {
            return;
        }
        item.quality = item.quality + 1;
        if (item.sellIn > 11 || item.quality >= MAX_QUALITY) {
            return;
        }
        item.quality = item.quality + 1;
        if (item.sellIn > 6 || item.quality >= MAX_QUALITY) {
            return;
        }
        item.quality = item.quality + 1;
    }

    private boolean isItemAfterPeremption(Item item) {
        return item.sellIn < 0;
    }
}
