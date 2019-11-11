package com.playground.datastorage;

import com.playground.playgrounds.Playground;

import java.util.List;

public class PlaygroundStorageMemoryImpl implements PlaygroundStorage {


    @Override
    public List<Playground> getObjectList() {
        return ObjectLists.playgrounds;
    }

    @Override
    public void addObject(Playground object) {
        ObjectLists.playgrounds.add(object);
    }


}
