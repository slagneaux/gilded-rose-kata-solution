package com.gildedrose;

public class BackstageItem extends AgedFineItem {
    public BackstageItem(Item item) {
        super(item);
    }

    @Override
    public void updateQuality() {
        item.sellIn = item.sellIn - 1;
        if (isItemAfterPeremption()) {
            item.quality = 0;
            return;
        }
        increaseQuality();
        if (item.sellIn <= 11) {
            increaseQuality();
            if (item.sellIn <= 6) {
                increaseQuality();
            }
        }
    }

}
