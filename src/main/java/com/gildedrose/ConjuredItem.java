package com.gildedrose;

public class ConjuredItem extends CustomItem {

    public ConjuredItem(Item item) {
        super(item);
    }

    @Override
    public void updateQuality() {
        item.sellIn = item.sellIn - 1;
        decreaseQuality(2);
        if (isItemAfterPeremption()) {
            decreaseQuality(2);
        }
    }
}
