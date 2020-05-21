package Clothes.MenuWithGeneric;

import Clothes.Clothes;
import Clothes.NotSimpleMenu.Container;
import Clothes.NotSimpleMenu.LocalContainer;

public class AddMenuItem  <T>implements MenuItem <T>{
    private LocalContainer<T> container;
    private Factory<T> factory;

    public AddMenuItem(Container<Clothes<?>> container, Factory<Clothes> factory) {
        this.container = (LocalContainer<T>) container;
        this.factory = (Factory<T>) factory;
    }

    @Override
    public int getOrder() {
        return 1;
    }

    @Override
    public String getTitle() {
        return "Add element";
    }

    @Override
    public void execute() {
        container.add(factory.create());
    }
}
