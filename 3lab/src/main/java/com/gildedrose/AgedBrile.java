public class AgedBrie extends Item
{
    public AgedBrie(int sellIn, int quality)
    {
        super("Aged Brie", sellIn, quality);
    }
    @Override
    public void update_quality()
    {
        increase_quality_if_needed();
        sellIn--;
        if (sellIn < 0)
        {
            increase_quality_if_needed();
        }
    }
}