class GildedRose {
    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        for (Item item : items)
        {
            switch (item.name)
            {
                case "Aged Brie":
                    item.increase_quality_if_needed();

                    item.sellIn--;
                    if (item.sellIn < 0)
                    {
                        item.increase_quality_if_needed();
                    }
                    break;

                case "Backstage passes to a TAFKAL80ETC concert":
                    item.increase_quality_if_needed();
                    if (item.sellIn < 11)
                    {
                        item.increase_quality_if_needed();
                    }
                    if (item.sellIn < 6)
                    {
                        item.increase_quality_if_needed();
                    }

                    item.sellIn--;
                    if (item.sellIn < 0)
                    {
                        item.quality = 0;
                    }
                    break;

                case "Sulfuras, Hand of Ragnaros":
                    break;

                default:
                    item.update_quality();
                    break;

            }
        }
    }

}