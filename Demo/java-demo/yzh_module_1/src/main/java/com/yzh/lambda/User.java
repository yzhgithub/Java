package com.yzh.lambda;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class User {
    private String name;
    private String sex;
    private int age;
    private BigDecimal number;
}
