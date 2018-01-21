package com.tcs.springframework.services;

import com.tcs.springframework.domain.Product;

import java.util.List;

/**
 * Created by at on 1/26/16.
 */
public interface ProductService {

    Product getProduct(Integer id);

    List<Product> listProducts();
}
