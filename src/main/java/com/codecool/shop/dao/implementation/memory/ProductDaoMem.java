package com.codecool.shop.dao.implementation.memory;


import com.codecool.shop.dao.interfaces.ProductDao;
import com.codecool.shop.model.Product;
import com.codecool.shop.model.ProductCategory;
import com.codecool.shop.model.Supplier;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class ProductDaoMem implements ProductDao {

    private List<Product> data = new ArrayList<>();
    private static ProductDaoMem instance = null;

    /* A private Constructor prevents any other class from instantiating.
     */
    private ProductDaoMem() {
    }

    public static ProductDaoMem getInstance() {
        if (instance == null) {
            instance = new ProductDaoMem();
        }
        return instance;
    }

    @Override
    public void add(Product product) {
        product.setId(data.size() + 1);
        data.add(product);
    }

    @Override
    public Product find(int id) {
        return data.stream().filter(t -> t.getId() == id).findFirst().orElse(null);
    }

    @Override
    public void remove(int id) {
        data.remove(find(id));
    }

    @Override
    public List<Product> getAll() {
        return Collections.unmodifiableList(data);
    }

    @Override
    public List<Product> getBy(Supplier supplier) {
        return Collections.unmodifiableList(data.stream()
                .filter(t -> t.getSupplier().equals(supplier))
                .collect(Collectors.toList())) ;
    }

    @Override
    public List<Product> getBy(ProductCategory productCategory) {
        return Collections.unmodifiableList(data.stream()
                .filter(t -> t.getProductCategory().equals(productCategory))
                .collect(Collectors.toList()));
    }
    @Override
    public List<Product> getBy(Supplier supplier, ProductCategory productCategory){
        return Collections.unmodifiableList(data.stream()
                .filter(t -> (t.getProductCategory().equals(productCategory) && t.getSupplier().equals(supplier)))
                .collect(Collectors.toList()));
    }
}
