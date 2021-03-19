import java.util.Collection;

public interface Container {

    int size();// #of 3D printed items in the Container.
    Container duplicate(int factor);// duplicate the number of Items by the factor, presumably 3D printing item.

    void collect(Collection<Item> warehouse);// move all 3D printed Item in the Container into the given warehouse.

}
