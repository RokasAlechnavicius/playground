package com.playground.playgrounds;

import com.playground.kids.Kid;

import java.util.List;

public class DoubleSwingsPlayground extends Playground {
    public static final Integer DOUBLE_SWINGS_SIZE = 2;

    public DoubleSwingsPlayground() {
        super();
    }

    public DoubleSwingsPlayground(String playgroundName, String typeOfPlayground) {
        super(playgroundName, DOUBLE_SWINGS_SIZE, typeOfPlayground);
    }
    @Override
    public Integer calculateUtilization() {
        return this.getKidsCurrentlyPlaying().size() == 2 ? 100 : 0;
    }
}
