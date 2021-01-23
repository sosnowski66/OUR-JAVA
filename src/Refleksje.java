import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Refleksje {

    public static void printEmptyLine() {
        System.out.println();
    }

    public static void printSeparator() {
        System.out.println("--------------------------");
    }

    public static String getMethodParameterTypes(Method method) {
        return Arrays
                .stream(method.getParameterTypes())
                .map(Class::getSimpleName)
                .collect(Collectors.joining(", "));
    }

    public static String getMethodExceptions(Method method) {
        return Arrays
                .stream(method.getExceptionTypes())
                .map(Class::getSimpleName)
                .collect(Collectors.joining(", "));
    }

    public static void main(String[] args) {

        if (args.length == 0) {
            System.err.println("Podaj nazwę kalsy jako argument programu");
            System.exit(1);
        }

        try {
            Class<?> clazz = Class.forName(args[0]);

            printSeparator();
            System.out.println("KLASA: ");
            printSeparator();

            System.out.println("Nazwa klasy: " + clazz.getSimpleName());
            System.out.println("Modyfikator klasy: " + Modifier.toString(clazz.getModifiers()));
            printEmptyLine();

            printSeparator();
            System.out.println("Pola klasy:");
            printSeparator();

            Arrays
                    .asList(clazz.getDeclaredFields())
                    .forEach(field -> {
                        System.out.println("Nazwa: " + field.getName());
                        System.out.println("Typ: " + field.getType().getSimpleName());
                        System.out.println("Modyfikatory: " + Modifier.toString(field.getModifiers()));
                        printEmptyLine();
                    });

            printSeparator();
            System.out.println("METODY: ");
            printSeparator();

            Arrays
                    .asList(clazz.getDeclaredMethods())
                    .forEach(method -> {
                        System.out.println("Nazwa: " + method.getName());
                        System.out.println("Typ zwracany: " + method.getReturnType().getSimpleName());
                        System.out.println("Modyfikatory: " + Modifier.toString(method.getModifiers()));
                        System.out.println("Typy argumentów: " + getMethodParameterTypes(method));
                        System.out.println("Rzucane wyjątki: " + getMethodExceptions(method));
                        printEmptyLine();
                    });




        } catch (ClassNotFoundException e) {
            System.err.println("Nie udało się odnaleźć klasy");
        }

    }

}
