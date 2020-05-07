package Clothes.MenuWithGeneric;

import Clothes.Clothes;

public interface Factory <T> {

    T create();
}