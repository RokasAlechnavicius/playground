package com.playground.datastorage;

import com.playground.kids.KidPlayedSession;
import com.playground.playgrounds.Playground;

import java.util.List;
import java.util.UUID;

public class KidPlayedSessionMemoryStorageImpl implements KidPlayedSessionStorage {


    @Override
    public List<KidPlayedSession> getObjectList() {
        return ObjectLists.sessions;
    }

    @Override
    public void addObject(KidPlayedSession object) {
        ObjectLists.sessions.add(object);
    }

    @Override
    public KidPlayedSession findSessionByUUID(UUID uuid) {
        return getObjectList().stream().filter(kidPlayedSession -> kidPlayedSession.getId().equals(uuid)).findAny().orElse(null);
    }

    @Override
    public void removeFromSessions(KidPlayedSession kidPlayedSession)
    {
        ObjectLists.sessions.remove(kidPlayedSession);
    }
}

