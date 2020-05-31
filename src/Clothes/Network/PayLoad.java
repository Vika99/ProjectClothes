package Clothes.Network;

import java.io.Serializable;

public class PayLoad implements Serializable {
    int index;
    String element;

    public PayLoad() {
        this.index = index;
        this.element=element;
    }



    public int getIndex() {
        return index;
    }

    public String getElement() {
        return element;
    }
}
