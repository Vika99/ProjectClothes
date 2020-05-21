package Clothes.MenuWithGeneric;

import Clothes.Clothes;
import Clothes.NotSimpleMenu.Container;
import Clothes.NotSimpleMenu.LocalContainer;

import java.util.Scanner;

public class DeleteMenuItem <T> implements MenuItem<T>{
    private LocalContainer<T> container;
    private Scanner sc = new Scanner(System.in);

    public DeleteMenuItem(Container<Clothes<?>> container) {
        this.container = (LocalContainer<T>) container;
    }

    @Override
    public int getOrder() {
        return 2;
    }

    @Override
    public String getTitle() {
        return "Delete element";
    }

    @Override
    public void execute() {
        System.out.println("Input index");
        int choice = sc.nextInt();

        container.delete(choice);
    }
}
