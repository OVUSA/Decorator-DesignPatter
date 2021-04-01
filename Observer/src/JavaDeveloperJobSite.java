import java.util.ArrayList;
import java.util.List;

public class JavaDeveloperJobSite implements Observed{

    List<String> positions = new ArrayList<>();
    List<Observer>subscribers = new ArrayList<>();


    public void addPosition(String position){
        positions.add(position);
        notifyObservers();
    }
    public void removePosition(String position){
        positions.remove(position);
        notifyObservers();
    }
    @Override
    public void addObserver(Observer observer) {

    }

    @Override
    public void removeObserver(Observer observer) {

    }

    @Override
    public void notifyObservers() {

    }
}
