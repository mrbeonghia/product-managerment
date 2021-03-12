package com.codegym.product.repository;

import com.codegym.product.model.Product;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;


public interface IProductRepository extends CrudRepository<Product, Long> {

    //Tìm kiếm sản phẩm theo category
    @Query(value = "select * from product where product.category_id = ?", nativeQuery = true)
    List<Product> findProductByCategoryName(Long id);

    @Query(value = "select * from product order by price desc limit ?", nativeQuery = true)
    List<Product> findTop5ByOrderByPriceDesc(int num);

}

