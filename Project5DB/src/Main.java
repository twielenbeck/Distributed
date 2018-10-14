
public class Main {
    public static void main(String[] args) {

        CreateProject5DB db = new CreateProject5DB();
        EventInterface ei = new Events();
        ei.outputDB();
        ei.addContent();
        System.out.println("==========================");
        ei.outputDB();
    }

}