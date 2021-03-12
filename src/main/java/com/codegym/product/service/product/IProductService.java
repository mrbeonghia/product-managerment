package com.codegym.product.service.product;

import com.codegym.product.model.Product;
import com.codegym.product.service.IService;

import java.util.List;

public interface IProductService extends IService<Product> {
    List<Product> findByCategoryName(Long id);
    List<Product> findTop5ProductPrice();
    List<Product> findTop5ProductNewest();
}
