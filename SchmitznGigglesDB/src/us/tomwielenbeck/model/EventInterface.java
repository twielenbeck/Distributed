package us.tomwielenbeck.model;

import java.util.List;

public interface EventInterface {
    List<Event> getAllEvents();
    Event getEventByName(String name);
    List<Event> searchEvents(String search);
    Event getSingleEvent(int itemNum);
    void addContent();
    void deleteContent();
    void updateContent();
}
