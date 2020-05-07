package Clothes.MenuWithGeneric;

public class AddMenuItem  <T>implements MenuItem <T>{
    private GenericContainer<T> container;
    private Factory<T> factory;

    public AddMenuItem(GenericContainer<T> container, Factory<T> factory) {
        this.container = container;
        this.factory = factory;
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
