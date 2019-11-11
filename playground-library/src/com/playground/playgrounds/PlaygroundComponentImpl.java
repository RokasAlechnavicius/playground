package com.playground.playgrounds;

import com.playground.datastorage.KidPlayedSessionStorage;
import com.playground.datastorage.PlaygroundStorage;
import com.playground.kids.Kid;
import com.playground.kids.KidPlayedSession;

import java.util.Date;
import java.util.List;

public class PlaygroundComponentImpl implements PlaygroundComponent {

    public static final Integer QUEUE_DIFF = 4;
    public static final Integer MILISECONDS_TO_MINUTES = 60000;
    private PlaygroundStorage playgroundStorage;
    private KidPlayedSessionStorage kidPlayedSessionStorage;

    public PlaygroundComponentImpl(KidPlayedSessionStorage kidPlayedSessionStorage, PlaygroundStorage playgroundStorage) {
        this.kidPlayedSessionStorage = kidPlayedSessionStorage;
        this.playgroundStorage = playgroundStorage;
    }
    @Override
    public String enrollInQueue(Playground playground, Kid kid) {
        if (playground.getKidsCurrentlyPlaying().contains(kid) || kid.getCurrentSessionId() != null) {
            return "Kid is already in the playground";
        } else if (playground.calculateUtilization() == 100) {
            return "playground is full, do you want to be enrolled in queue?";
        }
        else {
            playground.addToKidsCurrentlyPlaying(kid);
            createNewKidPlayedSession(kid, playground);
            return "added to playground";
        }
    }

    @Override
    public String acceptsQueue(Playground playground, Kid kid) {
        if(kid._isVipTicket()) {
            if(!areAnyVIPInQueue(playground.getPlaygroundQueue())) {
                playground.addToQueueVIP(kid, 0);
                return "kid added first in queue";
            }
            Integer indexOfQueue = getVIPNumberInQueue(playground.getPlaygroundQueue());
            if(playground.getPlaygroundQueue().size() - QUEUE_DIFF > indexOfQueue) {
                playground.addToQueueVIP(kid, indexOfQueue + QUEUE_DIFF);
                return "Kid added to queue at position: " + (indexOfQueue + 1);
            }
        }
//        If vip will not get earlier access because other VIPS are ahead or is not vip
        playground.addToQueue(kid);
        return "Kid added to the back of the queue at position: " + playground.getPlaygroundQueue().size();
    }

    @Override
    public String removeFromQueue(Playground playground, Kid kid) {
        if(playground.getPlaygroundQueue().contains(kid)) {
            playground.getPlaygroundQueue().remove(kid);
            return "Kid was successfully removed from the playground queue";
        } else {
            return "kid is not in queue of this playground";
        }
    }

    @Override
    public String removeFromPlayground(Playground playground, Kid kid) {
        if(playground.getKidsCurrentlyPlaying().contains(kid)) {
            playground.getKidsCurrentlyPlaying().remove(kid);
            changeSessionParameters(kid);
            if(playground.getPlaygroundQueue().size() != 0) {
                enrollInQueue(playground, playground.getPlaygroundQueue().get(0));
                playground.getPlaygroundQueue().remove(0);
            }
            return "Kid was successfully removed from playground";
        } else {
            return "Kid is not in this playground";
        }
    }

    private void createNewKidPlayedSession(Kid kid, Playground playground) {
        KidPlayedSession newSession = new KidPlayedSession(kid, playground);
        kid.setCurrentSessionId(newSession.getId());
        kidPlayedSessionStorage.addObject(newSession);
    }

    private Boolean areAnyVIPInQueue(List<Kid> queueList) {
        for (Kid kidinQueue : queueList) {
            if (kidinQueue._isVipTicket()) {
                return true;
            }
        }
        return false;
    }

    private Integer getVIPNumberInQueue(List<Kid> queueList) {
        Integer lastVipIndex = 0;
        Integer index = 0;
        for (Kid kidInQueue : queueList) {
            if (kidInQueue._isVipTicket()) {
                lastVipIndex = index;
            }
            index++;
        }
        return lastVipIndex;
    }

    private void changeSessionParameters(Kid kid) {
        KidPlayedSession changedSession = kidPlayedSessionStorage.findSessionByUUID(kid.getCurrentSessionId());
        changedSession.setEndTime(new Date());
        changedSession.setDuration((changedSession.getEndTime().getTime() - changedSession.getStartTime().getTime()) / MILISECONDS_TO_MINUTES);
        kid.setCurrentSessionId(null);
    }

    @Override
    public Playground createPlayground(String playgroundName, Integer amountOfKidsAllowed, String typeOfPlayground) {
        Playground playground = new Playground(playgroundName, amountOfKidsAllowed, typeOfPlayground);
        playgroundStorage.addObject(playground);
        return playground;
    }

    @Override
    public DoubleSwingsPlayground createDoubleSwingsPlayground(String playgroundName, String typeOfPlayground) {
        DoubleSwingsPlayground playground = new DoubleSwingsPlayground(playgroundName, typeOfPlayground);
        playgroundStorage.addObject(playground);
        return playground;
    }

}
