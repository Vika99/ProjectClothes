package Clothes.MenuWithGeneric;

import Clothes.Clothes;
import Clothes.MenuWithGeneric.MenuItem;
import Clothes.NotSimpleMenu.Container;
import Clothes.NotSimpleMenu.LocalContainer;

public class PrintAll <T extends Comparable<T>> implements MenuItem<T> {
    private LocalContainer<T> container;

    public PrintAll(Container<Clothes<?>> container)

    {
        this.container = (LocalContainer<T>) container;
    }

    @Override
    public int getOrder() {
        return 3;
    }

    @Override
    public String getTitle() {
        return "Print all";
    }

    @Override
    public void execute() {
        container.printAll();
    }
}

