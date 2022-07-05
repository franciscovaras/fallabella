package com.falabella.fvarasg.demo.service;

import com.falabella.fvarasg.demo.model.Product;

import java.util.List;

public interface IProductService {
    
    public List<Product> findAll();

    public void save(Product product);

    public Product findById(Long id);

    public void delete(Product product);

    public void update(Product product, Long id);

    public Product findBySku(String sku);
}
