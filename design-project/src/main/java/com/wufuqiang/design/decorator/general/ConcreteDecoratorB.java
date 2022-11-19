package com.wufuqiang.design.decorator.general;

/**
 * @author: Wu Fuqiang
 * @create: 2022-11-19 17:41
 */
public class ConcreteDecoratorB extends Decorator{
    public ConcreteDecoratorB(Component component) {
        super(component);
    }

    private void operationFirst(){
        System.out.println("装饰器B First执行");
    }

    private void operationLast(){
        System.out.println("装饰器B Last执行");
    }
    @Override
    public void operation() {
        operationFirst();
        super.operation();
        operationLast();
    }
}
