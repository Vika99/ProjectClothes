package Clothes.MenuWithGeneric;

import java.util.Scanner;

public class DeleteMenuItem <T> implements MenuItem<T>{
    private GenericContainer<T> container;
    private Scanner sc = new Scanner(System.in);

    public DeleteMenuItem(GenericContainer<T> container) {
        this.container = container;
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
