package com.api.product.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.api.product.models.ProductModel;

@Repository
public interface ProductRepository extends CrudRepository<ProductModel, Long> {

    // Documentação:
    // https://docs.spring.io/spring-data/data-commons/docs/2.3.0.RELEASE/reference/html/#repositories.core-concepts

    // GET
    List<ProductModel> findAll();

    // GET ONE
    ProductModel findById(int id);

    // DELETE
    void delete(ProductModel obj);

    // POST and PUT
    <ProdMod extends ProductModel> ProdMod save(ProdMod obj);

}
