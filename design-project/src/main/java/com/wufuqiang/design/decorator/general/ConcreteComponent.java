package com.wufuqiang.design.decorator.general;

/**
 * @author: Wu Fuqiang
 * @create: 2022-11-19 17:09
 */
public class ConcreteComponent extends Component {
    @Override
    public void operation() {
        System.out.println("处理业务逻辑");
    }
}
