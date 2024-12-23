
public class Item {

    public String name;

    public int sellIn;

    public int quality;

    public Item(String name, int sellIn, int quality) {
        this.name = name;
        this.sellIn = sellIn;
        this.quality = quality;
    }

    @Override
    public String toString() {
        return this.name + ", " + this.sellIn + ", " + this.quality;
    }

    public void decrease_quality_if_needed()
    {
        if(quality > 0 && !name.equals("Sulfuras, Hand of Ragnaros"))
        {
            quality--;
        }
    }

    public void increase_quality_if_needed()
    {
        if (quality < 50)
        {
            quality++;
        }
    }
}
