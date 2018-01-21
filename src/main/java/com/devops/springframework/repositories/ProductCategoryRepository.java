package com.devops.springframework.repositories;

import com.devops.springframework.domain.ProductCategory;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by at on 5/6/16.
 */
public interface ProductCategoryRepository extends CrudRepository<ProductCategory, Integer> {
}
