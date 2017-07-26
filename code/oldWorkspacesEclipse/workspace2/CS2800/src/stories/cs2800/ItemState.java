package stories.cs2800;

import stories.cs2800.Item;

public interface ItemState {
    void add(Item itemToAdd);

    boolean isOpen();
}
