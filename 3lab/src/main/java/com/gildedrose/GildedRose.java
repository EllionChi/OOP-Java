class GildedRose {
    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        for (Item item : items)
        {
            if (item.name.equals("Aged Brie"))
            {
                if (item.quality < 50)
                {
                    item.quality++;
                }
            }

            else if (item.name.equals("Backstage passes to a TAFKAL80ETC concert"))
            {
                if (item.quality < 50)
                {
                    item.quality++;

                    if (item.sellIn < 11)
                    {
                        item.increase_quality_if_needed();
                    }

                    if (item.sellIn < 6)
                    {
                        item.increase_quality_if_needed();
                    }

                }
            }
            else
            {
                item.decrease_quality_if_needed();
            }

            if (!item.name.equals("Sulfuras, Hand of Ragnaros"))
            {
                item.sellIn--;
            }

            if (item.sellIn < 0)
            {
                if (item.name.equals("Aged Brie"))
                {
                    item.increase_quality_if_needed();
                }
                else if (item.name.equals("Backstage passes to a TAFKAL80ETC concert"))
                {
                    item.quality = 0;
                }
                else
                {
                    item.decrease_quality_if_needed();
                }

            }
        }
    }

}