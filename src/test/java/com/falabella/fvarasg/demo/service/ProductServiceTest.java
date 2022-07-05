package com.falabella.fvarasg.demo.service;

import com.falabella.fvarasg.demo.configuration.FixtureProduct;
import com.falabella.fvarasg.demo.dao.IProductDao;
import com.falabella.fvarasg.demo.model.Product;
import com.falabella.fvarasg.demo.service.impl.ProductServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;

public class ProductServiceTest {

    @Mock
    IProductDao iProductDao;

    @InjectMocks
    ProductServiceImpl productService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);;
    }

    @Test
    void findAllServiceTest(){
        Mockito.when(iProductDao.findAll()).thenReturn(FixtureProduct.productList());
        List<Product> response = productService.findAll();
        assertNotNull(response);
    }

    @Test
    void saveServiceTestTest(){
        Mockito.when(iProductDao.save(any())).thenReturn(FixtureProduct.products());
        productService.save(FixtureProduct.products());
    }

    @Test
    void findByIdServiceTest(){
        Mockito.when(iProductDao.findById(any())).thenReturn(Optional.ofNullable(FixtureProduct.products()));
        Product response = productService.findById(FixtureProduct.SKU);
        assertNotNull(response);
    }

    @Test
    void deleteServiceTestTest() {
        Mockito.doNothing().when(iProductDao).delete(any());
        productService.delete(FixtureProduct.products());
    }

    @Test
    void updateServiceTest(){
        Mockito.when(iProductDao.findById(any())).thenReturn(Optional.ofNullable(FixtureProduct.products()));
        Mockito.when(iProductDao.save(any())).thenReturn(FixtureProduct.products());
        productService.update(FixtureProduct.products(), FixtureProduct.SKU);
    }

}
