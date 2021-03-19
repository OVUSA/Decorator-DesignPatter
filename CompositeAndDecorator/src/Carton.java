import java.lang.reflect.Array;
import java.util.Collection;
import java.util.List;
// the following class is collecting up multiple Containers of 3D printed items.
public class Carton implements Container {


    private final List <Container> contents;

    public Carton(final Carton ...contents){
        this.contents = Array.asList(contents);
    }

    public List<Container> getContents(){
        return contents;
    }


    // the method calls each item's size and sum it up together.
    @Override
    public int size() {
        int amount = 0;
        for (Container x: getContents()){
            amount +=x.size();
        }
        return amount;
    }

    @Override
    public Container duplicate(int factor) {
        return new Crate (factor, this);
    }

    @Override
    public void collect(Collection<Item> warehouse) {
      for ( Container c : getContents()){
          c.collect(warehouse);
      }

    }
}
