package com.ltp.globalsuperstore;

import com.ltp.globalsuperstore.entity.Product;
import org.springframework.stereotype.*;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


import java.util.Arrays;
import java.util.HashMap;

import java.util.Map;

@Controller
public class ControllerClass {
    private Map<String,Product> products = new HashMap<>();

    @GetMapping("/")
    public String formPage(Model model , @RequestParam (required = false) String id){
        model.addAttribute("offers" , Arrays.stream(Constants.CATEGORIES).toList());
        model.addAttribute( "product" , products.containsKey(id) ? products.get(id) : new Product());
        return "form";
    }
    @GetMapping("/inventory")
    public String inventoryPage(Model model){
        model.addAttribute("products" , products.values().stream().toList());
        return "inventory";
    }
    @PostMapping("/handleCreateProduct")
    public String createProduct(Product product , @RequestParam (required = false) String id){
        products.remove(id);
        products.put(product.getId() , product);
        return "redirect:/inventory";
    }
}
