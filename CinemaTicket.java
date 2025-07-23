package org.example;

public class CinemaTicket {
    public static void main(String[] args) {
        //设置三个售票窗口
        TicketWindow w1 = new TicketWindow();
        TicketWindow w2 = new TicketWindow();
        TicketWindow w3 = new TicketWindow();

        //设置窗口
        w1.setName("窗口1");
        w2.setName("窗口2");
        w3.setName("窗口3");

        //启动！！
        w1.start();
        w2.start();
        w3.start();
    }
}
