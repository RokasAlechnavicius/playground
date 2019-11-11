package com.playground.kids;

import com.playground.playgrounds.Playground;

import java.util.List;

public interface KidComponent {

    public List<KidPlayedSession> kidSessionsTodayInAllPlaygrounds();

    public Integer kidSessionsTodayInAllPlaygroundsCount();

    public List<KidPlayedSession> getSessionsForSpecificKid(Kid kid);

    public Kid createNewKid(String name, Integer age, Integer ticketNumber, boolean isVipTicket);
}
