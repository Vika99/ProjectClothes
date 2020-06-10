package Clothes.MenuWithGeneric;

import Clothes.Clothes;
import Clothes.ClothesFactory;
import Clothes.NotSimpleMenu.ScannerWrapper;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;




public class ReflectionFactory < E extends ClothesFactory> {
    private final List<Class<?>> classes;
    private ScannerWrapper sc = new ScannerWrapper();

    public ReflectionFactory(List<Class<?>> classes) {
        this.classes = classes;
    }

    public Object create() {
        System.out.println("Choose class");
        for (int i = 0; i < classes.size(); i++) {
            System.out.println((i + 1) + " " + classes.get(i).getSimpleName());
        }
        Class C = getClass();
        while (C != null) {
            System.out.println(C.getName());
            C = C.getSuperclass();


        }
        return null;
    }
}

       /* int choice = sc.nextInt();
        if (choice == 1) {
            try {
                Class<?> tclass = null;
                try {
                    tclass = Class.forName("src/Clothes/Tshirt.java");
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                }
                Field[] declaredFields = tclass.getDeclaredFields();
                for (Field field : declaredFields) {
                    System.out.println(field);

                }

            }else{
                try {
                    Class<?> jclass = null;
                    try {
                        jclass = Class.forName("src/Clothes/Jeans.java");
                    } catch (ClassNotFoundException e) {
                        e.printStackTrace();
                    }
                    Field[] declaredFields = jclass.getDeclaredFields();
                    for (Field field : declaredFields) {
                        System.out.println(field);

                    }

                    return null;
                }
            }
        }

    }
}
*/
//Поскольку в Java отсутствует множественное наследование,
// то для получения всех предков следует рекурсивно вызвать метод getSuperclass() в цикле,
// пока не будет достигнут Object, являющийся родителем всех классов. Object не имеет родителей,
// поэтому вызов его метода getSuperclass() вернет null.

/*  ::
public static List<Class> getSuperClasses(Object o) {
  List<Class> classList = new ArrayList<Class>();
  Class class= o.getClass();
  Class superclass = class.getSuperclass();
  classList.add(superclass);
  while (superclass != null) {
    class = superclass;
    superclass = class.getSuperclass();
    classList.add(superclass);
  }
  return classList;
}
 */


