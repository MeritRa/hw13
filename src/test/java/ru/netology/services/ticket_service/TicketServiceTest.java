package ru.netology.services.ticket_service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TicketServiceTest {
    TicketRepository repo = new TicketRepository();
    TicketManager manager = new TicketManager(repo);
    Ticket ticket1 = new Ticket(1, 500000, "ZKD", "GOJ", 450);
    Ticket ticket2 = new Ticket(2, 40000, "OGZ", "MOW", 500);
    Ticket ticket3 = new Ticket(3, 70000, "KUF", "ZKD", 145);
    Ticket ticket4 = new Ticket(4, 800000, "ZKD", "GOJ", 244);
    Ticket ticket5 = new Ticket(5, 70000, "ZKD", "GOJ", 244);
    Ticket ticket6 = new Ticket(6, 100000, "ZKD", "GOJ", 244);

    @Test
    public void saveTicketsTest() {
        repo.save(ticket1);
        repo.save(ticket2);
        repo.save(ticket3);

        Ticket[] expected = {ticket1, ticket2, ticket3};
        Ticket[] actual = repo.getTickets();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void getZeroTicketsTest() {
        Ticket[] expected = {};
        Ticket[] actual = repo.getTickets();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void removeByIdTest() {
        repo.save(ticket1);
        repo.save(ticket2);
        repo.save(ticket3);

        Ticket[] expected = {ticket1, ticket3};
        Ticket[] actual = repo.removeById(2);

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void getTicketTest() {
        repo.save(ticket1);
        repo.save(ticket2);
        repo.save(ticket3);

        Ticket[] expected = {ticket1};
        Ticket[] actual = manager.getTickets("ZKD", "GOJ");

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void getMoreTicketsTest() {
        repo.save(ticket1);
        repo.save(ticket2);
        repo.save(ticket3);
        repo.save(ticket4);
        repo.save(ticket5);
        repo.save(ticket6);

        Ticket[] expected = {ticket5, ticket6, ticket1, ticket4};
        Ticket[] actual = manager.getTickets("ZKD", "GOJ");

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void getNoneTicketsTest() {
        repo.save(ticket1);
        repo.save(ticket2);
        repo.save(ticket3);

        Ticket[] expected = {};
        Ticket[] actual = manager.getTickets("RTE", "CGT");

        Assertions.assertArrayEquals(expected, actual);
    }
}
