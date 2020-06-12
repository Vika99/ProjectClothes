package Clothes.MenuWithGeneric;

import Clothes.Jeans;
import Clothes.NotSimpleMenu.ScannerWrapper;
import Clothes.Tshirt;

import java.lang.reflect.Field;
import java.util.List;



public class ReflectionFactory  {
    private final List<Class<?>> classes;
    private ScannerWrapper sc = new ScannerWrapper();

    public ReflectionFactory(List<Class<?>> classes) {
        this.classes = classes;
    }

    public Object create() {
        System.out.println("Choose class");
        for (int i = 0; i < classes.size(); i++) {
            System.out.println((i + 1) + " " + classes.get(i).getSimpleName());
            Tshirt tshirt = new Tshirt();
            Jeans jeans = new Jeans();
        }
        /*new ReflectionFactory(List.of(Tshirt.class, Jeans.class));
        Tshirt.class.getFields();
        Jeans.class.getFields();
*/

        Class C =getClass();
            while (classes != null) {
                System.out.println(C.getName());
                C = C.getSuperclass();
                Field[] fields = C.getFields();
                for (Field field : fields) {
                    Class<?> fld = field.getType();
                    System.out.println("Class name:"+ field.getName());
                    System.out.println("Class type:"+ fld.getName());
                }

            }
            return null;

        }

    }


//Поскольку в Java отсутствует множественное наследование,
// то для получения всех предков следует рекурсивно вызвать метод getSuperclass() в цикле,
// пока не будет достигнут Object, являющийся родителем всех классов. Object не имеет родителей,
// поэтому вызов его метода getSuperclass() вернет null.



