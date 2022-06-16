package com.gildedrose;

public class NormalItem extends AgedBadlyItem {
    public NormalItem(Item item) {
        super(item);
    }

    @Override
    public void updateQuality() {
        item.sellIn = item.sellIn - 1;
        decreaseQuality(1);
        if (isItemAfterPeremption()) {
            decreaseQuality(1);
        }
    }
}
