package Clothes.NotSimpleMenu;

import Clothes.ClothesContainer;
import Clothes.ClothesFactory;

public class ComplexMenuMain {
    public static void main(String[] args) throws Exception {
        ClothesContainer container = new ClothesContainer();
        ClothesFactory factory = new ClothesFactory();

        IMenuItem[] innerMenu = {
                new PrintAllMenuItem(container),
                new PrintAllMenuItem(container)
        };

        IMenuItem[] array = {
                new AddMenuItem(container,factory),
                new DeleteMenuItem(container),
                new PrintAllMenuItem(container),
                new SerializationMain(container,factory),
                new Save(container, factory),
                new Load(container,factory),
                new TopLevelMenu(innerMenu, "inner menu", 8)
        };

        new TopLevelMenu(array, "top menu", 0).run();
    }
}
