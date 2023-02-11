package ru.netology.services.ticket_service;

import java.util.Arrays;

public class TicketManager {
    protected TicketRepository repo;

    public TicketManager(TicketRepository repo) {
        this.repo = repo;
    }

    public Ticket[] getTickets(String from, String to) {
        Ticket[] tickets = new Ticket[0];
        for (Ticket ticket : repo.getTickets()) {
            if (matches(ticket, from, to)) {
                Ticket[] tmp = new Ticket[tickets.length + 1];
                for (int i = 0; i < tickets.length; i++) {
                    tmp[i] = tickets[i];
                }
                tmp[tmp.length - 1] = ticket;
                tickets = tmp;
            }
        }
        Arrays.sort(tickets);
        return tickets;
    }

    private boolean matches(Ticket ticket, String from, String to) {
        if (ticket.getFrom().equals(from)) {
            if (ticket.getTo().equals(to)) {
                return true;
            }
        }
        return false;
    }
}
