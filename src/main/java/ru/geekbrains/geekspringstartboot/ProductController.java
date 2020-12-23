package ru.geekbrains.geekspringstartboot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/products")
public class ProductController {

    @Autowired
    Repository repository;

    @GetMapping(value = "/list")
    public String getProductList(Model model){
        model.addAttribute("products", repository.getALLProducts());
        return "products";
    }

    @PostMapping(value = "/form")
    public String add(Product product, Model model) {
        Long id = repository.addProduct(product);
        model.addAttribute("product", repository.getProductByID(id));
        return "new_product";
    }
    @GetMapping(value="/form")
    public String getForm(Model model){
        Product product = new Product();
        model.addAttribute("product", product);
        return "new_product";
    }
}
