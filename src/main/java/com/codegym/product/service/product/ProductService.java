package com.codegym.product.service.product;

import com.codegym.product.model.Product;
import com.codegym.product.repository.IProductRepository;
import com.codegym.product.service.product.IProductService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class ProductService implements IProductService {
    @Autowired
    private IProductRepository productRepository;

    @Override
    public Iterable<Product> findAll() {
        return productRepository.findAll();
    }

    @Override
    public Product findById(Long id) {
        return productRepository.findOne(id);
    }

    @Override
    public void save(Product product) {
        productRepository.save(product);
    }

    @Override
    public void delete(Long id) {
        productRepository.delete(id);
    }

    @Override
    public List<Product> findByCategoryName(Long id) {
        return productRepository.findProductByCategoryName(id);
    }

    @Override
    public List<Product> findTop5ProductPrice() {
        return productRepository.findTop5ByOrderByPriceDesc(5);
    }

    @Override
    public List<Product> findTop5ProductNewest() {
        return findTop5ProductNewest();
    }

}
