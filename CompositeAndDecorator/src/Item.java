import java.util.Collection;

abstract class Item implements Container {
    @Override
    public int size() {
        return 1;
    }

    @Override
    public Container duplicate(int factor) {
        return new Crate(factor, this);
    }

    @Override
    public void collect(Collection<Item> warehouse) {
        warehouse.add(this);

    }
}
