package com.wufuqiang.design.decorator.general;

/**
 * @author: Wu Fuqiang
 * @create: 2022-11-19 17:45
 */
public class DecoratorTest {
    public static void main(String[] args) {
        ConcreteComponent c1 = new ConcreteComponent();
        ConcreteDecoratorA decoratorA = new ConcreteDecoratorA(c1);
        decoratorA.operation();
        System.out.println("============================");
        ConcreteDecoratorB decoratorB = new ConcreteDecoratorB(c1);
        decoratorB.operation();
        System.out.println("============================");
        ConcreteDecoratorB decoratorBandA = new ConcreteDecoratorB(decoratorA);
        decoratorBandA.operation();

    }
}
