package com.wufuqiang.design.flyweight.ticket;

/**
 * @author: Wu Fuqiang
 * @create: 2022-11-19 21:15
 */
public class FlyweightTest {
    public static void main(String[] args) {
        ITicket ticket = TicketFactory.queryTicket("北京西", "长沙");
        ticket.showInfo("硬座");
        ticket = TicketFactory.queryTicket("北京西", "长沙");
        ticket.showInfo("硬座");

    }
}
