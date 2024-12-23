import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class GildedRoseTest {

    @Test
    void testFooItem() {
        Item[] items = new Item[] { new Item("foo", 1, 10) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(0, app.items[0].sellIn);
        assertEquals(9, app.items[0].quality);
    }

@Test
void testNormalItemAfterSellIn() {
    Item[] items = new Item[] { new Item("Normal Item", 0, 20) };
    GildedRose app = new GildedRose(items);
    app.updateQuality();
    assertEquals(-1, app.items[0].sellIn);
    assertEquals(18, app.items[0].quality);
}

@Test
void testAgedBrie() {
    Item[] items = new Item[] { new Item("Aged Brie", 2, 0) };
    GildedRose app = new GildedRose(items);
    app.updateQuality();
    assertEquals(1, app.items[0].sellIn);
    assertEquals(1, app.items[0].quality);
}

@Test
void testAgedBrieMaxQuality() {
    Item[] items = new Item[] { new Item("Aged Brie", 2, 50) };
    GildedRose app = new GildedRose(items);
    app.updateQuality();
    assertEquals(1, app.items[0].sellIn);
    assertEquals(50, app.items[0].quality);
}

@Test
void testSulfuras() {
    Item[] items = new Item[] { new Item("Sulfuras, Hand of Ragnaros", 0, 80) };
    GildedRose app = new GildedRose(items);
    app.updateQuality();
    assertEquals(0, app.items[0].sellIn);
    assertEquals(80, app.items[0].quality);
}

}
