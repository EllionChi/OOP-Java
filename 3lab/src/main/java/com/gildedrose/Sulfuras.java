public class Sulfuras extends Item
{
    public Sulfuras(int sellIn, int quality)
    {
        super("Sulfuras, Hand of Ragnaros", sellIn, quality);
    }
    @Override
    public void update_quality()
    {
        //Sulfuras doesn't change quality
    }
}