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


    public Object create() throws IllegalAccessException {
        System.out.println("Choose class");
        for (int i = 0; i < classes.size(); i++) {
            System.out.println((i + 1) + " " + classes.get(i).getSimpleName());
        }
        new ReflectionFactory(List.of(Tshirt.class, Jeans.class));
        int n = sc.nextInt();
        Class C = classes.get(n);
                System.out.println(C.getName());
                C = C.getSuperclass();
                Field[] fields = C.getFields();
                for (Field field : fields) {
                    Class<?> fld = field.getType();
                    System.out.println("Class name:"+ field.getName());
                    System.out.println("Class type:"+ fld.getName());

                    field.setAccessible(true);

                    Object objectInstance = new Object();
                    Object value = field.get(objectInstance);
                    field.set(objectInstance, value);



                }
            return null;

        }

    }


