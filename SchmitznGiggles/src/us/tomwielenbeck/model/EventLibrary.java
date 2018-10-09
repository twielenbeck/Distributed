package us.tomwielenbeck.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class EventLibrary
{
    /**
     * Event list constructor:
     * @param String name, String description, double price, Date date, Enum genre, Enum location, String image
     */
    private int productincrementer = 1;
    private List<Event> eventList = Arrays.asList
            (
                    new Event(productincrementer++,"Sketch 22", "The night before the show, " +
                            "10 groups of writers get randomly assigned topics for 10 comedy sketches. " +
                            "The next morning, the writers present the scripts and ten directors randomly " +
                            "select which sketch and which actors they’ll direct. " +
                            "Just 22 hours after the writers get their topics, " +
                            "the sketches are performed live in a one-time show!", 10.00,
                            "01/19/19 07:30 PM", EventGenre.COMEDY, EventLocation.COMEDYSPORTZ, "sketch22"),
                    new Event(productincrementer++,"Comedy of Othello","Written and directed by Patrick Schmitz " +
                            "starring the Shakesparody players the Comedy of Othello, Kinda sorta is bound to " +
                            "betray your sense of humor.", 12.00, "08/11/19 07:30 PM", EventGenre.COMEDY,
                            EventLocation.NEXTACT, "othello"),
                    new Event(productincrementer++, "Katelyn's Wasteland", "A new drama by Patrick Schmitz: " +
                            "When Katelyn's cancer " +
                            "goes into remission she must reconnect with the family she abandoned, or move on and " +
                            "accept that you can never go home. Based on true events and T.S. Eliot's 'The Wasteland'.",
                            11.00, "06/19/19 07:30 PM", EventGenre.DRAMA, EventLocation.ALCHEMIST, "katewasteland"),
                    new Event(productincrementer++, "Comedy of Macbeth", "Macbeth is a cool play.",
                            15.00, "08/09/19 07:30 PM", EventGenre.COMEDY, EventLocation.NEXTACT, "macbeth"),
                    new Event(productincrementer++, "Merlin", "A sketch parody based on the Merlin folklore.",
                            8.00, "04/19/19 07:30 PM", EventGenre.COMEDY, EventLocation.UNDERGROUND, "merlin"),
                    new Event(productincrementer++, "Who Dunnit Halloween Show", "Join Patrick Schmitz " +
                            "and some of Milwaukee's best improvisers (Robby McGhee, Tim Higgins, Laura Holterman, " +
                            "Max Bord, Liv Shircel, Josh Decker, and more) Each improviser secretly picks a number " +
                            "card which will determine the order the characters will die and one will have also " +
                            "selected a killer card so not even the performers will know who the killer is until the end. \n" +
                            "It all happens on Friday, October 26th at 7pm at Comedy Sportz. Tickets are $10 and can be purchased at the door.",
                            10.00, "10/26/18 07:00 PM", EventGenre.IMPPROV, EventLocation.COMEDYSPORTZ, "whodunnit")
            );
    public Event getEventByName(String name)
    {
        Event theEvent = null;

        for (Event e : eventList)
        {
            if (e.getName().equals(name))
            {
                theEvent = e;
            }
        }
        return theEvent;
    }

    public List<Event> getAllEvents(){
        return eventList;
    }

    public List<Event> searchEvents(String search)
    {
        search = search.toLowerCase();
        List<Event> searchList = new ArrayList<>();
        for (Event name : eventList)
        {
            if (name.getName().toLowerCase().contains(search))
            {
                searchList.add(name);
            }
        }
        return searchList;
    }
    public Event getSingleEvent(int itemNum) {
        Event item=null;

        for(Event i: eventList) {
            if (i.getProductNumber() == itemNum) {
                return i;
            }
        }
        return item;
    }
}
