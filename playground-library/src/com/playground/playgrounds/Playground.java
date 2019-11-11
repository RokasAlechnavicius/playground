package com.playground.playgrounds;

import com.playground.kids.Kid;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Playground implements Serializable {

    private UUID id;
    private String playgroundName;
    private List<Kid> playgroundQueue;
    private List<Kid> kidsCurrentlyPlaying;
    private Integer amountOfKidsAllowed;
    private Integer amountOfKidsPlaying;
    private String typeOfPlayground;

    public Playground() {
    }

    public Playground(String playgroundName, Integer amountOfKidsAllowed, String typeOfPlayground) {
        this.id = UUID.randomUUID();
        this.playgroundName = playgroundName;
        this.playgroundQueue = new ArrayList<>();
        this.amountOfKidsAllowed = amountOfKidsAllowed;
        this.typeOfPlayground = typeOfPlayground;
        this.amountOfKidsPlaying = 0;
        this.kidsCurrentlyPlaying = new ArrayList<>();
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getPlaygroundName() {
        return playgroundName;
    }

    public void setPlaygroundName(String playgroundName) {
        this.playgroundName = playgroundName;
    }

    public List<Kid> getPlaygroundQueue() {
        return playgroundQueue;
    }

    public void addToQueue(Kid kid) {
        this.playgroundQueue.add(kid);
    }

    public void addToQueueVIP(Kid kid, Integer index) {
        this.playgroundQueue.add(index, kid);
    }

    public Integer getAmountOfKidsAllowed() {
        return amountOfKidsAllowed;
    }

    public void setAmountOfKidsAllowed(Integer amountOfKidsAllowed) {
        this.amountOfKidsAllowed = amountOfKidsAllowed;
    }

    public Integer calculateUtilization() {
        return (int)Math.round((double)this.kidsCurrentlyPlaying.size() / (double)this.amountOfKidsAllowed * 100);
    }

    public String getTypeOfPlayground() {
        return typeOfPlayground;
    }

    public void setTypeOfPlayground(String typeOfPlayground) {
        this.typeOfPlayground = typeOfPlayground;
    }

    public Integer getAmountOfKidsPlaying() {
        return amountOfKidsPlaying;
    }

    public void increaseAmountOfKidsPlaying() {
        this.amountOfKidsPlaying +=1;
    }

    public List<Kid> getKidsCurrentlyPlaying() {
        return this.kidsCurrentlyPlaying;
    }

    public void addToKidsCurrentlyPlaying(Kid kid) {
        this.kidsCurrentlyPlaying.add(kid);
        increaseAmountOfKidsPlaying();
    }

    @Override
    public String toString() {
        return this.getPlaygroundName();
    }
}
