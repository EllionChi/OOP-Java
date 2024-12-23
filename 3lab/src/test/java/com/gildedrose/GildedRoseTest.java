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
    }

}
