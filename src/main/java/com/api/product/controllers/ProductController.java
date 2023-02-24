package com.api.product.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.api.product.models.ProductModel;
import com.api.product.repositories.ProductRepository;

@RestController
@RequestMapping("/api")
public class ProductController {

    @Autowired
    private ProductRepository productRepository;

    // GET
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public @ResponseBody List<ProductModel> listitems() {
        return productRepository.findAll();
    }

    // POST
    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public @ResponseBody ProductModel register(@RequestBody ProductModel obj) {
        return productRepository.save(obj);
    }

    // GET ONE
    @RequestMapping(value = "/list/{id}")
    public @ResponseBody ProductModel filter(@PathVariable Integer id) {
        return productRepository.findById(id);
    }

    // PUT
    @RequestMapping(value = "/update", method = RequestMethod.PUT)
    public @ResponseBody ProductModel update(@RequestBody ProductModel obj) {
        return productRepository.save(obj);
    }

    // DELETE
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
    public @ResponseBody void remove(@PathVariable Integer id) {
        ProductModel obj = filter(id);
        this.productRepository.delete(obj);
    }
}
