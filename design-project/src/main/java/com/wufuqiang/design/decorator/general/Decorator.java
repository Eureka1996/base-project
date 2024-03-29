package com.wufuqiang.design.decorator.general;

/**
 * @author: Wu Fuqiang
 * @create: 2022-11-19 17:10
 */
public class Decorator extends Component {
    // 持有组件对象
    protected Component component;

    // 构造方法，传入组件对象
    public Decorator(Component component) {
        this.component = component;
    }

    @Override
    public void operation() {
        // 转发请求给组件对象，可以在转发前后执行一些附加动作
        component.operation();
    }
}
