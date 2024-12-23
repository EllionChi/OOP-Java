public class BackstagePass extends Item
{
    public BackstagePass(int sellIn, int quality)
    {
        super("Backstage passes to a TAFKAL80ETC concert", sellIn, quality);
    }
    @Override
    public void update_quality()
    {
        increase_quality_if_needed();
        if (sellIn < 11)
        {
            increase_quality_if_needed();
        }
        if (sellIn < 6)
        {
            increase_quality_if_needed();
        }
        sellIn--;
        if (sellIn < 0)
        {
            quality = 0;
        }
    }
}