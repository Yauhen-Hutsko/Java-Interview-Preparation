package task2;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class OrderTest {

    private Warehouse w;

    @BeforeEach
    void setUp() {
        w = new Warehouse();
        w.addStock(new Product("MOUSE", "Mouse", 2_500), 10);
        w.addStock(new Product("KBD", "Keyboard", 7_000), 3);
    }

    @Test
    void successfulOrderDecreasesStock() {
        assertTrue(w.placeOrder("o-1", Map.of("MOUSE", 4, "KBD", 1)));

        assertEquals(6, w.getAvailable("MOUSE"));
        assertEquals(2, w.getAvailable("KBD"));
    }

    @Test
    void orderCanTakeExactlyAllStock() {
        assertTrue(w.placeOrder("o-1", Map.of("KBD", 3)));
        assertEquals(0, w.getAvailable("KBD"));
    }

    @Test
    void notEnoughStockRejectsWholeOrder() {
        // мышей хватает, клавиатур нет: мыши тоже не должны списаться
        assertFalse(w.placeOrder("o-1", Map.of("MOUSE", 2, "KBD", 5)));

        assertEquals(10, w.getAvailable("MOUSE"));
        assertEquals(3, w.getAvailable("KBD"));
    }

    @Test
    void notEnoughStockRejectsWholeOrderRegardlessOfItemOrder() {
        // LinkedHashMap фиксирует порядок: сначала проблемный товар, потом нормальный, и наоборот
        Map<String, Integer> badFirst = new java.util.LinkedHashMap<>();
        badFirst.put("KBD", 5);
        badFirst.put("MOUSE", 2);
        Map<String, Integer> badLast = new java.util.LinkedHashMap<>();
        badLast.put("MOUSE", 2);
        badLast.put("KBD", 5);

        assertFalse(w.placeOrder("o-1", badFirst));
        assertFalse(w.placeOrder("o-2", badLast));

        assertEquals(10, w.getAvailable("MOUSE"));
        assertEquals(3, w.getAvailable("KBD"));
    }

    @Test
    void unknownSkuRejectsWholeOrder() {
        assertFalse(w.placeOrder("o-1", Map.of("MOUSE", 1, "MONITOR", 1)));
        assertEquals(10, w.getAvailable("MOUSE"));
        assertEquals(0, w.getAvailable("MONITOR"));
    }

    @Test
    void duplicateOrderIdIsRejected() {
        assertTrue(w.placeOrder("o-1", Map.of("MOUSE", 1)));
        assertFalse(w.placeOrder("o-1", Map.of("MOUSE", 1)));

        assertEquals(9, w.getAvailable("MOUSE"));
    }

    @Test
    void rejectedOrderIdCanBeRetried() {
        assertFalse(w.placeOrder("o-1", Map.of("KBD", 5)));
        w.addStock(new Product("KBD", "Keyboard", 7_000), 2);

        assertTrue(w.placeOrder("o-1", Map.of("KBD", 5)));
        assertEquals(0, w.getAvailable("KBD"));
    }

    @Test
    void invalidItemsThrow() {
        assertThrows(IllegalArgumentException.class, () -> w.placeOrder("o-1", Map.of()));
        assertThrows(IllegalArgumentException.class, () -> w.placeOrder("o-2", Map.of("MOUSE", 0)));
        assertThrows(IllegalArgumentException.class, () -> w.placeOrder("o-3", Map.of("MOUSE", -1)));
        assertEquals(10, w.getAvailable("MOUSE"));
    }

    @Test
    void callerChangingItemsMapAfterwardsDoesNotAffectOrder() {
        Map<String, Integer> items = new HashMap<>();
        items.put("MOUSE", 2);
        assertTrue(w.placeOrder("o-1", items));

        items.put("MOUSE", 9); // вызывающий код переиспользовал свою мапу
        assertTrue(w.cancelOrder("o-1"));

        assertEquals(10, w.getAvailable("MOUSE"));
    }

    @Test
    void cancelReturnsStock() {
        w.placeOrder("o-1", Map.of("MOUSE", 4, "KBD", 3));
        assertTrue(w.cancelOrder("o-1"));

        assertEquals(10, w.getAvailable("MOUSE"));
        assertEquals(3, w.getAvailable("KBD"));
    }

    @Test
    void cancelUnknownOrderReturnsFalse() {
        assertFalse(w.cancelOrder("nope"));
    }

    @Test
    void doubleCancelDoesNotReturnStockTwice() {
        w.placeOrder("o-1", Map.of("MOUSE", 4));
        assertTrue(w.cancelOrder("o-1"));
        assertFalse(w.cancelOrder("o-1"));

        assertEquals(10, w.getAvailable("MOUSE"));
    }

    @Test
    void cancelledStockCanBeOrderedAgain() {
        w.placeOrder("o-1", Map.of("KBD", 3));
        assertFalse(w.placeOrder("o-2", Map.of("KBD", 1)));

        w.cancelOrder("o-1");
        assertTrue(w.placeOrder("o-2", Map.of("KBD", 1)));
        assertEquals(2, w.getAvailable("KBD"));
    }
}
