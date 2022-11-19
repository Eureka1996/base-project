package com.wufuqiang.design.builder.general;

/**
 * @author: Wu Fuqiang
 * @create: 2022-11-18 23:43
 */
public class ConcreteBuilder implements IBuilder {
    private Product product = new Product();

    @Override
    public Product build() {
        return product;
    }
}
