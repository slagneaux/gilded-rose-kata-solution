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
}
