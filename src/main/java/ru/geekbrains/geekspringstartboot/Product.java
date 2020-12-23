package ru.geekbrains.geekspringstartboot;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Product {

    private Long id;
    private String title;
    private BigDecimal cost;
}
