package com.falabella.fvarasg.demo.service.impl;

import com.falabella.fvarasg.demo.dao.IProductDao;
import com.falabella.fvarasg.demo.model.Product;
import com.falabella.fvarasg.demo.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ProductServiceImpl implements IProductService {

    @Autowired
    IProductDao iProductDao;

    @Override
    public List<Product> findAll() {
        return (List<Product>) iProductDao.findAll();
    }

    @Override
    @Transactional
    public void save(Product product) {
        iProductDao.save(product);
    }

    @Override
    public Product findById(Long id) {
        return iProductDao.findById(id).orElse(null);
    }

    @Override
    @Transactional
    public void delete(Product product) {
        iProductDao.delete(product);
    }

    @Override
    @Transactional
    public void update(Product product, Long id) {
        Product response = this.findById(id);
        response.setName(product.getName());
        response.setBrand(product.getBrand());
        response.setSize(product.getSize());
        response.setPrice(product.getPrice());
        response.setPrincipalImage(product.getPrincipalImage());
        iProductDao.save(response);
    }
}
