package ru.geekbrains.geekspringstartboot;

import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Component
public class Repository {
    private static Long IdGenerator = 0L;
    List<Product> products;

    @PostConstruct
    public void init(){
        products = new ArrayList<>();
    }

    public Product getProductByID(Long id){
        return products.stream().filter(product -> product.getId().equals(id)).findFirst().orElseThrow(RuntimeException::new);
    }

    public List<Product> getALLProducts(){
        return Collections.unmodifiableList(products);
    }

    public Long addProduct(Product product){
        Long id = IdGenerator++;
        products.add(new Product(id, product.getTitle(), product.getCost()));
        return id;
    }

}
