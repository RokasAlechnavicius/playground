package com.playground.kids;

import com.playground.datastorage.GenericStorage;
import java.util.UUID;

public class Kid {

    private GenericStorage storage;

    private UUID id;
    private String name;
    private Integer age;
    private Integer ticketNumber;
    private Boolean isVipTicket;
    private UUID currentSessionId;

    public Kid() {
        this.id = UUID.randomUUID();
    }

    public Kid( String name, Integer age, Integer ticketNumber, boolean isVipTicket) {
        this.id = UUID.randomUUID();
        this.name = name;
        this.age = age;
        this.ticketNumber = ticketNumber;
        this.isVipTicket = isVipTicket;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Integer getTicketNumber() {
        return ticketNumber;
    }

    public void setTicketNumber(Integer ticketNumber) {
        this.ticketNumber = ticketNumber;
    }

    public Boolean _isVipTicket() {
        return isVipTicket;
    }

    public void setVipTicket(Boolean vipTicket) {
        isVipTicket = vipTicket;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public UUID getCurrentSessionId() {
        return currentSessionId;
    }

    public void setCurrentSessionId(UUID currentSessionId) {
        this.currentSessionId = currentSessionId;
    }

    @Override
    public String toString() {
        return this.name + ", " + this.age + " years old and has vip ticket: " + isVipTicket + "\n";

    }
}
