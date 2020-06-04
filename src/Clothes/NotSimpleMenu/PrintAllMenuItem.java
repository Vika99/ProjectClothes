
package Clothes.NotSimpleMenu;

import Clothes.ClothesContainer;
import Clothes.NotSimpleMenu.IMenuItem;

public class PrintAllMenuItem implements IMenuItem {


    private ClothesContainer container;

    public PrintAllMenuItem(ClothesContainer container) {
        this.container = container;
    }

    @Override
    public int getOrder() {
        return 4;
    }

    @Override
    public String getTitle() {
        return "Print all";
    }

    @Override
    public void execute() {

    }
}