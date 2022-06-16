package com.gildedrose;

public abstract class AgedBadlyItem extends CustomItem{

    public AgedBadlyItem(Item item) {
        super(item);
    }

    protected void decreaseQuality(int decrease) {
        if (item.quality > GildedRose.MIN_QUALITY + decrease - 1) {
            item.quality = item.quality - decrease;
        } else {
            item.quality = GildedRose.MIN_QUALITY;
        }
    }
}
