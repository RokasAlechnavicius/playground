package com.playground.datastorage;

import com.playground.kids.Kid;

import java.util.List;

public interface GenericStorage<T> {

    public List<T> getObjectList();

    public void addObject(T object);
}
