package com.gildedrose;

public class CustomItemFactory {

    public static CustomItem createCustomItem(Item item) {
        switch (item.name) {
            case GildedRose.SULFURAS:
                return new SulfuraItem(item);
            case GildedRose.CONJURED:
                return new ConjuredItem(item);
            case GildedRose.BACKSTAGE_CONCERT:
                return new BackstageItem(item);
            case GildedRose.AGED_BRIE:
                return new AgedBreeItem(item);
            default:
                return new NormalItem(item);
        }
    }

}
