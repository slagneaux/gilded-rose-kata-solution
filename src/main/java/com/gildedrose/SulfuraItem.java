package com.gildedrose;

public class SulfuraItem extends CustomItem {

    public SulfuraItem(Item item) {
        super(item);
    }

    @Override
    public void updateQuality() {
        this.item.quality = 80;
    }
}
