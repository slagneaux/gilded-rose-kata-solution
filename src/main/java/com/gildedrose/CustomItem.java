package com.gildedrose;

public abstract class CustomItem {

    protected Item item;

    public CustomItem(Item item) {
        this.item = item;
    }

    public abstract void updateQuality();

    protected boolean isItemAfterPeremption() {
        return item.sellIn < 0;
    }

    protected void increaseQuality() {
        if (item.quality < GildedRose.MAX_QUALITY) {
            item.quality++;
        }
    }

    protected void decreaseQuality(int decrease) {
        if (item.quality > GildedRose.MIN_QUALITY + decrease - 1) {
            item.quality = item.quality - decrease;
        } else {
            item.quality = GildedRose.MIN_QUALITY;
        }
    }
}
