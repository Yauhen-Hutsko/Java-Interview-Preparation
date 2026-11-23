package task1;

import java.util.*;

/*
 * ЗАДАЧА 1 — Склад интернет-магазина
 *
 * Мы пишем бэкенд склада. Склад хранит товары и их остатки (stock).
 *
 *  - Product:   sku (уникальный артикул), name, priceCents (цена в центах)
 *  - Warehouse: принимает поставки товаров и отдаёт остатки
 *
 * Часть 1
 *  1-1) Прочитай код, разберись, как он работает.
 *  1-2) Тест WarehouseTest не проходит из-за бага. Найди и исправь его.
 *       Не меняй тесты.
 *
 * Часть 2 (откроется после ревью Части 1) — заказы со списанием остатков.
 */



public class Warehouse {

    private final Map<Product, Integer> stock = new HashMap<>();

    public void addStock(Product product, int qty) {
        if (qty <= 0) {
            throw new IllegalArgumentException("qty must be positive: " + qty);
        }
        stock.merge(product, qty, Integer::sum);
    }

    public int getAvailable(String sku) {
        for (Map.Entry<Product, Integer> e : stock.entrySet()) {
            if (e.getKey().sku.equals(sku)) {
                return e.getValue();
            }
        }
        return 0;
    }

    /** Количество различных товаров (артикулов) на складе. */
    public int getProductCount() {
        return stock.size();
    }

    /** Общая стоимость всех остатков в центах. */
    public long getInventoryValueCents() {
        long total = 0;
        for (Map.Entry<Product, Integer> e : stock.entrySet()) {
            total += e.getKey().priceCents * e.getValue();
        }
        return total;
    }

    static class Product {
        final String sku;
        final String name;
        final long priceCents;

        Product(String sku, String name, long priceCents) {
            this.sku = sku;
            this.name = name;
            this.priceCents = priceCents;
        }
        //fix for a bug - to override equals and hashcode
        @Override
        public boolean equals(Object o) {
            if (!(o instanceof Product product)) return false;
            return priceCents == product.priceCents && Objects.equals(sku, product.sku) && Objects.equals(name, product.name);
        }

        @Override
        public int hashCode() {
            return Objects.hash(sku, name, priceCents);
        }
    }
}
