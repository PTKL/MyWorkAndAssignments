

import java.util.ArrayList;


public class ItemStateOpen
implements ItemState {
    private ArrayList<Item> children;

    public ItemStateOpen(ArrayList<Item> argChildrenToAdd) {
        this.children = argChildrenToAdd;
    }

    @Override
    public final void add(Item itemToAdd) {
        children.add(itemToAdd);
    }

    @Override
    public final boolean isOpen() {
        return true;
    }
}

