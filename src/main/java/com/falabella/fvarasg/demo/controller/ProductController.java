package com.falabella.fvarasg.demo.controller;

import com.falabella.fvarasg.demo.exception.SugeridoException;
import com.falabella.fvarasg.demo.exception.UsuarioNoEncontradoException;
import com.falabella.fvarasg.demo.model.Product;
import com.falabella.fvarasg.demo.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    IProductService iProductService;

    @GetMapping("/search")
    public ResponseEntity<Object> findAll() {
        try {
            List<Product> response = iProductService.findAll();
            return ResponseEntity.ok().body(response);
        } catch (Exception e) {
            System.out.println(e.getClass().getName());
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/create")
    @ResponseStatus(HttpStatus.CREATED)
    public void create(@RequestBody Product product) {
        try {
            iProductService.save(product);
        } catch (SugeridoException.ErrorSolicitud e) {
            ResponseEntity.badRequest().build();
        }
    }

    @GetMapping("/search/{id}")
    public ResponseEntity<Object> findById(@PathVariable Long id) {
        try {
            Product response = iProductService.findById(id);
            Optional.ofNullable(response).orElseThrow(() -> new UsuarioNoEncontradoException(id.toString()));
            return ResponseEntity.ok().body(response);
        } catch (UsuarioNoEncontradoException e) {
            System.out.println(e.getClass().getName());
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/delete/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) {
        try {
            Product response = iProductService.findById(id);
            Optional.ofNullable(response).orElseThrow(() -> new UsuarioNoEncontradoException(id.toString()));
            iProductService.delete(response);
        } catch (UsuarioNoEncontradoException e) {
            System.out.println(e.getClass().getName());
            new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/update/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    public void update(@RequestBody Product product, @PathVariable Long id){
        iProductService.update(product, id);
    }
}
