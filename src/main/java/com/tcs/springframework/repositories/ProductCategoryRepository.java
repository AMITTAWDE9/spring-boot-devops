package com.tcs.springframework.repositories;

import com.tcs.springframework.domain.ProductCategory;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by jt on 5/6/16.
 */
public interface ProductCategoryRepository extends CrudRepository<ProductCategory, Integer> {
}
