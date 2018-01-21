package com.devops.springframework.services;

import com.devops.springframework.domain.Product;

import java.util.List;

/**
 * Created by at on 1/26/16.
 */
public interface ProductService {

    Product getProduct(Integer id);

    List<Product> listProducts();
}
