import java.util.List;

public interface EventInterface {
    List<EventBean> getAllEvents();
    void addContent();
    void outputDB();
}
