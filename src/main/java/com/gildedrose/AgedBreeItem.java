package com.gildedrose;

public class AgedBreeItem extends CustomItem{

    public AgedBreeItem(Item item) {
        super(item);
    }

    @Override
    public void updateQuality() {
        item.sellIn = item.sellIn - 1;
        increaseQuality();
        if(isItemAfterPeremption()){
            increaseQuality();
        }
    }
}
