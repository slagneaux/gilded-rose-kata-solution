package com.gildedrose;

public abstract class AgedFineItem extends CustomItem{

    public AgedFineItem(Item item) {
        super(item);
    }

    protected void increaseQuality() {
        if (item.quality < GildedRose.MAX_QUALITY) {
            item.quality++;
        }
    }
}
