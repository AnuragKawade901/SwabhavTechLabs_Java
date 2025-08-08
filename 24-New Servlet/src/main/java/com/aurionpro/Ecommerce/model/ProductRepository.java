package com.aurionpro.Ecommerce.model;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
public class ProductRepository {
    private static final List<Product> products = List.of(

        new Product(1, "Laptop", 60000, "Electronics"),
        new Product(2, "Headphones", 1500, "Electronics"),
        new Product(3, "Smartphone", 25000, "Electronics"),
        new Product(4, "Bluetooth Speaker", 2000, "Electronics"),

 
        new Product(5, "T-Shirt", 499, "Fashion"),
        new Product(6, "Jeans", 999, "Fashion"),
        new Product(7, "Sneakers", 1999, "Fashion"),
        new Product(8, "Jacket", 1499, "Fashion"),

  
        new Product(9, "LEGO Set", 899, "Toys"),
        new Product(10, "Remote Control Car", 1199, "Toys"),
        new Product(11, "Barbie Doll", 799, "Toys"),
        new Product(12, "Nerf Gun", 999, "Toys"),

    
        new Product(13, "Fiction Novel", 299, "Books"),
        new Product(14, "Self-Help Book", 399, "Books"),
        new Product(15, "Comic Book", 199, "Books"),

        new Product(16, "Coffee Maker", 2200, "Home & Kitchen"),
        new Product(17, "Air Fryer", 4500, "Home & Kitchen"),
        new Product(18, "Wall Clock", 999, "Home & Kitchen"),

        new Product(19, "Mouse", 499, "Accessories"),
        new Product(20, "Keyboard", 999, "Accessories"),
        new Product(21, "Laptop Bag", 899, "Accessories")
    );

    public static List<Product> getAllProducts() {
        return products;
    }

    public static Product getById(int id) {
        return products.stream().filter(p -> p.getId() == id).findFirst().orElse(null);
    }

    public static Map<String, List<Product>> getProductsGroupedByCategory() {
        Map<String, List<Product>> grouped = new LinkedHashMap<>();
        for (Product p : products) {
            grouped.computeIfAbsent(p.getCategory(), k -> new ArrayList<>()).add(p);
        }
        return grouped;
    }
}
