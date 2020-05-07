package Clothes.MenuWithGeneric;

public class PrintAll <T> implements MenuItem<T> {
    private GenericContainer<T> container;

    public PrintAll(GenericContainer<T> container) {
        this.container = container;
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

