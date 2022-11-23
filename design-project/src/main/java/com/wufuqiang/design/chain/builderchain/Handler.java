package com.wufuqiang.design.chain.builderchain;

/**
 * @author: Wu Fuqiang
 * @create: 2022-11-23 20:41
 */
public abstract class Handler<T> {
    protected Handler next;
    public void next(Handler next){
        this.next =next;
    }

    public abstract  void doHandler(Member member);

    public static class Builder<T>{
        private Handler<T> head;
        private Handler<T> tail;

        public Builder<T> addHandler(Handler<T> handler){
            if(this.head == null){
                this.head = this.tail = handler;
                return this;
            }

            this.tail.next(handler);
            this.tail = handler;

            return this;
        }

        public Handler<T> build(){
            return this.head;
        }

    }
}
