package com.playground.kids;

import com.playground.datastorage.GenericStorage;
import com.playground.datastorage.KidPlayedSessionStorage;
import com.playground.datastorage.KidStorage;
import com.playground.datastorage.PlaygroundStorage;
import com.playground.playgrounds.Playground;

import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class KidComponentImpl implements KidComponent {
    // returns if object was seem for the first time or not
    private KidStorage kidStorage;
    private PlaygroundStorage playgroundStorage;
    private KidPlayedSessionStorage kidPlayedSessionStorage;

    public KidComponentImpl(KidStorage kidStorage, PlaygroundStorage playgroundStorage, KidPlayedSessionStorage kidPlayedSessionStorage) {
        this.kidStorage = kidStorage;
        this.playgroundStorage = playgroundStorage;
        this.kidPlayedSessionStorage = kidPlayedSessionStorage;

    }

    public static <T> Predicate<T> distinctByKey(Function<? super T, ?> keyExtractor) {
        Set<Object> seen = ConcurrentHashMap.newKeySet();
        return t -> seen.add(keyExtractor.apply(t));
    }

    @Override
        public List<KidPlayedSession> kidSessionsTodayInAllPlaygrounds() {
        return getSessionsOfToday();
    }

    @Override
    public Integer kidSessionsTodayInAllPlaygroundsCount() {
        Date dayStart = getDayStart();
        Date dayEnd = getDayEnd();
        return (int) kidPlayedSessionStorage.getObjectList().stream()
                .filter(kidPlayedSession -> kidPlayedSession.getStartTime().after(dayStart))
                .filter(kidPlayedSession -> kidPlayedSession.getEndTime() == null || kidPlayedSession.getEndTime().before(dayEnd))
                .filter(distinctByKey(KidPlayedSession::getKid)).count();
    }

    private List<KidPlayedSession> getSessionsOfToday() {
        Date dayStart = getDayStart();
        Date dayEnd = getDayEnd();
        return kidPlayedSessionStorage.getObjectList().stream()
                .filter(kidPlayedSession -> kidPlayedSession.getStartTime().after(dayStart))
                .filter(kidPlayedSession -> kidPlayedSession.getEndTime() == null || kidPlayedSession.getEndTime().before(dayEnd))
                .collect(Collectors.toList());

    }

    private Date getDayStart() {
        Calendar dayStart = Calendar.getInstance();
        dayStart.set(Calendar.HOUR, -12);
        dayStart.set(Calendar.MINUTE, 0);
        dayStart.set(Calendar.SECOND, 0);
        dayStart.set(Calendar.MILLISECOND, 0);
        return dayStart.getTime();
    }

    private Date getDayEnd() {
        Calendar dayEnd = Calendar.getInstance();
        dayEnd.set(Calendar.HOUR, 11);
        dayEnd.set(Calendar.MINUTE, 59);
        dayEnd.set(Calendar.SECOND, 59);
        dayEnd.set(Calendar.MILLISECOND, 0);
        return dayEnd.getTime();
    }

    @Override
    public List<KidPlayedSession> getSessionsForSpecificKid(Kid kid) {
        return kidPlayedSessionStorage.getObjectList().stream()
                .filter(kidPlayedSession -> kidPlayedSession.getKid().equals(kid))
                .collect(Collectors.toList());
    }

    public Kid createNewKid(String name, Integer age, Integer ticketNumber, boolean isVipTicket) {
        Kid kid = new Kid(name, age, ticketNumber, isVipTicket);
        kidStorage.addObject(kid);
        return kid;
    }
}
