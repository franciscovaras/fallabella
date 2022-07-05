package com.falabella.fvarasg.demo.dao;

import com.falabella.fvarasg.demo.model.Product;
import org.springframework.data.repository.CrudRepository;

public interface IProductDao extends CrudRepository<Product, Long> {



}
