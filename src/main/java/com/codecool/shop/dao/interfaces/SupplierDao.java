package com.codecool.shop.dao.interfaces;

import com.codecool.shop.model.Supplier;

import java.util.List;

public interface SupplierDao {

    void add(Supplier supplier);

    Supplier find(int id);

    Supplier find(String name);

    void remove(int id);

    List<Supplier> getAll();
}
