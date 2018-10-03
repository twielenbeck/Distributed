package us.tomwielenbeck.model;

public enum EventGenre
{
    DRAMA, COMEDY, IMPPROV;
    public static String toString(EventGenre enums) {
        String stringVal = null;
        switch(enums) {
            case DRAMA: stringVal = "Drama";break;
            case COMEDY: stringVal = "Comedy";break;
            case IMPPROV: stringVal = "Improv";break;
        }
        return stringVal;
    }
}
