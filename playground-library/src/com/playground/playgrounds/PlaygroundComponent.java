package com.playground.playgrounds;

import com.playground.kids.Kid;

import java.util.List;

public interface PlaygroundComponent {


    public String enrollInQueue(Playground playground, Kid kid);

    public String acceptsQueue(Playground playground, Kid kid);

    public String removeFromQueue(Playground playground, Kid kid);

    public String removeFromPlayground(Playground playground, Kid kid);

    public Playground createPlayground(String playgroundName, Integer amountOfKidsAllowed, String typeOfPlayground);

    public DoubleSwingsPlayground createDoubleSwingsPlayground(String playgroundName, String typeOfPlayground);

}
