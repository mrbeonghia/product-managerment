package com.codegym.product.controller;

import com.codegym.product.model.Category;
import com.codegym.product.model.Product;
import com.codegym.product.service.category.ICategoryService;
import com.codegym.product.service.product.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;



@Controller
@RequestMapping("/products")
public class ProductController {
    @Autowired
    IProductService productService;
    @Autowired
    ICategoryService categoryService;

    @ModelAttribute("categories")
    public Iterable<Category> Categories(){
        return categoryService.findAll();
    }

    @GetMapping("")
    public ModelAndView showAllCustomer(){
        ModelAndView modelAndView= new ModelAndView("product/list");
        Iterable<Product> products= productService.findAll();
        modelAndView.addObject("products",products);
        return modelAndView;
    }


    @GetMapping("/add")
    public ModelAndView showInsertForm() {
        ModelAndView modelAndView = new ModelAndView("product/add");
        modelAndView.addObject("product", new Product());
        return modelAndView;
    }

    @PostMapping("/add")
    public ModelAndView insertCustomer(@ModelAttribute("product") Product product) {
        productService.save(product);
        ModelAndView modelAndView = new ModelAndView("product/add");
        modelAndView.addObject("message", "Product created successfully");
        return modelAndView;
    }


    @GetMapping("/edit/{id}")
    public ModelAndView showEditForm(@PathVariable Long id){
        Product product = productService.findById(id);
        if(product != null) {
            ModelAndView modelAndView = new ModelAndView("product/edit");
            modelAndView.addObject("product", product);
            return modelAndView;

        }else {
            ModelAndView modelAndView = new ModelAndView("/error");
            return modelAndView;
        }
    }

    @PostMapping("/edit")
    public ModelAndView updateCustomer(@ModelAttribute("product") Product product){
        productService.save(product);
        ModelAndView modelAndView = new ModelAndView("product/edit");
        modelAndView.addObject("product", new Product());
        modelAndView.addObject("message", "Product updated successfully");
        return modelAndView;
    }

    @GetMapping("/delete/{id}")
    public ModelAndView showDeleteForm(@PathVariable Long id){
        Product product = productService.findById(id);
        if(product != null) {
            ModelAndView modelAndView = new ModelAndView("product/delete");
            modelAndView.addObject("product", product);
            return modelAndView;
        }else {
            ModelAndView modelAndView = new ModelAndView("/error");
            return modelAndView;
        }
    }

    @PostMapping("/delete")
    public String deleteCustomer(@ModelAttribute("product") Product product){
        productService.delete(product.getId());
        return "redirect:/customers";
    }

    @GetMapping("/detail/{id}")
    public ModelAndView detailCustomer(@PathVariable Long id){
        Product product = productService.findById(id);
        if(product != null) {
            ModelAndView modelAndView = new ModelAndView("product/detail");
            modelAndView.addObject("product", product);
            return modelAndView;
        }else {
            ModelAndView modelAndView = new ModelAndView("/error");
            return modelAndView;
        }
    }
}
