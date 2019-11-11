package com.playground.datastorage;

import com.playground.kids.KidPlayedSession;

import java.util.UUID;

public interface KidPlayedSessionStorage extends GenericStorage<KidPlayedSession> {

    public KidPlayedSession findSessionByUUID(UUID uuid);

    public void removeFromSessions(KidPlayedSession kidPlayedSession);
}
