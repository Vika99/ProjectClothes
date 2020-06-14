package Clothes.MenuWithGeneric;

import Clothes.Jeans;
import Clothes.NotSimpleMenu.ScannerWrapper;
import Clothes.Tshirt;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.List;


public class ReflectionFactory  {
    private final List<Class<?>> classes;
    private ScannerWrapper sc = new ScannerWrapper();


    public ReflectionFactory(List<Class<?>> classes) {
        this.classes = classes;
    }


    public Object create() throws IllegalAccessException, NoSuchMethodException, InvocationTargetException, InstantiationException {
        System.out.println("Choose class");
        for (int i = 0; i < classes.size(); i++) {
            System.out.println((i + 1) + " " + classes.get(i).getSimpleName());
        }
        new ReflectionFactory(List.of(Tshirt.class, Jeans.class));


        int n = sc.nextInt();
        Class C = classes.get(n-1);
        Object instance = C.getConstructor().newInstance();
        Field[] fields = C.getFields();
                for (Field field : fields) {
                    Class<?> fld = field.getType();
                    field.setAccessible(true);
                    System.out.println("Class name:"+ field.getName());
                    System.out.println("Class type:"+ fld.getName());

                    Object value = field.get(instance);
                    field.set(instance, value);



                }
            return instance;

        }

    }


