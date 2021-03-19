import java.util.Collection;
/*
complete the following class for representing multiples of the same sub-container in a
compact way. Concretely, a Crate node makes its contents (sub-container) appear howmany
times for the purpose of the operations size and collect. The size of each Crate node is the
actual size of the node’s contents times the multiplier; e.g., Crate(4, Carton(Gear, Flange))
has size 8.

 */
public class Crate implements Container {

    private final int howmany;
    private final Container contents;

    public Crate(final int howmany, final Container contents){
        this.howmany = howmany;
        this.contents = contents;
    }
    public int getMuntiplier(){
        return howmany;

    }
    public Container getContents(){
        return contents;
    }

    final Carton shippingCarton = new Carton(new Gear(), new Gear(), new Gear();
    new Carton (new Crate(1,new Gear()), new Crate(2,new Flange()));

    //here I took a size of content and multiplied it for howmany
    //idk why.
    @Override
    public int size() {
         return getContents().size()* howmany;
    }

    // to create a duplication we need to first create "create" which has many items
    //then need to multiply factor which is how many duplicate will be and
    // add the content you wish to duplicate

    @Override
    public Container duplicate(int factor) {
      // return new Crate (factor, this)  it is passed item (I guess);
        return new Crate(factor*getMuntiplier(),contents) ;
    }

    @Override
    public void collect(Collection<Item> warehouse) {
        for (int i = 0; i < getMuntiplier();i++){
            contents.collect(warehouse);
        }

    }
}
