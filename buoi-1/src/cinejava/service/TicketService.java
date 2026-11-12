package cinejava.service;

import cinejava.model.StudentTicket;
import cinejava.model.Ticket;
import cinejava.model.VipTicket;
import java.util.ArrayList;
import java.util.List;

public class TicketService {
    private List<Ticket> list = new ArrayList<>();

    public void initData() {
        list.add(new Ticket("T01", "Mai", 90000));
        list.add(new VipTicket("V01", "Dune", 100000, 30000, 32000)); 
        list.add(new StudentTicket("S01", "Mai", 90000, 20));       
        list.add(new Ticket("T02", "Exhuma", 100000));
        list.add(new VipTicket("V02", "Inside Out 2", 90000, 20000, 14000));
        
        // Them thu ve doi vao danh sach mau neu muon
        // list.add(new CoupleTicket("C01", "Avatar 2", 120000));
    }

    public void printAll() {
        System.out.println("===== DANH SACH VE =====");
        for (Ticket t : list) {
            t.printInfo(); 
        }
    }

    public void findMostExpensiveTicket() {
        if (list.isEmpty()) {
            System.out.println("Danh sach trong!");
            return;
        }

        Ticket maxTicket = list.get(0);
        for (Ticket t : list) {
            if (t.finalPrice() > maxTicket.finalPrice()) {
                maxTicket = t;
            }
        }

        System.out.println("\nVe dat nhat: " + maxTicket.getId() + " | " + maxTicket.getMovieName() + " | " + (long)maxTicket.finalPrice());
    }
}