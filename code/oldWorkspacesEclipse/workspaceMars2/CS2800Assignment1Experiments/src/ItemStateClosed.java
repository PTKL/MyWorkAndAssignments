
public class ItemStateClosed
implements ItemState {
    @Override
    public void add(Item itemToAdd) {
    }

    @Override
    public final boolean isOpen() {
        return false;
    }
}

