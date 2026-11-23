package task2;

import java.util.*;

/*
 * ЗАДАЧА 1 — Склад интернет-магазина
 *
 *  - Product:   sku (уникальный артикул), name, priceCents (цена в центах)
 *  - Warehouse: принимает поставки товаров, отдаёт остатки, принимает заказы
 *
 * Часть 1 — ✅ сделана (equals/hashCode). Код ниже переписан на мапы по sku.
 *
 * Часть 2 — заказы со списанием остатков. Реализуй два метода:
 *
 *  2-1) placeOrder(orderId, items)
 *       items: sku -> сколько штук заказали.
 *       Заказ либо принимается ЦЕЛИКОМ, либо не принимается вообще:
 *        - если хоть одного товара нет на складе или его не хватает,
 *          ни один остаток не должен измениться, метод вернёт false;
 *        - если заказ с таким orderId уже есть, вернуть false (повтор запроса);
 *        - если items пустой или там qty <= 0, бросить IllegalArgumentException;
 *        - при успехе остатки уменьшаются, заказ запоминается, вернуть true.
 *
 *  2-2) cancelOrder(orderId)
 *       Отменяет заказ и возвращает товары на склад.
 *        - неизвестный orderId: вернуть false;
 *        - повторная отмена того же заказа: вернуть false, остатки
 *          не должны вырасти второй раз;
 *        - при успехе вернуть true.
 *
 * Тесты: OrderTest. Пока считаем, что всё однопоточно, многопоточность будет дальше.
 * Можно добавлять свои поля и классы (например, Order). Тесты не меняй.
 */

class Product {
    final String sku;
    final String name;
    final long priceCents;

    Product(String sku, String name, long priceCents) {
        this.sku = sku;
        this.name = name;
        this.priceCents = priceCents;
    }
}

public class Warehouse {

    /** Каталог: sku -> товар (последняя версия карточки товара). */
    private final Map<String, Product> products = new HashMap<>();
    /** Остатки: sku -> количество на складе. */
    private final Map<String, Integer> stock = new HashMap<>();

    /** Поставка: увеличивает остаток товара на qty. */
    public void addStock(Product product, int qty) {
        if (qty <= 0) {
            throw new IllegalArgumentException("qty must be positive: " + qty);
        }
        products.put(product.sku, product);
        stock.merge(product.sku, qty, Integer::sum);
    }

    /** Сколько единиц товара с этим sku сейчас на складе (0, если товара нет). */
    public int getAvailable(String sku) {
        return stock.getOrDefault(sku, 0);
    }

    /** Количество различных товаров (артикулов) на складе. */
    public int getProductCount() {
        return products.size();
    }

    /** Общая стоимость всех остатков в центах. */
    public long getInventoryValueCents() {
        long total = 0;
        for (Map.Entry<String, Integer> e : stock.entrySet()) {
            total += products.get(e.getKey()).priceCents * e.getValue();
        }
        return total;
    }

    // ---------------- Часть 2 ----------------

    public boolean placeOrder(String orderId, Map<String, Integer> items) {
        // TODO
        throw new UnsupportedOperationException("TODO");
    }

    public boolean cancelOrder(String orderId) {
        // TODO
        throw new UnsupportedOperationException("TODO");
    }
}
