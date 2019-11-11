package com.playground;

import com.playground.datastorage.*;
import com.playground.kids.Kid;
import com.playground.kids.KidComponent;
import com.playground.kids.KidComponentImpl;
import com.playground.playgrounds.Playground;
import com.playground.playgrounds.DoubleSwingsPlayground;
import com.playground.playgrounds.PlaygroundComponent;
import com.playground.playgrounds.PlaygroundComponentImpl;

public class Main {

    public static void main(String[] args) throws InterruptedException {
        /*KidStorageMemoryImpl kidStorage = new KidStorageMemoryImpl();
        PlaygroundStorageMemoryImpl playgroundStorage = new PlaygroundStorageMemoryImpl();
        KidPlayedSessionMemoryStorageImpl kidPlayedSessionStorage = new KidPlayedSessionMemoryStorageImpl();
        KidComponent kidComponent = new KidComponentImpl(kidStorage, playgroundStorage, kidPlayedSessionStorage);
        PlaygroundComponent playgroundComponent = new PlaygroundComponentImpl(kidPlayedSessionStorage, playgroundStorage);
        Playground pg = playgroundComponent.createDoubleSwingsPlayground("SomeSwings", "Double swings");
//        Playground pg2 = playgroundComponent.createPlayground("SomePlayground", 5, "simple playground");

        Kid kid = kidComponent.createNewKid("kid", 15, 123, false);
        Kid kid2 = kidComponent.createNewKid("kid2", 14, 1234, false);
        Kid kid3 = kidComponent.createNewKid("kid3", 14, 12345, false);
        Kid kid4 = kidComponent.createNewKid("kid4", 14, 123456, false);
        Kid kid5 = kidComponent.createNewKid("kidVIP5", 14, 12344, true);
        Kid kid6 = kidComponent.createNewKid("kidVIP6", 14, 12342, true);
        Kid kid7 = kidComponent.createNewKid("kid7", 14, 123456, false);
        Kid kid8 = kidComponent.createNewKid("kid8", 14, 123456, false);
        kidComponent.createNewKid("john3", 14, 123456, false);
        kidComponent.createNewKid("john3", 14, 123456, false);
        kidComponent.createNewKid("john3", 14, 123456, false);
        kidComponent.createNewKid("john3", 14, 123456, false);
        kidComponent.createNewKid("john3", 14, 123456, false);
        kidComponent.createNewKid("john3", 14, 123456, false);
        kidComponent.createNewKid("john3", 14, 123456, false);
        kidComponent.createNewKid("john3", 14, 123456, false);
        kidComponent.createNewKid("john3", 14, 123456, false);
        kidComponent.createNewKid("john3", 14, 123456, false);
        kidComponent.createNewKid("johnVIP2", 14, 12342, true);
        kidComponent.createNewKid("johnVIP2", 14, 12342, true);
        for (Playground play : playgroundStorage.getObjectList()) {
            System.out.println(play.getPlaygroundName());
            playgroundComponent.enrollInQueue(play, kid);
            playgroundComponent.enrollInQueue(play, kid2);
            System.out.println(play.getPlaygroundQueue());
            playgroundComponent.acceptsQueue(play, kid3);
            playgroundComponent.acceptsQueue(play, kid4);
            playgroundComponent.acceptsQueue(play, kid6);
            playgroundComponent.acceptsQueue(play, kid7);
            playgroundComponent.acceptsQueue(play, kid8);
            playgroundComponent.acceptsQueue(play, kid5);
            System.out.println(play.getPlaygroundQueue());
            Thread.sleep(120000);
*//*            playgroundComponent.removeFromPlayground(play, kid);
            playgroundComponent.removeFromPlayground(play, kid2);*//*
            System.out.println(play.getPlaygroundQueue());
            playgroundComponent.removeFromPlayground(play, kid2);
            Thread.sleep(120000);
            playgroundComponent.removeFromPlayground(play, kid6);
            Thread.sleep(120000);
            playgroundComponent.removeFromPlayground(play, kid3);
            Thread.sleep(120000);
            playgroundComponent.removeFromPlayground(play, kid4);
            Thread.sleep(120000);
            playgroundComponent.removeFromPlayground(play, kid7);
            Thread.sleep(120000);
            playgroundComponent.removeFromPlayground(play, kid5);
            Thread.sleep(120000);
            playgroundComponent.removeFromPlayground(play, kid8);
            Thread.sleep(120000);
            playgroundComponent.removeFromPlayground(play, kid);

        };
        System.out.println(kidComponent.kidSessionsTodayInAllPlaygrounds());
        System.out.println(kidComponent.kidSessionsTodayInAllPlaygroundsCount());*/
    }
}
