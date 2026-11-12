package cinejava;

import cinejava.service.TicketService;

public class Main {
    public static void main(String[] args) {
        TicketService service = new TicketService();
        service.initData();
        service.printAll();
        service.findMostExpensiveTicket();
    }
}