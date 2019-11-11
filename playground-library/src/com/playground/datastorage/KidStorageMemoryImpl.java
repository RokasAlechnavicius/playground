package com.playground.datastorage;

import com.playground.kids.Kid;

import java.util.List;

public class KidStorageMemoryImpl implements KidStorage {


    @Override
    public List<Kid> getObjectList() {
        return ObjectLists.allKids;
    }

    @Override
    public void addObject(Kid object) {
        ObjectLists.allKids.add(object);
    }
}
