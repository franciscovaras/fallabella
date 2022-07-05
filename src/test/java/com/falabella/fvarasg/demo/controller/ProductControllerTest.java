package com.falabella.fvarasg.demo.controller;

import com.falabella.fvarasg.demo.configuration.FixtureProduct;
import com.falabella.fvarasg.demo.exception.SugeridoException;
import com.falabella.fvarasg.demo.exception.UsuarioNoEncontradoException;
import com.falabella.fvarasg.demo.service.IProductService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.fail;
import static org.mockito.ArgumentMatchers.any;

@ExtendWith(MockitoExtension.class)
public class ProductControllerTest {
    @Mock
    IProductService iProductService;

    @InjectMocks
    ProductController productController;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);;
    }

    @Test
    void findAllTest_ok(){
        Mockito.when(iProductService.findAll()).thenReturn(FixtureProduct.productList());
        ResponseEntity<Object> response = productController.findAll();
        assertNotNull(response);
    }

    @Test()
    void findAllTest_error(){
        Mockito.doThrow(SugeridoException.ErrorSolicitud.class).when(iProductService).findAll();
        ResponseEntity<Object> response = productController.findAll();
    }

    @Test
    void create_ok(){
        Mockito.doNothing().when(iProductService).save(any());
        productController.create(FixtureProduct.products());
    }

    @Test
    void create_error(){
        Mockito.doThrow(SugeridoException.ErrorSolicitud.class).when(iProductService).save(any());
        productController.create(FixtureProduct.products());
    }

    @Test
    void findByIdTest_ok(){
        Mockito.when(iProductService.findById(any())).thenReturn(FixtureProduct.products());
        ResponseEntity<Object> response = productController.findById(FixtureProduct.ID);
        assertNotNull(response);
    }

    @Test()
    void  findByIdTest_error(){
        Mockito.doThrow(UsuarioNoEncontradoException.class).when(iProductService).findById(any());
        ResponseEntity<Object> response = productController.findById(FixtureProduct.ID);
    }

    @Test
    void deleteTest_ok(){
        Mockito.when(iProductService.findById(any())).thenReturn(FixtureProduct.products());
        Mockito.doNothing().when(iProductService).delete(any());
        productController.delete(FixtureProduct.ID);

    }

    @Test
    void deleteTest_error(){
        Mockito.when(iProductService.findById(any())).thenReturn(FixtureProduct.products());
        Mockito.doThrow(UsuarioNoEncontradoException.class).when(iProductService).delete(any());
        productController.delete(FixtureProduct.ID);
    }

    @Test
    void updtae_ok(){
        Mockito.doNothing().when(iProductService).update(any(), any());
        productController.update(FixtureProduct.products(), FixtureProduct.ID);
    }

    @Test
    void findBySkuTest_ok(){
        Mockito.when(iProductService.findBySku(any())).thenReturn(FixtureProduct.products());
        ResponseEntity<Object> response = productController.findBySku(FixtureProduct.SKU);
        assertNotNull(response);
    }

    @Test()
    void  findByIdSku_error(){
        Mockito.doThrow(UsuarioNoEncontradoException.class).when(iProductService).findBySku(any());
        ResponseEntity<Object> response = productController.findBySku(FixtureProduct.SKU);
    }

}
