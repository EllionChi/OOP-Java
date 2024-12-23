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
                item.increase_quality_if_needed();
            }

            else if (item.name.equals("Backstage passes to a TAFKAL80ETC concert"))
            {
                item.increase_quality_if_needed();

                if (item.sellIn < 11)
                {
                    item.increase_quality_if_needed();
                }

                if (item.sellIn < 6)
                {
                    item.increase_quality_if_needed();
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


            if (item.name.equals("Aged Brie") && (item.sellIn < 0))
            {
                item.increase_quality_if_needed();
            }
            else if (item.name.equals("Backstage passes to a TAFKAL80ETC concert") && (item.sellIn < 0))
            {
                item.quality = 0;
            }
            else if (item.sellIn < 0)
            {
                item.decrease_quality_if_needed();
            }


        }
    }

}