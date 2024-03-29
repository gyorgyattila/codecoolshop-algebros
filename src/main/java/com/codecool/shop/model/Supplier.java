package com.codecool.shop.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Supplier extends BaseModel {
    private transient List<Product> products;

    public Supplier(String name, String description) {
        super(name,description);
        this.products = new ArrayList<>();
        this.description = description;

    }

    public void setProducts(ArrayList<Product> products) {
        this.products = products;
    }

    public List<Product> getProducts() {
        return this.products;
    }

    void addProduct(Product product) {
        this.products.add(product);
    }

    public String toString() {
        return String.format("id: %1$d, " +
                        "name: %2$s, " +
                        "description: %3$s",
                this.id,
                this.name,
                this.description
        );
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Supplier)) {
            return false;
        } else {
            Supplier objectAsSupplier = (Supplier) o;
            if (Objects.equals(name, objectAsSupplier.name))
                return Objects.equals(description, objectAsSupplier.description);
        }
        return false;
    }

    @Override
    public int hashCode() {

        return Objects.hash(products);
    }
}