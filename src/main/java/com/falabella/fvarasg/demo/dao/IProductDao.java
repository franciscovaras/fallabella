package com.falabella.fvarasg.demo.dao;

import com.falabella.fvarasg.demo.model.Product;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface IProductDao extends CrudRepository<Product, Long> {

    @Query("select p from Product p where p.sku = ?1")
    public Product findBySku(String sku);

}
