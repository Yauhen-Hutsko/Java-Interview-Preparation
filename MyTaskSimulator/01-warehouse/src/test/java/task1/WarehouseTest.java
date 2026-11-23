package task1;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class WarehouseTest {

    @Test
    void newProductIsAvailable() {
        Warehouse w = new Warehouse();
        w.addStock(new Warehouse.Product("SKU-1", "Mouse", 2_500), 10);

        assertEquals(10, w.getAvailable("SKU-1"));
        assertEquals(0, w.getAvailable("SKU-404"));
    }

    @Test
    void restockOfSameSkuIsSummedUp() {
        Warehouse w = new Warehouse();
        // Первая поставка
        w.addStock(new Warehouse.Product("SKU-1", "Mouse", 2_500), 10);
        // Вторая поставка того же товара. Объект Product пришёл из другого запроса,
        // поэтому это новый экземпляр с тем же sku.
        w.addStock(new Warehouse.Product("SKU-1", "Mouse", 2_500), 5);
        w.addStock(new Warehouse.Product("SKU-2", "Keyboard", 7_000), 3);

        assertEquals(15, w.getAvailable("SKU-1"));
        assertEquals(3, w.getAvailable("SKU-2"));
        assertEquals(2, w.getProductCount());
        assertEquals(15 * 2_500 + 3 * 7_000, w.getInventoryValueCents());
    }

    @Test
    void nonPositiveQtyIsRejected() {
        Warehouse w = new Warehouse();
        assertThrows(IllegalArgumentException.class,
                () -> w.addStock(new Warehouse.Product("SKU-1", "Mouse", 2_500), 0));
    }
}
