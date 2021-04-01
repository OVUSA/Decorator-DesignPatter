import java.util.List;

public class Subscriber implements Observer{

    String name;

    public Subscriber(String name){
        this.name = name;
    }

    @Override
    public void handleEvent(List<String> positions) {
        System.out.println("Dear "+ name+ ". We updated the list of positions, you can loot at the list here: " + positions);
        System.out.println("==================================================");


    }
}
