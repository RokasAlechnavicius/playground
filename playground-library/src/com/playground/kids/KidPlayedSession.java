package com.playground.kids;

import com.playground.playgrounds.Playground;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

public class KidPlayedSession {

    private UUID id;
    private Kid kid;
    private Playground playground;
    private Date startTime;
    private Date endTime;
    private Long duration;

    public KidPlayedSession() {
    }

    public KidPlayedSession(Kid kid, Playground playground) {
        this.kid = kid;
        this.playground = playground;
        this.id = UUID.randomUUID();
        this.startTime = new Date();
    }

    public Kid getKid() {
        return kid;
    }

    public void setKid(Kid kid) {
        this.kid = kid;
    }

    public Playground getPlayground() {
        return playground;
    }

    public void setPlayground(Playground playground) {
        this.playground = playground;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public Long getDuration() {
        return duration;
    }

    public void setDuration(Long duration) {
        this.duration = duration;
    }

    public UUID getId() {
        return id;
    }

    @Override
    public String toString() {
        return this.getKid().getName() + " Played on " + this.playground + " for a total of " + this.duration + " minutes in timelapse between " +
                this.getStartTime() + " and " + this.getEndTime() + "\n";
    }
}
