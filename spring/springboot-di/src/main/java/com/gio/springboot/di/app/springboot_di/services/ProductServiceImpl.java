package com.gio.springboot.di.app.springboot_di.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.gio.springboot.di.app.springboot_di.models.Product;
import com.gio.springboot.di.app.springboot_di.repositories.ProductRepository;

@Service
public class ProductServiceImpl implements ProductService{

 

  @Value("${config.price.tax}")
    private Double tax;

    private ProductRepository repository ;

/*
 * public ProductServiceImpl(@Qualifier("productList")  ProductRepository repository) {
        this.repository = repository;
    }
 * 
 * 
 */
   
    public ProductServiceImpl( @Qualifier("productJson")  ProductRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Product> findAll() {
        return repository.findAll().stream().map(p -> {
            Double priceTax = p.getPrice() * tax;
            Product newProd = (Product) p.clone();
            newProd.setPrice(priceTax.longValue());
            return newProd;
        }).collect(Collectors.toList());
    }

    @Override
    public Product findById(Long id) {
        return repository.findById(id);
    }

   

}
